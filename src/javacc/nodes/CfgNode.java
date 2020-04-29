package javacc.nodes;


public class CfgNode implements java.io.Serializable{
       private int address;
       private String instruction;
       private String register1;
       private String register2;
       private String register3;
       private String literal;

       public int getAddress() {
              return this.address;
       }

       public void setAddress(int address) {
              this.address = address;
       }

       public String getInstruction() {
              return this.instruction;
       }

       public void setInstruction(String instruction) {
              this.instruction = instruction;
       }

       public String getRegister1() {
              return this.register1;
       }

       public void setRegister1(String register1) {
              this.register1 = register1;
       }

       public String getRegister2() {
              return this.register2;
       }

       public void setRegister2(String register2) {
              this.register2 = register2;
       }

       public String getRegister3() {
              return this.register3;
       }

       public void setRegister3(String register3) {
              this.register3 = register3;
       }

       public String getLiteral() {
              return this.literal;
       }

       public void setLiteral(String literal) {
              this.literal = literal;
       }


       public CfgNode(int Address, String instruction) {
              this.address = Address;
              this.instruction = instruction;
       }

       public CfgNode() {}
}