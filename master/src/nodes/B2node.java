package nodes;

public class B2node extends InstructionNode {
    private int literal;
    private String r1;

    public B2node(String Address, String instruction, String r1, int literal) {
        super(Address, instruction);
        this.r1 = r1;
        this.literal = literal;
    }

    public int getLiteral() {
        return literal;
    }

    public void setLiteral(int literal) {
        this.literal = literal;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }
}
