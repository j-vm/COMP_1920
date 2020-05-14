package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeCmp extends CodeBlock {
    public CodeCmp(int reg1, int reg2, int reg3) {
        super(reg1, reg2, reg3, 0);
    }

    @Override
    public String output(){
        return regToC(reg1) + " = ( " + regToC(reg3) + " - " + regToC(reg2) + " ) );";
    }
}
