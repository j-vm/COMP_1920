package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBeqid extends CodeBlock {
    int label;
    public CodeBeqid(int reg1, int literal, int label) {
        super(reg1, 0, 0, literal);
        this.label = label;
    }

    @Override
    public String output(){
        int jmp = label + literal;
        return "if ( " + regToC(reg1) + " == 0 ) { goto L" + jmp +";}";
    }
}
