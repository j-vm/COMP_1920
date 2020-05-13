package Ccode;

public class Code_bslli extends GenerateCode {
    public String output(int reg1, int reg2, int literal){
        return regToC(reg1) + "= ( " + regToC(reg2) + " << " + literal + ";";
    }
}
