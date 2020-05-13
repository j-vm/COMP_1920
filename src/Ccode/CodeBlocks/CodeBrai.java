package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrai extends CodeBlock {
    @Override
    public String output(int literal){
        return "PC = PC + " + literal + ";";
    }
}
