package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBleid extends CodeBlock {
    int label;
    public CodeBleid(int reg1, int literal, int label) {
        super(reg1, 0, 0, literal);
        this.label = label;
    }

    @Override
    public String output(){
        int jmp = label + literal;
        return "if ( " + regToC(reg1) + " <= 0 ) { goto L" + jmp +";}";
    }
}
