// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class PrintExpressionNumber extends Matched {

    private Expression Expression;
    private Integer N2;

    public PrintExpressionNumber (Expression Expression, Integer N2) {
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
        this.N2=N2;
    }

    public Expression getExpression() {
        return Expression;
    }

    public void setExpression(Expression Expression) {
        this.Expression=Expression;
    }

    public Integer getN2() {
        return N2;
    }

    public void setN2(Integer N2) {
        this.N2=N2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expression!=null) Expression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintExpressionNumber(\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+N2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintExpressionNumber]");
        return buffer.toString();
    }
}
