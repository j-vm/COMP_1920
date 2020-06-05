package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBeqid extends CodeBlock {
    public CodeBeqid(int reg1, int literal) {
        super(reg1, 0, 0, literal);
    }

    @Override
    public String output(){
        return "if (" + regToC(reg1) + " == 0 ) { PC = PC + " + literal + "; }";
    }
}
