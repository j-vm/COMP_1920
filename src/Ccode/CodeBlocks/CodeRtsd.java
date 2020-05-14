package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRtsd extends CodeBlock {
    public CodeRtsd(int reg1, int literal) {
        super(reg1, 0, 0, literal);
    }

    @Override
    public String output(){
        return "PC" + " = " + regToC(reg1) + " + ( imm );";
    }
}
