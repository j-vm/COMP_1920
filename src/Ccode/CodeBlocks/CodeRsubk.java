package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRsubk extends CodeBlock {
    public String output(int reg1, int reg2, int reg3){
        return regToC(reg1) + "=" + regToC(reg3) + " - " + regToC(reg2) + 1 + ";";
    }
}
