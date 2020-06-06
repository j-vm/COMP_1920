package nodes;

import org.jgrapht.graph.DefaultEdge;

public class RegisterEdge
        extends
        DefaultEdge
{

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public void setReg(InputReg reg) {
        this.reg = reg;
    }

    public int isCfEdge() {
        return cfEdge;
    }

    public void setCfEdge(int cfEdge) {
        this.cfEdge = cfEdge;
    }

    public enum InputReg{
        A,
        B
    };

    private InputReg reg;
    private String regName;
    private int cfEdge = 0;

    public RegisterEdge(){}

    /**
     * Gets the label associated with this edge.
     *
     * @return edge label
     */
    public String getReg()
    {
        if(this.reg == InputReg.A) return "A";
        else if(this.reg == InputReg.B) return "B";
        else return null;
    }

    public String toString()
    {
        return this.getRegName();
    }

}
