package javacc.nodes;

public class B3node extends InstructionNode {
    private int literal;
    private String r1;
    private String r2;

    public B3node(String Address, String instruction, String r1, String r2, int literal) {
        super(Address, instruction);
        this.r1 = r1;
        this.r2 = r2;
        this.literal = literal;
    }

    public int getLiteral() {
        return literal;
    }

    public void setLiteral(int literal) {
        this.literal = literal;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }
}
