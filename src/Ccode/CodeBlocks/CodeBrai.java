package Ccode.CodeBlocks;

public class CodeBrai extends GenerateCode {
    public String output(int literal){
        return "PC = PC + " + literal + ";";
    }
}
