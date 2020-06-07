package Ccode;

public class CodeBlock {
    public int reg1;
    public int reg2;
    public int reg3;
    public int literal;

    public CodeBlock(int reg1,int reg2, int reg3, int literal){
        this.reg1 = reg1;
        this.reg2 = reg2;
        this.reg3 = reg3;
        this.literal = literal;
    }

    public String regToC(int reg1){
        return "registers[" + reg1 + "]";
    }

    public String memToC(int reg1, int reg2){
        return regToC(reg1) + " + " + regToC(reg2);
    }

    public String output(){
        return "//[ERROR]: Couldn't understand instruction";
    }

}
