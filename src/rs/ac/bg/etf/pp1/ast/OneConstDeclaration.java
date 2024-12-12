// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class OneConstDeclaration extends ConstDeclarations {

    private ConstItem ConstItem;

    public OneConstDeclaration (ConstItem ConstItem) {
        this.ConstItem=ConstItem;
        if(ConstItem!=null) ConstItem.setParent(this);
    }

    public ConstItem getConstItem() {
        return ConstItem;
    }

    public void setConstItem(ConstItem ConstItem) {
        this.ConstItem=ConstItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstItem!=null) ConstItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstItem!=null) ConstItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstItem!=null) ConstItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneConstDeclaration(\n");

        if(ConstItem!=null)
            buffer.append(ConstItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneConstDeclaration]");
        return buffer.toString();
    }
}