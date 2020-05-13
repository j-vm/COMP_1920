package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrai extends CodeBlock {
    public String output(int literal){
        return "PC = PC + " + literal + ";";
    }
}
