package nodes;


public class InstructionNode implements java.io.Serializable{
       private String address;
       private String instruction;
       private boolean literalNode = false;
       private int literal;
       
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

       public int getLiteral() {
              return literal;
       }

       public void addLiterals(int literal) {
              this.literal = literal;
              literalNode = true;
       }

       public boolean getliteralNode(){
              return literalNode;
       }
       @Override
       public String toString() {
              if(literalNode)
                     return "LITERAL = " + literal;
              else
                     return address + '\'' + instruction;

       }
}