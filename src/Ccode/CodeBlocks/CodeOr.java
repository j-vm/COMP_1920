package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeOr extends CodeBlock {
    @Override
    public String output(){
        return regToC(reg1) + "=" + regToC(reg2) + "||" + regToC(reg3) + ";";
    }
}
