package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSw extends CodeBlock {
    public CodeSw(int reg1, int reg2, int reg3) {
        super(reg1, reg2, reg3, 0);
    }

    @Override
    public String output(){
        return "store( " + memToC(reg2,reg3) + ", " + regToC(reg1) + ");";
    }
}
