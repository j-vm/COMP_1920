package Ccode;

public class Code_swi extends GenerateCode {
    public String output(int reg1,int reg2,int literal){
        return memToC(reg2,literal) + " = " + regToC(reg1) + ";";
    }
}
