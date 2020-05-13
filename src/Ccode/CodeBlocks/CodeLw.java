package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeLw extends CodeBlock {
    public String output(int reg1,int reg2,int reg3){
        return regToC(reg1) + " = " + memToC(reg2,reg3) + ";";
    }
}
