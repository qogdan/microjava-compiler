// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class MulStaticDeclOneType extends VarDeclarationsStatic {

    private VarItemStatic VarItemStatic;
    private VarDeclarationsStatic VarDeclarationsStatic;

    public MulStaticDeclOneType (VarItemStatic VarItemStatic, VarDeclarationsStatic VarDeclarationsStatic) {
        this.VarItemStatic=VarItemStatic;
        if(VarItemStatic!=null) VarItemStatic.setParent(this);
        this.VarDeclarationsStatic=VarDeclarationsStatic;
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.setParent(this);
    }

    public VarItemStatic getVarItemStatic() {
        return VarItemStatic;
    }

    public void setVarItemStatic(VarItemStatic VarItemStatic) {
        this.VarItemStatic=VarItemStatic;
    }

    public VarDeclarationsStatic getVarDeclarationsStatic() {
        return VarDeclarationsStatic;
    }

    public void setVarDeclarationsStatic(VarDeclarationsStatic VarDeclarationsStatic) {
        this.VarDeclarationsStatic=VarDeclarationsStatic;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarItemStatic!=null) VarItemStatic.accept(visitor);
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarItemStatic!=null) VarItemStatic.traverseTopDown(visitor);
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarItemStatic!=null) VarItemStatic.traverseBottomUp(visitor);
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulStaticDeclOneType(\n");

        if(VarItemStatic!=null)
            buffer.append(VarItemStatic.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationsStatic!=null)
            buffer.append(VarDeclarationsStatic.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulStaticDeclOneType]");
        return buffer.toString();
    }
}
