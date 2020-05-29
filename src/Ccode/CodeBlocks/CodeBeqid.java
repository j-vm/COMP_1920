package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeBeqid extends CodeBlock {
    public CodeBeqid(int reg1, int literal) {
        super(reg1, 0, 0, literal);
    }

    @Override
    public String output(){
        int jmp = literal/4;
        return "if ( " + regToC(reg1) + " == 0 ) { goto [HERE]+ (" + jmp +")};";
    }
}
