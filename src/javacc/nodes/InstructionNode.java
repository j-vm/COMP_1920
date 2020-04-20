package javacc.nodes;


public class InstructionNode implements java.io.Serializable{
       private String address;
       private String instruction;

       
       public InstructionNode(String Address, String instruction) {
              this.address = Address;
              this.instruction = instruction;
       }

       public String getInstruction() {
              return this.instruction;
       }

       public void setInstruction(String instruction) {
              this.instruction = instruction;
       }

       public String getAddress() {
              return this.address;
       }

       public void setAddress(String Address) {
              this.address = Address;
       }

}