package Ccode.CodeBlocks;

import Ccode.CodeBlock;

public class CodeRoot extends CodeBlock {
    public String writeMainBeginning(){
    return "int[] registers; \n" +
            "int[] memory; \n" +
            "int[] flags; \n " +
            "int main(){";
    }
}
