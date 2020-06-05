package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrlid extends CodeBlock {
    public CodeBrlid(int reg1, int literal) {
        super(reg1, 0, 0, literal);
    }

    @Override
    public String output(){
        return "PC = PC + " + literal + ";\n" +  regToC(reg1) + " = PC;";
    }
}
