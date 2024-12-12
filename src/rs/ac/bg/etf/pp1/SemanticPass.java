package rs.ac.bg.etf.pp1;

import java.lang.invoke.MethodType;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class SemanticPass extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	SymbolTableVisitor visitor;
	boolean errorDetected=false;
	int nVars;
	
	public final Struct boolType = new Struct(Struct.Bool);
	
	
	
	
	Obj currentMethod = null; //fja cija se definicija trentno obradjuje
	//tamo gde otvorimo novi scope, i kad ulancavamo lokalne simbole, prosledicemo currentMethod object
	Struct currentMethodRetType = Tab.noType;
	boolean isCurrentMethodVoid = false;
	Struct currentType = Tab.noType;
	boolean returnFound = false;
	Obj currentDesignator = null;
	
	
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected=true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	private String printNode(Obj node) {
		visitor = new DumpSymbolTableVisitor();
		visitor.visitObjNode(node);
		return visitor.getOutput();
	}
	

	
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType); //vraca objekat tipa Obj ubacen u tabelu simbola
		//zelimo da imamo taj objekat, da bismo ga ulancali u opseg Programa, kada zavrsimo Program
		Tab.openScope();
	}
	
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	

	
					/* CONST DECLARATION */
	
	
	
	
	public void visit(ConstItem constItem) {
		if(Tab.find(constItem.getConstName())!=Tab.noObj) {
			report_error("Greska! Konstanta "  +  constItem.getConstName() + " je vec deklarisana!", constItem);
			return;
		}else {
			Obj constNode = Tab.insert(Obj.Con,  constItem.getConstName(), currentType);
			report_info("Deklarisana kostanta " + constItem.getConstName()+" " +printNode(constNode), constItem);
			if(!constItem.getConstants().obj.getType().assignableTo(constItem.getType().obj.getType())) {
				constNode.setAdr(0);
				report_error("Greska na liniji " + constItem.getLine() + " : nekompatibilni tipovi u dodeli vrednosti!", null);
			}else {
				constNode.setAdr(constItem.getConstants().obj.getAdr());
			}
		}
		
		
		
	}
	
	public void visit(NumberConstant num) {
		num.obj = new Obj(Obj.Con, "", Tab.intType, num.getValue(), 0);
	}
	
	public void visit(CharConstant chr) {
		chr.obj = new Obj(Obj.Con, "", Tab.charType, chr.getValue(), 0);
	}
	
	public void visit(BooleanConstant bool) {
		bool.obj = new Obj(Obj.Con, "", boolType, bool.getValue()?1:0, 0);
	}
	
	public void visit(ReadDesignator readDesign) {
		Struct destype = readDesign.getDesignator().obj.getType();
		if(!destype.equals(Tab.intType) && !destype.equals(Tab.charType) && !destype.equals(boolType)){
			report_error("Greska na liniji " + readDesign.getLine() + " : citanje neprimitvnog tipa!", null);

		}
	}
	
	
	
					/* METHOD DECLARATION */
	
	
	
	
	
	
	
	public void visit(MethodTypeName methTypeName) {
		Obj methodObj = Tab.find(methTypeName.getMethodName());
		if(methodObj == Tab.noObj) {
			methTypeName.obj = Tab.insert(Obj.Meth, methTypeName.getMethodName(), currentMethodRetType);
		}else {
			report_error("Greska! Funkcija sa imenom " + methTypeName.getMethodName() + "je vec deklarisana!", methTypeName);
			return;
		}
		currentMethod = methTypeName.obj;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methTypeName.getMethodName()	, methTypeName);
	}
	
	public void visit(MethReturnType methRetType) {
		
		currentMethodRetType = methRetType.getType().obj.getType();
		isCurrentMethodVoid = false;
	}
	
	public void visit (MethReturnVoid voidRetType) {
		currentMethodRetType = Tab.noType;
		isCurrentMethodVoid = true;
	}
	
	public void visit(MethodDeclaration methDecl) {
		if(!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methDecl.getLine() + " : funkcija " + currentMethod.getName() + " nema return iskaz.", null);
		}
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		returnFound = false;
		currentMethod = Tab.noObj;
	}
	
	
/////////////////// FORMAL PARAMETERS ////////////////////
	
	public void visit(VarFormParam params) {
		SyntaxNode sn2 = params.getBrackets();
		
		if(Tab.currentScope.findSymbol(params.getVarName())!=Tab.noObj) {
			report_error("Greska! Promenljiva " + params.getVarName() + "je vec deklarisana!", null);
			return;
		}
		
		if(WithBrackets.class.isInstance(sn2)) {
			Obj varNode = Tab.insert(Obj.Var, params.getVarName(), new Struct(Struct.Array, currentType));
			report_info("Deklarisan niz " + varNode.getName()+ " " + printNode(varNode)+params.getVarName(), null);
		}else
		{
			Obj varNode = Tab.insert(Obj.Var, params.getVarName(), currentType);
		     report_info("Deklarisana promenljiva "+varNode.getName()+" " +printNode(varNode), null);
		}
		
	}
	
	
	
	
					/* VAR DECLARATION */
	
	
	
	
	
	
	
	public void visit(VarItem varItem) {
		SyntaxNode sn2 = varItem.getBrackets();
		SyntaxNode sn1 = varItem;
		while(sn1.getClass()!=VarDeclaration.class) {
			sn1 = sn1.getParent();
		}
		if(Tab.find(varItem.getVarName())!=Tab.noObj) {
			report_error("Greska! Promenljiva " + varItem.getVarName() + "je vec deklarisana!", varItem);
			return;
		}
		VarDeclaration varDecl = (VarDeclaration) sn1;
		if(WithBrackets.class.isInstance(sn2)) {
			report_info("hehe" ,null);
			Obj varNode = Tab.insert(Obj.Var,varItem.getVarName(), new Struct(Struct.Array, currentType));
			report_info("Deklarisan niz " + varNode.getName()+ " " + printNode(varNode)+varItem.getVarName(), varDecl);
		}else
		{
			Obj varNode = Tab.insert(Obj.Var,varItem.getVarName(), currentType);
		     report_info("Deklarisana promenljiva "+ varNode.getName()+" " +printNode(varNode), varItem);
		}
	}
	
	public void visit(TypeIdent type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj) {
			if(type.getTypeName()=="bool") {
				Tab.insert(Obj.Type, type.getTypeName(),new Struct(Struct.Bool));
			}else {
				report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola!", null);
				type.obj = Tab.noObj;				
			}
		}else {
			if(Obj.Type == typeNode.getKind()) {
				type.obj = typeNode;
			}else {
				type.obj = new Obj(Obj.Type, type.getTypeName(), Tab.noType);
				report_error("Greska: Ime " + type.getTypeName() + " ne predsavlja tip!", type);
			}
			
		}
		currentType = type.obj.getType();
	}
	
	
	
	
	
	
						/* FUNCTION CALL */
	
	
	
	
	
	
	public void visit(FactorDesignatorMeth funcCall) {
		Obj func = funcCall.getDesignator().obj;
		if(Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.obj = func;
		}else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!", null);
			funcCall.obj = null;
		}
	}
	
	public void visit(TermNoMulop term) {
		term.obj = term.getFactor().obj;
	}
	
	public void visit(MinusTermExpression minusTerm) {
		if(!minusTerm.getTerm().obj.getType().equals(Tab.intType)) {
			minusTerm.obj = Tab.noObj;
			errorDetected = true;
		}else {
			minusTerm.obj = minusTerm.getTerm().obj;
		}
	}
	
	public void visit(TermExpression termExpr) {
		termExpr.obj = termExpr.getTerm().obj;
	}
	
	public void visit(AddopExpr addExpr) { //semanticka analiza
		Struct exprType = addExpr.getExpression().obj.getType();
		Struct termType = addExpr.getTerm().obj.getType();	
		if(exprType.equals(termType) && exprType == Tab.intType) {
			addExpr.obj = new Obj(Obj.Var, "", Tab.intType);
		}else {
			report_error("Greska na liniji " + addExpr.getLine() + " : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.obj = null;
		}
	}
	
	//term = term * factor
	public void visit(MulopTerm mulTerm) {
		Struct termType = mulTerm.getTerm().obj.getType();
		Struct factorType = mulTerm.getFactor().obj.getType();
		if(termType.equals(factorType) && termType == Tab.intType) {
			mulTerm.obj = new Obj(Obj.Var, "", Tab.intType);
		}else {
			report_error("Greska na liniji " + mulTerm.getLine() + " : nekompatibilni tipovi u izrazu za mnozenje.", null);
			mulTerm.obj = null;
		}
	}
	
	public void visit(IdentDesignator designator) {
		
			Obj obj = Tab.find(designator.getDesignatorName());
			if(obj == Tab.noObj) {
				report_error("Greska na liniji " + designator.getLine() + " : ime " + designator.getDesignatorName() + " nije deklarisano!", null);
			}
			designator.obj = obj;
			currentDesignator = obj;
	}
	

	
	public void visit(LeftIdentDesignator designator) {
		Obj obj = Tab.find(designator.getDesignatorName());
		if(obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine() + " : ime " + designator.getDesignatorName() + " nije deklarisano!", null);
		}
		designator.obj = obj;
		currentDesignator = obj;
	}
	

	
	public void visit(ArrayDesignator arrayDesignator) {
		Obj array = arrayDesignator.getDesignatorLeft().obj;
		if(array.getType().getKind() != Struct.Array) {
			report_error("Greska na liniji " + arrayDesignator.getLine() + " : ne indeksira se niz!!!", null);
			arrayDesignator.obj = Tab.noObj;
		}else {
			Struct indexType = arrayDesignator.getExpression().obj.getType();
			if(!indexType.equals(Tab.intType)) {
				report_error("Greska na liniji " + arrayDesignator.getLine() + " : index nije integer!", null);
			}
			arrayDesignator.obj = new Obj(Obj.Elem,"", array.getType().getElemType() != null ? array.getType().getElemType() : Tab.noType);
		}
	}
	
	public void visit(BracketsDesignator arrayDesignator) {
		Obj array = arrayDesignator.getDesignatorLeft().obj;
		if(array.getType().getKind() != Struct.Array) {
			report_error("Greska na liniji " + arrayDesignator.getLine() + " : ne indeksira se niz!!!", null);
			arrayDesignator.obj = Tab.noObj;
		}else {
			Struct indexType = arrayDesignator.getExpression().obj.getType();
			if(!indexType.equals(Tab.intType)) {
				report_error("Greska na liniji " + arrayDesignator.getLine() + " : index nije integer!", null);
			}
			arrayDesignator.obj = new Obj(Obj.Elem,"", array.getType().getElemType() != null ? array.getType().getElemType() : Tab.noType);
		}
	}

	public void visit(FactorNumber num) {
		num.obj = new Obj(Obj.Con, "", Tab.intType, num.getValue(), 0);
	}
	
	public void visit(FactorChar chr) {
		chr.obj = new Obj(Obj.Con, "", Tab.charType, chr.getValue(), 0);
	}
	
	public void visit(FactorBool bool) {
		bool.obj = new Obj(Obj.Con, "", boolType, bool.getValue() ? 1 : 0, 1);
	}
	
	public void visit(FactorDesignator var) {
		var.obj = var.getDesignator().obj;
	}
	
	public void visit(FactorExpression factorExpr) {
		if(factorExpr.getExpression().obj == null) {

			report_error("Semanticka greska na liniji " + factorExpr.getLine() + ": ne postoji zadati expression!", null);
		}
		factorExpr.obj = factorExpr.getExpression().obj;
	}
	
	public void visit(FactorNEWExpr newArr) {
		if(newArr.getExpression().obj.getType() != Tab.intType)
			report_error("Semanticka greska na liniji " + newArr.getLine() + ": velicina niza mora biti tipa integer!", null);
		newArr.obj = new Obj(Obj.Var, "", new Struct(Struct.Array, newArr.getType().obj.getType()));
	}
	
	public void visit(FactorRange range){
		if(range.getExpression().obj.getType() != Tab.intType)
			report_error("SEmanticka greska na liniji " + range.getLine() + ": velicina niza mora biti tipa integer!", null);
		range.obj = new Obj(Obj.Var, "", new Struct(Struct.Array, Tab.intType));
	}
	
	
	
	
	//////////////////////// KONTEKSTNI USLOVI //////////////////////
	
	
	public void visit(PrintExpression print) {
		if(print.getExpression().obj == Tab.noObj) {

		}
		else if( print.getExpression().obj.getType() != Tab.intType
				&& print.getExpression().obj.getType() != Tab.charType
				&& print.getExpression().obj.getType().getKind() != Struct.Array
				&& print.getExpression().obj.getType().getElemType().equals(Tab.intType))
			report_error("Semanticka greska na liniji " + print.getLine() + ": Operand instrukcije PRINT mora biti char, int tipa ili niz intova", null);
		
	}
	
	
	public void visit(ReturnExpressionStmt returnExpr) {
		returnFound = true;
		if(!currentMethodRetType.compatibleWith(returnExpr.getExpression().obj.getType())) {
			report_error("Greska na liniji : " + returnExpr.getLine() + " : tip izraza u return nardbi se ne slaze sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
		}
	}
	
	public void visit(AssignDesignator assignment) {
		if(assignment.getExpression().obj == null || assignment.getDesignator().obj == null) {
		}
		else if(!assignment.getExpression().obj.getType().assignableTo(assignment.getDesignator().obj.getType())) {
			report_error("Greska na liniji " + assignment.getLine() + " : nekompatibilni tipovi u dodeli vrednosti!", null);
		}
	}
	
	public void visit(IncrementDesignator incDes) {
		Struct desType = incDes.getDesignator().obj.getType(); 
		if(!(desType == Tab.intType)) {
			if(!(desType == Tab.noType) && !(desType.getKind() == Struct.Array && desType.getElemType().equals(Tab.noType))) {
				report_error("Greska na liniji " + incDes.getLine() + " : inkrementiranje tipa koji nije integer!", null);
			}else
				report_error("Greska na liniji " + incDes.getLine() + " : inkrementiranje tipa koji nije integer!", null);

		}
	}
	
	public void visit(DecrementDesignator decDes) {
		Struct desType = decDes.getDesignator().obj.getType(); 
		if(!desType.equals(Tab.intType)) {
			if(!desType.equals(Tab.noType) && !(desType.getKind() == Struct.Array && desType.getElemType().equals(Tab.noType))) {
				report_error("Greska na liniji " + decDes.getLine() + " : inkrementiranje tipa koji nije integer!", null);

			}
			else
				report_error("Greska na liniji " + decDes.getLine() + " : inkrementiranje tipa koji nije integer!", null);
		}
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
	
	
}
