package Ccode;

public class Code_brai extends GenerateCode {
    public String output(int literal){
        return "PC = PC + " + literal + ";";
    }
}
