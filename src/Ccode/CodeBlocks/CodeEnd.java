package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeEnd extends CodeBlock {
    public CodeEnd() {
        super(0, 0, 0, 0);
    }

    @Override
    public String output(){
        // The end node was reached and the main function is closed
        return "\treturn registers[3];\n}";
    }
}
