package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrai extends CodeBlock {
    public CodeBrai(int literal) {
        super(0, 0, 0, literal);
    }

    @Override
    public String output(){
        return "PC = PC + " + literal + ";";
    }
}
