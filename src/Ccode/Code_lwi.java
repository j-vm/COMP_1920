package Ccode;

public class Code_lwi extends GenerateCode{
    public String output(int reg1,int reg2,int literal){
        return regToC(reg1) + " = " + memToC(reg2,literal) + ";";
    }
}
