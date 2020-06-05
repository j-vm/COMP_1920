package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRoot extends CodeBlock {
    public CodeRoot() {
        super(0, 0, 0, 0);
    }

    @Override
    public String output(){
    return "int[32] registers; \n" +
            "memset(memory,0,1024);\n" +
            "int[] flags; \n " +
            "int PC = 0; \n " +
            "int main(){\n";
    }
}
