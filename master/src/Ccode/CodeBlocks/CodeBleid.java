package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBleid extends CodeBlock {
    public CodeBleid(int reg1, int literal) {
        super(reg1, 0, 0, literal);
    }

    @Override
    public String output(){
        return "if (" + regToC(reg1) + " <= 0 ) { PC = PC + " + literal + "; }";
    }
}