package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBgeid extends CodeBlock {
    @Override
    public String output(){
        return "if (" + regToC(reg1) + " >= 0 ) { PC = PC + " + literal + "; }";
    }
}
