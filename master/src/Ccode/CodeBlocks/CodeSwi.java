package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSwi extends CodeBlock {
    public CodeSwi(int reg1, int reg2, int literal) {
        super(reg1, reg2, 0, literal);
    }

    @Override
    public String output(){
        return memToC(reg2,literal) + " = " + regToC(reg1) + ";";
    }
}
