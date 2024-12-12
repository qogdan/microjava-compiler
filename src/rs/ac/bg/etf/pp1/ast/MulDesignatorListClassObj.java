// generated with ast extension for cup
// version 0.8
// 24/5/2024 15:31:35


package rs.ac.bg.etf.pp1.ast;

public class MulDesignatorListClassObj extends DesignatorCommaList {

    private DesignatorCommaList DesignatorCommaList;
    private DCItem DCItem;

    public MulDesignatorListClassObj (DesignatorCommaList DesignatorCommaList, DCItem DCItem) {
        this.DesignatorCommaList=DesignatorCommaList;
        if(DesignatorCommaList!=null) DesignatorCommaList.setParent(this);
        this.DCItem=DCItem;
        if(DCItem!=null) DCItem.setParent(this);
    }

    public DesignatorCommaList getDesignatorCommaList() {
        return DesignatorCommaList;
    }

    public void setDesignatorCommaList(DesignatorCommaList DesignatorCommaList) {
        this.DesignatorCommaList=DesignatorCommaList;
    }

    public DCItem getDCItem() {
        return DCItem;
    }

    public void setDCItem(DCItem DCItem) {
        this.DCItem=DCItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorCommaList!=null) DesignatorCommaList.accept(visitor);
        if(DCItem!=null) DCItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorCommaList!=null) DesignatorCommaList.traverseTopDown(visitor);
        if(DCItem!=null) DCItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorCommaList!=null) DesignatorCommaList.traverseBottomUp(visitor);
        if(DCItem!=null) DCItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulDesignatorListClassObj(\n");

        if(DesignatorCommaList!=null)
            buffer.append(DesignatorCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DCItem!=null)
            buffer.append(DCItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulDesignatorListClassObj]");
        return buffer.toString();
    }
}
