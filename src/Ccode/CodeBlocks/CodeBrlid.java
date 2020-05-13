package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrlid extends CodeBlock {
    @Override
    public String output(int reg1,int literal){
        return "PC = PC + " + literal + ";\n" +  regToC(reg1) + " = PC;";
    }
}
