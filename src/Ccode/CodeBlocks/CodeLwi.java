package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeLwi extends CodeBlock {
    public String output(int reg1,int reg2,int literal){
        return regToC(reg1) + " = " + memToC(reg2,literal) + ";";
    }
}
