package Ccode.CodeBlocks;

public class CodeSw extends GenerateCode {
    public String output(int reg1,int reg2,int reg3){
        return memToC(reg2,reg3) + " = " + regToC(reg1) + ";";
    }
}
