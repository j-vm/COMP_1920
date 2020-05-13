package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBleid extends CodeBlock {
    @Override
    public String output(){
        return "if (" + regToC(reg1) + " <= 0 ) { PC = PC + " + literal + "; }";
    }
}
