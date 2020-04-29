package javacc.nodes;

public class A1node extends InstructionNode {
    private String r1;


    public A1node(String Address, String instruction, String r1) {
        super(Address, instruction);
        this.r1 = r1;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }
}
