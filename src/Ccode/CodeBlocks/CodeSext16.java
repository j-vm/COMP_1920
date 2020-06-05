package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSext16 extends CodeBlock {
    public CodeSext16(int reg1, int reg2) {
        super(reg1, reg2, 0, 0);
    }

    @Override
    public String output() {
        return regToC(reg1)+ " = " + regToC(reg2) + ";//Not Complete";
    }
}
