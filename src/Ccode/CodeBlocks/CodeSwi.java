package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSwi extends CodeBlock {
    @Override
    public String output(){
        return memToC(reg2,literal) + " = " + regToC(reg1) + ";";
    }
}
