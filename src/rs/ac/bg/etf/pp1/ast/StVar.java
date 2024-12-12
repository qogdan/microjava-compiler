// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class StVar implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private VarDeclarationsStatic VarDeclarationsStatic;

    public StVar (Type Type, VarDeclarationsStatic VarDeclarationsStatic) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclarationsStatic=VarDeclarationsStatic;
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclarationsStatic getVarDeclarationsStatic() {
        return VarDeclarationsStatic;
    }

    public void setVarDeclarationsStatic(VarDeclarationsStatic VarDeclarationsStatic) {
        this.VarDeclarationsStatic=VarDeclarationsStatic;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclarationsStatic!=null) VarDeclarationsStatic.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StVar(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationsStatic!=null)
            buffer.append(VarDeclarationsStatic.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StVar]");
        return buffer.toString();
    }
}
