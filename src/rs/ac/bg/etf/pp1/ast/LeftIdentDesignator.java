// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:34


package rs.ac.bg.etf.pp1.ast;

public class LeftIdentDesignator extends DesignatorLeft {

    private String designatorName;

    public LeftIdentDesignator (String designatorName) {
        this.designatorName=designatorName;
    }

    public String getDesignatorName() {
        return designatorName;
    }

    public void setDesignatorName(String designatorName) {
        this.designatorName=designatorName;
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
        buffer.append("LeftIdentDesignator(\n");

        buffer.append(" "+tab+designatorName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LeftIdentDesignator]");
        return buffer.toString();
    }
}