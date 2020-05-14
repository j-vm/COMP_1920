package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeOr extends CodeBlock {
    public CodeOr(int reg1, int reg2, int reg3) {
        super(reg1, reg2, reg3, 0);
    }

    @Override
    public String output(){
        return regToC(reg1) + " = " + regToC(reg2) + " || " + regToC(reg3) + ";";
    }
}
