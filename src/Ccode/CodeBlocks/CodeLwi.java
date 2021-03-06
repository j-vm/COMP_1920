package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeLwi extends CodeBlock {
    public CodeLwi(int reg1, int reg2, int literal) {
        super(reg1, reg2, 0, literal);
    }

    @Override
    public String output(){
        return regToC(reg1) + " = load( " + memToC(reg2,literal) + " );";
    }
}
