package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSw extends CodeBlock {
    @Override
    public String output(){
        return memToC(reg2,reg3) + " = " + regToC(reg1) + ";";
    }
}
