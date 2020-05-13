package Ccode;

public class Code_lw extends GenerateCode {
    public String output(int reg1,int reg2,int reg3){
        return regToC(reg1) + " = " + memToC(reg2,reg3) + ";";
    }
}
