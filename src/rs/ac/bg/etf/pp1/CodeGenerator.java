package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FactorNumber;
import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.PrintExpression;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	
	
	public void visit(PrintExpression print) {
		if(print.getExpression().obj.getType() == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}else if(print.getExpression().obj.getType() == Tab.charType) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}else {
			Obj arraySize = new Obj(Obj.Var, "arraySize", new Struct(Struct.Int),0,3);
			Obj arrayAddr = new Obj(Obj.Var, "adr", new Struct(Struct.Int),1,3);
			Obj index = new Obj(Obj.Var, "index", new Struct(Struct.Int),2,3);
			
			
			// push adr niza.
			Code.store(arrayAddr);
			Code.loadConst(0);
			Code.store(index);
			Code.load(arrayAddr);

			Code.put(Code.arraylength);
			Code.store(arraySize);
			
			//empty stack
			
			//telo
			Code.load(arrayAddr);
			Code.load(index);
			Code.put(Code.aload);
			
			Code.loadConst(5);
			Code.put(Code.print);

			//index + 1
			Code.load(index);
			Code.put(Code.const_1);
			Code.put(Code.add);
			Code.store(index);
			
			//broj elemenata - 1
			Code.load(arraySize);
			Code.put(Code.const_1);
			Code.put(Code.sub);
			Code.store(arraySize);
			Code.load(arraySize);
			
			// if broj elemenata > 0 jmp to loop start
			Code.loadConst(0);
			Code.putFalseJump(3,207);
			
		}
	}
	
	public void visit(ReadDesignator readDesignator) {
		if(readDesignator.getDesignator().obj.getType() == (Tab.charType)) {
			Code.put(Code.bread);
		}else if(readDesignator.getDesignator().obj.getType() == (Tab.intType)) {
			Code.put(Code.read);
		}
		Code.store(readDesignator.getDesignator().obj);
	}
	
	public void visit(FactorNumber num) {
		Obj con = Tab.insert(Obj.Con, "$", num.obj.getType());
		con.setLevel(0);
		con.setAdr(num.getValue());
		
		Code.load(con);
	}
	
	public void visit(FactorChar ch) {
		Obj con = Tab.insert(Obj.Con, "$", ch.obj.getType());
		con.setLevel(0);
		con.setAdr(ch.getValue());
		
		Code.load(con);
	}
	
	public void visit(NumberConstant num) {
		Obj con = Tab.insert(Obj.Con, "$", num.obj.getType());
		con.setLevel(0);
		con.setAdr(num.getValue());
		
		Code.load(con);
		
	}
	
	public void visit(CharConstant ch) {
		Obj con = Tab.insert(Obj.Con, "$", ch.obj.getType());
		con.setLevel(0);
		con.setAdr(ch.getValue());
		
		Code.load(con);
	}
	
	public void visit(MethodTypeName method) {
		if("main".equalsIgnoreCase(method.getMethodName())) {
			mainPc = Code.pc;
		}
		method.obj.setAdr(Code.pc);
		
		// Collect arguments and local variables
		SyntaxNode sn = method.getParent();
		
		VarCounter varCnt = new VarCounter();
		sn.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		sn.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	}
	
	public void visit(MethodDeclaration methDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(AssignDesignator assign) {
		Code.store(assign.getDesignator().obj);
	}
	
	public void visit(IncrementDesignator incDes) {
		if(incDes.getDesignator().obj.getKind() == Obj.Var && incDes.getDesignator().obj.getLevel() == 1) {
			Code.put(Code.inc);
			Code.put(incDes.getDesignator().obj.getAdr());
			Code.put(1);
		}else if(incDes.getDesignator() instanceof ArrayDesignator) {
//			incDes.getDesignator().traverseBottomUp(this);
//			Code.load(incDes.getDesignator().obj);
//			Code.put(Code.const_1);
//			Code.put(Code.add);
//			Code.store(incDes.getDesignator().obj);
			
			
//			Obj index = new Obj(Obj.Var,"",new Struct(Struct.Int),0,3);
//			Obj arr = new Obj(Obj.Var, "", new Struct(Struct.Array),1,3);
//			Obj val = new Obj(Obj.Var, "", new Struct(Struct.Array),2,3);
//			
//			Code.store(index);
//			Code.store(arr);
//			Code.load(arr);
//			Code.load(index);
//			Code.put(Code.aload);
//			Code.put(Code.const_1);
//			Code.put(Code.add);
//			Code.store(val);
//			Code.load(arr);
//			Code.load(index);
//			Code.load(val);
//			Code.store(incDes.getDesignator().obj);
			
			Code.put(Code.dup2);
			Code.put(Code.aload);
			Code.put(Code.const_1);
			Code.put(Code.add);
			Code.store(incDes.getDesignator().obj);
			
		}
	}
	
	public void visit(DecrementDesignator incDes) {
		if(incDes.getDesignator().obj.getKind() == Obj.Var && incDes.getDesignator().obj.getLevel() == 1) {
			Code.put(Code.inc);
			Code.put(incDes.getDesignator().obj.getAdr());
			Code.put(-1);
		}else if(incDes.getDesignator() instanceof ArrayDesignator) {
			Code.put(Code.dup2);
			Code.put(Code.aload);
			Code.put(Code.const_1);
			Code.put(Code.sub);
			Code.store(incDes.getDesignator().obj);
		}
	}
	
	public void visit(AddopExpr exprAddTerm) {
		if(exprAddTerm.getAddop() instanceof AddopPLUS) {
			Code.put(Code.add);
		}else {
			Code.put(Code.sub);
		}
	}
	
	public void visit(MulopTerm termMulFactor) {
		if(termMulFactor.getMulop() instanceof MulopMUL) {
			Code.put(Code.mul);
		}else if(termMulFactor.getMulop() instanceof MulopDIV) {
			Code.put(Code.div);
		}else {
			Code.put(Code.rem);
		}
	}
	
	public void visit(FactorNEWExpr arr) {
		Struct type = arr.getType().obj.getType();
		Code.put(Code.newarray);
		Code.put(type.getKind() == Struct.Char ? 0 : 1);
	}
	
	public void visit(FactorRange range) {
		Obj arraySize = new Obj(Obj.Var, "arraySize", new Struct(Struct.Int),0,3);
		Obj arrayAddr = new Obj(Obj.Var, "adr", new Struct(Struct.Int),1,3);
		Obj index = new Obj(Obj.Var, "index", new Struct(Struct.Int),2,3);
		Code.store(arraySize);
		Code.load(arraySize);
		Code.put(Code.newarray);
		Code.put(1);
		// push adr niza.
		Code.store(arrayAddr);
		Code.loadConst(0);
		Code.store(index);
		
		//telo
		Code.load(arrayAddr);
		Code.load(index);
		Code.load(index);
		Code.put(Code.astore);

		//index + 1
		Code.load(index);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(index);
		
		//broj elemenata - 1
		Code.load(arraySize);
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(arraySize);
		Code.load(arraySize);
		
		// if broj elemenata > 0 jmp to loop start
		Code.loadConst(0);
		Code.putFalseJump(3,177);
		
		Code.load(arrayAddr);
	}
	
	
	public void visit(FactorDesignator design) {
		Code.load(design.obj);
	}
	
	/*********/
	
	public void visit(LBrackOpen lbrack) {
		Code.load(lbrack.getParent() instanceof ArrayDesignator
				? ((ArrayDesignator)lbrack.getParent()).getDesignatorLeft().obj
				: ((BracketsDesignator)lbrack.getParent()).getDesignatorLeft().obj);
	}

	
	/**********/
	
	public void visit(MinusTermExpression minusTerm) {
		Code.put(Code.neg);
	}
}





















