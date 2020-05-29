package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrai extends CodeBlock {
    public CodeBrai(int literal) {
        super(0, 0, 0, literal);
    }

    @Override
    public String output(){
        int jmp = literal/4;
        return "goto [HERE]+" + jmp +"};";
    }
}
