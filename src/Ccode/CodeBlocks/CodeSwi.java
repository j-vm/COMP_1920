package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSwi extends CodeBlock {
    public String output(int reg1,int reg2,int literal){
        return memToC(reg2,literal) + " = " + regToC(reg1) + ";";
    }
}
