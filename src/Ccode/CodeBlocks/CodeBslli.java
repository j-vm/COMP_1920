package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBslli extends CodeBlock {
    public CodeBslli(int reg1, int reg2, int literal) {
        super(reg1, reg2, 0, literal);
    }

    @Override
    public String output(){
        return regToC(reg1) + " = ( " + regToC(reg2) + " << ( " + literal + " & 0x1f ) & 0 );";
    }
}
