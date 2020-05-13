package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeAddk extends CodeBlock {
    @Override
    public String output(int reg1, int reg2, int reg3){
        return regToC(reg1) + " = " + regToC(reg2) + " + " + regToC(reg3) + ";";
    }
}
