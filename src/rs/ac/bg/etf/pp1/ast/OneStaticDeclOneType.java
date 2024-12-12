// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class OneStaticDeclOneType extends VarDeclarationsStatic {

    private VarItemStatic VarItemStatic;

    public OneStaticDeclOneType (VarItemStatic VarItemStatic) {
        this.VarItemStatic=VarItemStatic;
        if(VarItemStatic!=null) VarItemStatic.setParent(this);
    }

    public VarItemStatic getVarItemStatic() {
        return VarItemStatic;
    }

    public void setVarItemStatic(VarItemStatic VarItemStatic) {
        this.VarItemStatic=VarItemStatic;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarItemStatic!=null) VarItemStatic.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarItemStatic!=null) VarItemStatic.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarItemStatic!=null) VarItemStatic.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneStaticDeclOneType(\n");

        if(VarItemStatic!=null)
            buffer.append(VarItemStatic.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneStaticDeclOneType]");
        return buffer.toString();
    }
}
