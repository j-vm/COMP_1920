package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBeqid extends CodeBlock {
    @Override
    public String output(int reg1, int literal){
        return "if (" + regToC(reg1) + " == 0 ) { PC = PC + " + literal + "; }";
    }
}
