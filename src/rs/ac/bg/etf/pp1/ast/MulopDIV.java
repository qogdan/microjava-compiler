// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:35


package rs.ac.bg.etf.pp1.ast;

public class MulopDIV extends Mulop {

    public MulopDIV () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopDIV(\n");

        buffer.append(tab);
        buffer.append(") [MulopDIV]");
        return buffer.toString();
    }
}
