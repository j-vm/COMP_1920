package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeAddi extends CodeBlock {
    @Override
    public String output(int reg1, int reg2, int literal){
        return regToC(reg1) + " = " + regToC(reg2) + " + " + literal + ";";
    }
}
