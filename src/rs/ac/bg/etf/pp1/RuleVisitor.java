package rs.ac.bg.etf.pp1;
 import rs.ac.bg.etf.pp1.ast.PrintExpression;
 import rs.ac.bg.etf.pp1.ast.*;
 import org.apache.log4j.Logger;


import org.apache.log4j.*;
public class RuleVisitor extends VisitorAdaptor {
	int printCallCounter = 0;
	int varDeclCounter = 0;
	Logger log = Logger.getLogger(getClass());
	
	public void visit(PrintExpression print) {
		printCallCounter++;
		//log.info("Prepoznata naredba program");
	}
	public void visit(VarDecl vardecl) {
		varDeclCounter++;
	}
}
