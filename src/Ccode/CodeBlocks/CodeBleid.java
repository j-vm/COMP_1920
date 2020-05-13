package Ccode.CodeBlocks;

public class CodeBleid extends GenerateCode {
    public String output(int reg1, int literal){
        return "if (" + regToC(reg1) + " <= 0 ) { PC = PC + " + literal + "; }";
    }
}
