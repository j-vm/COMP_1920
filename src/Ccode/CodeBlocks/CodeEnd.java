package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeEnd extends CodeBlock {
    public CodeEnd() {
        super(0, 0, 0, 0);
    }

    @Override
    public String output(){
        // The end node was reached and the main function is closed
        String log = "";
        for (int i = 0; i < 20; i++) {
            log += "\tprintf(\"Register "+ i + "= %i\\n\", registers[" + i + "]);\n";
        }
        return log +"\treturn registers[3];\n}";
    }
}
