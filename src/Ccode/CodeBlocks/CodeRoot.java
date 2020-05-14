package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRoot extends CodeBlock {
    public CodeRoot() {
        super(0, 0, 0, 0);
    }

    @Override
    public String output(){
    return "int registers[32];\n" +
            "int *memory;\n" +
            "memory = malloc (1000 * sizeof (int));\n " +
            "int flags[8];\n" +
            "int PC = 0;\n" +
            "int imm = 0;\n" +
            "int main(){\n";
    }
}
