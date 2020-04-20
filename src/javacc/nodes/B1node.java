package javacc.nodes;

public class B1node extends InstructionNode {
    private int literal;

    public B1node(String Address, String instruction, int literal) {
        super(Address, instruction);
        this.literal = literal;
    }

    public int getLiteral() {
        return literal;
    }

    public void setLiteral(int literal) {
        this.literal = literal;
    }
}
