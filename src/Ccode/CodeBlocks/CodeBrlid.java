package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrlid extends CodeBlock {
    @Override
    public String output(){
        return "PC = PC + " + literal + ";\n" +  regToC(reg1) + " = PC;";
    }
}
