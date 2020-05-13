package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeSw extends CodeBlock {
    @Override
    public String output(int reg1,int reg2,int reg3){
        return memToC(reg2,reg3) + " = " + regToC(reg1) + ";";
    }
}
