package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRoot extends CodeBlock {
    public CodeRoot() {
        super(0, 0, 0, 0);
    }

    @Override
    public String output(){
    return "int[] registers; \n" +
            "int[] memory; \n" +
            "int[] flags; \n " +
            "int PC = 0; \n " +
            "int main(){";
    }
}
