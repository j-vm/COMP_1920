package nodes;


import java.util.ArrayList;
import java.util.List;

public class InstructionNode implements java.io.Serializable{
       private String address;
       private String instruction;
       private List<Integer> literals = new ArrayList<>();
       
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

       public List<Integer> getLiterals() {
              return literals;
       }

       public void addLiterals(int literal) {
              this.literals.add(literal);
       }

       @Override
       public String toString() {
              if(literals.size() == 0)
              return
                      address + '\'' + instruction;
              else{
                     if(literals.size()>10){
                            String string = new String();
                            string = "[";
                            for (int i = 0; i < 10; i++) {
                                   string += literals.get(i).toString() + ',';
                            }
                            string += "...]";
                            return "LITERAL = " + string;
                     }
                     return "LITERAL = " + literals.toString();
              }
       }
}