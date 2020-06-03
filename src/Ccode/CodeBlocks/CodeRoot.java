package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRoot extends CodeBlock {
    public CodeRoot() {
        super(0, 0, 0, 0);
    }

    @Override
    public String output(){
    return "int generated(int registers[32], int *memory, ){\n" +
            "   int flags[8]; " +
            "   int PC = 0; " +
            "   int imm = 0; ";
    }
}
