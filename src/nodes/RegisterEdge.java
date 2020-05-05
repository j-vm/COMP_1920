package nodes;

import org.jgrapht.graph.DefaultEdge;

class RegisterEdge
        extends
        DefaultEdge
{

    private enum InputReg{
        A,
        B
    };

    private InputReg reg;
    /**
     * Constructs a register edge
     *
     * @param reg the label of the new edge.
     *
     */
    public RegisterEdge(String reg)
    {
        if(reg.equals("A")) this.reg = InputReg.A;
        else if(reg.equals("B")) this.reg = InputReg.B;
        else System.err.println("Unrecognized register for edge: " + reg);
    }

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

    @Override
    public String toString()
    {
        return "(" + getSource() + " : " + getTarget() + " : " + getReg() + ")";
    }

}
