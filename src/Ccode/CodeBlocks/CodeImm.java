package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeImm extends CodeBlock {


    public CodeImm(int literal) {
        super(0, 0, 0, literal);
    }

    @Override
    public String output(){
        return "//following literal in B type instruction's MSB is " + literal + "\\n";
    }
}
