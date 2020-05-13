package Ccode;


public class CodeBlock {
    int reg1;
    int reg2;
    int reg3;
    int literal;



    public String regToC(int reg1){
        return "registers[" + reg1 + "]";
    }

    public String memToC(int reg1, int reg2){
        return "memory[" + reg1 + reg2 + "]";
    }


}
/*
#define lw(r1,r2,r3) (r1 = memory[r2+r3])
#define swi(r1,r2,literal) (memory[r2 + literal] = r1)
#define lwi(r1,r2,literal) (r1 = memory[re + literal])
*/