package Ccode.CodeBlocks;

public class CodeBrlid extends GenerateCode {
    public String output(int reg1,int literal){
        return "PC = PC + " + literal + ";\n" +  regToC(reg1) + " = PC;";
    }
}
