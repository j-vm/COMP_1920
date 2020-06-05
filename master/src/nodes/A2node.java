package nodes;

public class A2node extends InstructionNode{
    private String r1;
    private String r2;


    public A2node(String Address, String instruction, String r1, String r2) {
        super(Address, instruction);
        this.r1 = r1;
        this.r2 = r2;
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
}