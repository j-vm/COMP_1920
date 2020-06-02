package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBrlid extends CodeBlock {
    int label;
    public CodeBrlid(int reg1, int literal, int label) {
        super(reg1, 0, 0, literal);
        this.label = label;
    }

    @Override
    public String output(){
        int jmp = label + literal;
        return "goto L" + jmp +";\n\t" +  regToC(reg1) + " = " + label + ";";
    }
}
