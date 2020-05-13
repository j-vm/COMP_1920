package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeLw extends CodeBlock {
    @Override
    public String output(){
        return regToC(reg1) + " = " + memToC(reg2,reg3) + ";";
    }
}
