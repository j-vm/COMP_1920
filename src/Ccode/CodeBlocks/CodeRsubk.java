package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRsubk extends CodeBlock {
    @Override
    public String output(){
        return regToC(reg1) + "=" + regToC(reg3) + " - " + regToC(reg2) + 1 + ";";
    }
}
