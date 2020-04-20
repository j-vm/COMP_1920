package javacc.nodes;

public class A3node extends InstructionNode{
    private String r1;
    private String r2;
    private String r3;


    public A3node(String Address, String instruction, String r1, String r2, String r3) {
        super(Address, instruction);
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }
}