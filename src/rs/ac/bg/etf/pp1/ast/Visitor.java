// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:35


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DeclarationList DeclarationList);
    public void visit(MethodDecl MethodDecl);
    public void visit(Mulop Mulop);
    public void visit(FirstThirdForLoop FirstThirdForLoop);
    public void visit(Matched Matched);
    public void visit(Relop Relop);
    public void visit(Constants Constants);
    public void visit(Namespace Namespace);
    public void visit(NamespaceName NamespaceName);
    public void visit(Assignop Assignop);
    public void visit(CondTermList CondTermList);
    public void visit(DCItem DCItem);
    public void visit(ForLoop ForLoop);
    public void visit(StaticInitializerList StaticInitializerList);
    public void visit(StatementList StatementList);
    public void visit(VarItemStatic VarItemStatic);
    public void visit(NamespaceList NamespaceList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(Resolve Resolve);
    public void visit(CondFactList CondFactList);
    public void visit(DesignatorCommaList DesignatorCommaList);
    public void visit(Designator Designator);
    public void visit(DesignatorLeft DesignatorLeft);
    public void visit(Term Term);
    public void visit(StaticVarDeclList StaticVarDeclList);
    public void visit(FormParsList FormParsList);
    public void visit(Condition Condition);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(FormParsItem FormParsItem);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(PrintList PrintList);
    public void visit(Brackets Brackets);
    public void visit(ExprList ExprList);
    public void visit(VarDeclarationsStatic VarDeclarationsStatic);
    public void visit(Vars Vars);
    public void visit(VarDeclList VarDeclList);
    public void visit(ElseList ElseList);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(VarDecls VarDecls);
    public void visit(SecondForLoop SecondForLoop);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(ClassDeclList ClassDeclList);
    public void visit(Statement Statement);
    public void visit(Expression Expression);
    public void visit(VarDecl VarDecl);
    public void visit(Type Type);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(StaticInitializer StaticInitializer);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(Declaration Declaration);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(FormPars FormPars);
    public void visit(StaticInitializers StaticInitializers);
    public void visit(ErrorVarDeclarations ErrorVarDeclarations);
    public void visit(MulopMOD MulopMOD);
    public void visit(MulopDIV MulopDIV);
    public void visit(MulopMUL MulopMUL);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPLUS AddopPLUS);
    public void visit(RelopLESSE RelopLESSE);
    public void visit(RelopLESS RelopLESS);
    public void visit(RelopGRTE RelopGRTE);
    public void visit(RelopGRT RelopGRT);
    public void visit(RelopNotEqual RelopNotEqual);
    public void visit(RelopEqual RelopEqual);
    public void visit(FactorRange FactorRange);
    public void visit(FactorNEWParam FactorNEWParam);
    public void visit(FactorNEWExpr FactorNEWExpr);
    public void visit(FactorExpression FactorExpression);
    public void visit(FactorDesignatorMeth FactorDesignatorMeth);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNumber FactorNumber);
    public void visit(MulopTerm MulopTerm);
    public void visit(TermNoMulop TermNoMulop);
    public void visit(AddopExpr AddopExpr);
    public void visit(TermExpression TermExpression);
    public void visit(MinusTermExpression MinusTermExpression);
    public void visit(MulExpression MulExpression);
    public void visit(OneExpression OneExpression);
    public void visit(NoActPars NoActPars);
    public void visit(ActParsExist ActParsExist);
    public void visit(OnlyCommaNoDesignator OnlyCommaNoDesignator);
    public void visit(DesignatorWithComma DesignatorWithComma);
    public void visit(OneDesignatorListClassObj OneDesignatorListClassObj);
    public void visit(MulDesignatorListClassObj MulDesignatorListClassObj);
    public void visit(LBrackOpen LBrackOpen);
    public void visit(BracketsDesignator BracketsDesignator);
    public void visit(LeftIdentDesignator LeftIdentDesignator);
    public void visit(ArrayDesignator ArrayDesignator);
    public void visit(IdentDesignator IdentDesignator);
    public void visit(RelationCondition RelationCondition);
    public void visit(ConditionNoRelation ConditionNoRelation);
    public void visit(NoANDCondition NoANDCondition);
    public void visit(ANDCondition ANDCondition);
    public void visit(NoORCondition NoORCondition);
    public void visit(ORCondition ORCondition);
    public void visit(StatementListInsideStatement StatementListInsideStatement);
    public void visit(IfElseStatement IfElseStatement);
    public void visit(IfStatement IfStatement);
    public void visit(PrintExpressionNumber PrintExpressionNumber);
    public void visit(PrintExpression PrintExpression);
    public void visit(ReadDesignator ReadDesignator);
    public void visit(ReturnExpressionStmt ReturnExpressionStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ContiunueStmt ContiunueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(ArrayPointerAssignDesignator ArrayPointerAssignDesignator);
    public void visit(DecrementDesignator DecrementDesignator);
    public void visit(IncrementDesignator IncrementDesignator);
    public void visit(MethodDesignator MethodDesignator);
    public void visit(AssignDesignator AssignDesignator);
    public void visit(ErrorAssign ErrorAssign);
    public void visit(MatchedStatements MatchedStatements);
    public void visit(DesignatorStatements DesignatorStatements);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementListWrap StatementListWrap);
    public void visit(Label Label);
    public void visit(TypeIdent TypeIdent);
    public void visit(StaticInitializerr StaticInitializerr);
    public void visit(OneStaticInit OneStaticInit);
    public void visit(MulStaticInit MulStaticInit);
    public void visit(NoStaticInitializer NoStaticInitializer);
    public void visit(StaticInitListWrap StaticInitListWrap);
    public void visit(NoBrackets NoBrackets);
    public void visit(WithBrackets WithBrackets);
    public void visit(StaticArrayIdent StaticArrayIdent);
    public void visit(StaticVariableIdent StaticVariableIdent);
    public void visit(OneStaticDeclOneType OneStaticDeclOneType);
    public void visit(MulStaticDeclOneType MulStaticDeclOneType);
    public void visit(VarItem VarItem);
    public void visit(OneDeclarationOneType OneDeclarationOneType);
    public void visit(MulDeclarationsOneType MulDeclarationsOneType);
    public void visit(ErrorBrackItem ErrorBrackItem);
    public void visit(VarDeclError VarDeclError);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(OneVarDeclarations OneVarDeclarations);
    public void visit(MulVarDeclarations MulVarDeclarations);
    public void visit(NoVarDeclaration NoVarDeclaration);
    public void visit(VarDeclarationListWrap VarDeclarationListWrap);
    public void visit(ErrorFormParamParen ErrorFormParamParen);
    public void visit(ErrorFormParamComma ErrorFormParamComma);
    public void visit(VarFormParam VarFormParam);
    public void visit(MulFormParam MulFormParam);
    public void visit(OneFormParam OneFormParam);
    public void visit(FormParsListDerived2 FormParsListDerived2);
    public void visit(FormParsListDerived1 FormParsListDerived1);
    public void visit(MethReturnVoid MethReturnVoid);
    public void visit(MethReturnType MethReturnType);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(NoMethodDeclaration NoMethodDeclaration);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(BooleanConstant BooleanConstant);
    public void visit(CharConstant CharConstant);
    public void visit(NumberConstant NumberConstant);
    public void visit(StVar StVar);
    public void visit(NoStaticVarDeclList NoStaticVarDeclList);
    public void visit(StaticVarDeclListt StaticVarDeclListt);
    public void visit(ConstItem ConstItem);
    public void visit(OneConstDeclaration OneConstDeclaration);
    public void visit(MulConstDeclarations MulConstDeclarations);
    public void visit(ConstDecll ConstDecll);
    public void visit(DeclarationVarr DeclarationVarr);
    public void visit(DeclarationConstt DeclarationConstt);
    public void visit(NoDeclarationLists NoDeclarationLists);
    public void visit(DeclarationListt DeclarationListt);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
