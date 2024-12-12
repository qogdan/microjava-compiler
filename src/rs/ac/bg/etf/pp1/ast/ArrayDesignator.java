// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class ArrayDesignator extends Designator {

    private DesignatorLeft DesignatorLeft;
    private LBrackOpen LBrackOpen;
    private Expression Expression;

    public ArrayDesignator (DesignatorLeft DesignatorLeft, LBrackOpen LBrackOpen, Expression Expression) {
        this.DesignatorLeft=DesignatorLeft;
        if(DesignatorLeft!=null) DesignatorLeft.setParent(this);
        this.LBrackOpen=LBrackOpen;
        if(LBrackOpen!=null) LBrackOpen.setParent(this);
        this.Expression=Expression;
        if(Expression!=null) Expression.setParent(this);
    }

    public DesignatorLeft getDesignatorLeft() {
        return DesignatorLeft;
    }

    public void setDesignatorLeft(DesignatorLeft DesignatorLeft) {
        this.DesignatorLeft=DesignatorLeft;
    }

    public LBrackOpen getLBrackOpen() {
        return LBrackOpen;
    }

    public void setLBrackOpen(LBrackOpen LBrackOpen) {
        this.LBrackOpen=LBrackOpen;
    }

    public Expression getExpression() {
        return Expression;
    }

    public void setExpression(Expression Expression) {
        this.Expression=Expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorLeft!=null) DesignatorLeft.accept(visitor);
        if(LBrackOpen!=null) LBrackOpen.accept(visitor);
        if(Expression!=null) Expression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorLeft!=null) DesignatorLeft.traverseTopDown(visitor);
        if(LBrackOpen!=null) LBrackOpen.traverseTopDown(visitor);
        if(Expression!=null) Expression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorLeft!=null) DesignatorLeft.traverseBottomUp(visitor);
        if(LBrackOpen!=null) LBrackOpen.traverseBottomUp(visitor);
        if(Expression!=null) Expression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayDesignator(\n");

        if(DesignatorLeft!=null)
            buffer.append(DesignatorLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LBrackOpen!=null)
            buffer.append(LBrackOpen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expression!=null)
            buffer.append(Expression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayDesignator]");
        return buffer.toString();
    }
}
