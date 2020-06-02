package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrai extends CodeBlock {
    int label;
    public CodeBrai(int literal, int label) {
        super(0, 0, 0, literal);
        this.label = label;
    }

    @Override
    public String output(){
        int jmp = label + literal;
        return "goto L" + jmp +";";
    }
}
