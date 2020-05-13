package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrai extends CodeBlock {
    @Override
    public String output(){
        return "PC = PC + " + literal + ";";
    }
}
