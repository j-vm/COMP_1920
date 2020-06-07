# FEUP COMP

Group 2C

Members:

João Macedo - up2201704464@fe.up.pt
Miguel Romariz - up201708809@fe.up.pt

### Index
1. Parsing
  
  - 1.1. Set of Instructions
  - 1.2. Registers
 
2. Implementation
  
2.1 Generation of Control-flow graph
     -   2.2. Building and Extraction of Data Flow Graph (Extraction of Repeating Patterns)
  - 2.3. Building of Code Blocks
  - 2.4. Generation of C code
  - 2.5. Simulation
  - 2.6. Extraction of Loads and Stores
	-2.6.1 Memory Analysis 
  
3. Conclusion

4. References



# **1. PARSING**


## **1.1 Set of instructions**

All MicroBlaze instructions are 32 bits and are defined as either Type A or Type B.

In our implementation of the parser we divided each type of instructions into sub-types, in order to facilitate the parsing of expressions. Type A instructions are divided into A1, A2 or A3 and type B are divided into B1, B2 or B3. In the documentation numbers are described as immediate values (imm) we will be referring to them as literals.

### **Type A Instructions**
 Type A instructions have up to two source register operands and one destination register operand. A1 instructions use 1 register, A2 instructions use 2 registers and A3 instructions use 3 registers.

#### **Type A1 Instructions:**
```
* BR
* BRD
* BRA
* BRAD
```
Type A1 example: BR Rd

#### **Type A2 Instructions:**

```
* TNEAGETD
* TNAPUTD
* TNECAGETD
* TNCAPUTD
* FLT
* FINT
* FSQRT
* DBL
* DLONG
* DSQRT
* SRA
* SEXT8
* SEXT16
* SEXTL32
* CLZ
* SWAPB
* CLZ
* SWAPH
* WIC
* WDC
* WDC.FLUSH
* WDC.CLEAR
* WDC.CLEAR.EA
* BRLD
* BRALD
* BRK
* BEQ
* BNE
* BLT
* BLE
* BGT
* BGE
* BEQD
* BNED
* BLTD
* BLED
* BGTD
* BGED
```
Type A2 example: SEXT16 Rd,Ra

#### **Type A3 Instructions:**
```
* ADD
* RSUB
* ADDC
* RSUBC
* ADDK
* RSUBK
* CMP
* CMPU
* ADDKC
* RSUBKC
* MUL
* MULH
* MULHU
* MULHSU
* BSRL
* BSRA
* BSLL
* IDIV
* IDIVU
* FADD
* FRSUB
* FMUL
* FDIV
* FCMP.UN
* FCMP.LT
* FCMP.EQ
* FCMP.LE
* FCMP.GT
* FCMP.NE
* FCMP.GE
* DADD
* DRSUB
* DMUL
* DDIV
* DCMP.UN
* DCMP.LT
* DCMP.EQ
* DCMP.LE
* DCMP.GT
* DCMP.NE
* DCMP.GE
* OR
* PCMPBF
* AND
* XOR
* PCMPEQ
* ANDN
* PCMPNE
* LBU
* LBUR
* LBUEA
* LHU
* LHUR
* LHUEA
* LW
* LWR
* LWX
* LWEA
* LL
* LLR
* SB
* SBR
* SBEA
* SH
* SHR
* SHEA
* SW
* SWR
* SWX
* SWEA
* SL
* SLR
```
Type A3 example: SW Rd,Ra,Rb.

Type A3 example: SW Rd,Ra,Rb.

### **Type B Instructions**

Type B instructions have one source register and a 16-bit immediate operand (which can be extended to 32 bits by preceding the Type B instruction with an imm instruction). B1 instructions have 1 literal, B2 instructions use 1 literal and 1 register and B3 instructions use 2 registers and 1 literal.

#### **Type B1 Instructions:**

```
* IMM
* IMML
* BRI
* MBAR
* BRID
* BRAI
* BRAID
```
Type B1 example: BRAI Imm

#### **Type B2 Instructions:**
```
* MSRCLR
* MSRSET
* RTSD
* RTID
* RTBD
* RTED
* BRLID
* BRALID
* BRKI
* BEQI
* BNEI
* BLTI
* BLEI
* BGTI
* BGEI
* BEQID
* BNEID
* BLTID
* BLEID
* BGTID
* BGEID
```
Type B2 example: BRALID Rd,Imm

#### **Type B3 Instructions:**
```
* ADDI
* RSUBI
* ADDIC
* RSUBIC
* ADDIK
* RSUBIK
* ADDIKC
* RSUBIKC
* MULI
* BSRLI
* BSRAI
* BSLLI
* ORI
* ANDI
* XORI
* ANDNI
* LBUI
* LHUI
* LWI
* LLI
* SBI
* SJI
* SWI
* SLI
```
Type B3 example: LHUI Rd,Ra,Imm

#### Other
```
BSEFI
BSIFI
TNEAGET
TNAPUT
TNECAGET
TNCAPUT
MTS
MTSE
MFS
MFSE
```

## **1.2 Registers**

MicroBlaze has at its disposal 2 types of registers. It has 32-bit general purpose registers and up to 18 32-bit special purpose registers.

### **General Purpose Registers**
The 32-bit general purpose registers are numbered R0 through R31.
There are different uses for each register which are described below:
* R0 - Always has the value of zero. Anything written to it is discarded;
* R1-R13 - 32-bit general purpose registers;
* R14 - Used to store return addresses for interrupts;
* R15 - Used to store return addresses for user vectores;
* R16 - Used to store return addresses for breaks;
* R17 - General purpose register, or in some cases, used for hardware exceptions;
* R18-R31 - 32-bit general purpose registers.

## **Special Purpose Registers**

* Program Counter (PC) - Is the 32-bit address of the executing instruction;
* Machine Status Register (MSR) - Contains control and status bits for the processor;
* Exception Address Register (EAR) - Stores the full load/store address that caused an exception;
* Branch Target Register (BTR) - Only exists if the MIcroBlaze processor is configured to use exceptions. Stores the branch target address for all delay slot branch instructions;
* Floating-Point Status Register (FSR) - Contains status bits for the floating-point unit;
* Exception Data Register (EDR) - Stores data read on a link that caused a stream exception;
* Stack Low Register (SLR) - Stores the stack low limit use to detect stack overflow;
* Stack High Register (SHR) - Stores the stack high limit use to detect stack underflow;
* Process Identifier Register (PID) - Used to uniquely identify a software process during MMU address translation;
* Zone Protection Register (ZPR) - Used to override MMU memory protection defined in TLB entries;
* Translation Look-Aside Buffer Low Register (TLBLO) - Used to access MMU Unified Translation Look-Aside Buffer (UTLB) entries;
* Translation Look-Aside Buffer High Register (TLBHI) - Used to access MMU Unified Translation Look-Aside Buffer (UTLB) entries;
* Translation Look-Aside Buffer Index Register (TLBX) - Used as an index to the Unified Translation Look-Aside Buffer (UTLB) when accessing the TLBLO and TLBHI registers;
* Translation Look-Aside Buffer Search Index Register (TLBSX) - Used to search for a virtual page number in the UTLB;
* Processor Version Register (PVR) - Is controlled by the C_PVR configuration option on MicroBlaze;



# **2. Implementation**

In this project our goal was to develop and tool that allows the user to analyse the trace of a program by creating graphs or generating C code, that emulates the provided program in order to improve readability or even provide information about the stores and load and memory management of the program.

This tool provides 6 types of analysis:

   -Conversion of the trace to a Control-flow graph that allows identification of loops;
   -Conversion of the trace to a Compound data and control flow graph;
   -Generation of C code by directly translating the assembly instructions;
   -Generation of C code with Address labels;
   -Generation of C code with only the used labels (allowing jumps within the program);
   -Generation of the C code where the labels and goto's are removed and replaced with corresponding conditions.
  

## **2.1 Generation of Control-flow graph**

First we created a graph that went through the trace and saves each new instructions as a vertex and creates an edge between the previous instruction and the next one, labeling this edge.
When a vertex has more than an one path to choose from it creates an edge with the lowest label possible, ensuring this way that the loops are represented.

This graph allowed us to easily visualize the loops in the program and paved the way to the extraction of C code, by structuring the information in a more optimal way.

## **2.2 Generation of Control and Data Flow Graph**

The first graph that was created gave us a lot of information but we still needed more.

So we decided to create a Data-flow graph. This was done in three iterations:
   -The first one we saved all instructions with a unique id which gave as a graph that was way too big  and unreadable;
   -The second one didn't have any structure and didn't allow us to see the progress of the execution of the instructions;
   -Finally we were able to create a graph that gave a structured representation of the program and where we could clearly see the progress in the execution of the instructions;

By merging the Control-flow graph with the Data-flow graph we gained valuable information about the flow of information within the program and allowed us to
see clearly the path that the program took through all steps.


## **2.3. Building of Code Blocks**

At this point we figured that the best step to transition into the generation of C code was by, firstly analyzing the traces and extracting all of the instructions that are used in the programs provided to us, and secondly referring to the MicroBlaze Processor Reference Guide and study each of the instructions in order to discover what they do individually. Finally, for each instruction the corresponding C code is written. 
Adding to this, we soon realised that the generation of a working C function did not consist solely on the aggregation of individually translated instructions, as things such as delayed instructions, memory simulation and interdependent instructions (of note, IMM), stood as obstacles to be transposed. 

## **2.4. Generation of C code**

At an early stage of production we simply translated every line of the trace to its counterpart.
An obvious flaw of this approach was the sheer length and lack of readability of the generated code.

From the condensed information in the control-flow graph regarding program counter changes (jumps), we added goto instructions in the corresponding and labels at each instruction to simulate this control flow. At this point, we were faced with the reality of delayed instructions and we promptly switched the order of the delayed instructions and the ones that followed them. 

Further improvements on readability came as we deleted all the unconditional jumps (as we are using the trace as our source these jumps were effectively goto instructions to the subsequent line) and deleted all unused labels. 
 
A last step to structure the generated code was by substituting the goto statements, by implementing the outlined in section 2 of [this paper](http://citeseer.ist.psu.edu/viewdoc/download;jsessionid=1B9F0F1D747EC90DA9ADAD03DEA392AF?doi=10.1.1.42.1485&rep=rep1&type=pdf).


## **2.5. Simulation**

Simulation of memory was one of our most prominent challenges. We ended up abstracting this by creating a map through the library uthash

## **2.6. Extraction of Loads and Stores**


### **2.6.1** Memory






# **3. Conclusion**

Even though we couldn’t reach all of the objectives that we set for ourselves, due to our team being cut short by two members mid production, we believe that we achieved very good results in our implementation.
There were some roadblocks during this process, some that we easily passed through like the use of delayed instructions which required some extra steps to be dealt with or the merging of the Control-flow graph and the Data-flow graph. But there were others which we couldn’t conquer, like the correct translation of all of the instructions from assembly to C code, this was the main difficulty that we encountered and the one which mostly stopped us from reaching greater lengths.
All in all we are very proud of the work we did and of our final product.






# **4. References**

https://www.xilinx.com/support/documentation/sw_manuals/xilinx2018_2/ug984-vivado-microblaze-ref.pdf

https://troydhanson.github.io/uthash/userguide.html?fbclid=IwAR3oNYyJ4UHW9CtqySjQOU02F0Sz1FwrVyCRTglrXNFvHMKjltYb3QEq5-I

https://dzone.com/articles/goto-elimination-algorithm?fbclid=IwAR3jTJTIedkStvLiJOXPWEh-tgbVimkZiz6XyMkGx5u3Geru-a4y-QgoAbk

http://citeseer.ist.psu.edu/viewdoc/download;jsessionid=1B9F0F1D747EC90DA9ADAD03DEA392AF?doi=10.1.1.42.1485&rep=rep1&type=pdf








#NOTES MEETING 29/05

## Get the program written,

The structured program theorem, also called the Böhm–Jacopini theorem, is a result in programming language theory. It states that a class of control flow graphs (historically called flowcharts in this context) can compute any computable function if it combines subprograms in only three specific ways (control structures). These are

1. Executing one subprogram, and then another subprogram (sequence)
2. Executing one of two subprograms according to the value of a boolean expression (selection)
3. Repeatedly executing a subprogram as long as a boolean expression is true (iteration)

The structured chart subject to these constraints may however use additional variables in the form of bits (stored in an extra integer variable in the original proof) in order to keep track of information that the original program represents by the program location. The construction was based on Böhm's programming language P′′.

The theorem forms the basis of structured programming, a programming paradigm which eschews goto commands and exclusively uses subroutines, sequences, selection and iteration.


##then we take a look at:

In the 1980s IBM researcher Harlan Mills oversaw the development of the COBOL Structuring Facility, which applied a structuring algorithm to COBOL code. Mills's transformation involved the following steps for each procedure.

Identify the basic blocks in the procedure.
Assign a unique label to each block's entry path, and label each block's exit paths with the labels of the entry paths they connect to. Use 0 for return from the procedure and 1 for the procedure's entry path.
Break the procedure into its basic blocks.
For each block that is the destination of only one exit path, reconnect that block to that exit path.
Declare a new variable in the procedure (called L for reference).
On each remaining unconnected exit path, add a statement that sets L to the label value on that path.
Combine the resulting programs into a selection statement that executes the program with the entry path label indicated by L
Construct a loop that executes this selection statement as long as L is not 0.
Construct a sequence that initializes L to 1 and executes the loop.
Note that this construction can be improved by converting some cases of the selection statement into subprocedures.



#Goto Elimination Algorithm
The following section of the document details out the algorithms that can be applied for all the cases outlined above, to eliminate gotos and labels from code.
https://dzone.com/articles/goto-elimination-algorithm?fbclid=IwAR0ERFa-F1FvovdFSIWxTtKHQBMIDrz9qP2r5NfgsJINvb5A3sszv3ZSMtE

only use cases 1.1 and 1.2
##Base Algorithm
Take the original program as input

Collect all goto and label statements as pairs

For Each goto-label pair,

Convert goto to single statement conditional goto, if it is not already

Classify the goto-label pair to a single case (from among the cases outlined above)

Execute specific case's algorithm of which the current goto-label pair corresponds to

Output the restructured program

###Key Points
For the all case specific algorithms that are detailed below, following are some of the key points to consider:

Every goto statement should be conditional (i.e. conditional with the single goto statement in it)
Eg:

if (cond) {
 goto L1
}
Every case (code structure) should be reduced to the primitive case/state outlined above
For any goto-label pair, only the goto statement must be adjusted/moved to reduce the structure to primitive case/state
Every new introduced boolean variable in the algorithms, that is used without initialization, is assumed to be initialized to false
Note: In all the algorithms outline below, when referring to goto statement, it refers to the single statement conditional goto i.e.:

if (cond) {
 goto L1
}

## Case 1.1 Algorithm
Goto and label occur at the same indent level in the same container/block and goto occurs before the label. Saves all of the visited addresses and if from one edge

Conditionally execute all the statements between the goto statement and the label statement, based on the inverse condition that is applied on the goto statement and remove the goto statement and the label
##Case 1.2 Algorithm
Goto and label occur at the same indent level in the same container/block and label occurs before the goto.

Execute all the statements between the label statement and the goto statement in a do-while loop, including the label statement, based on the condition that is applied on the goto statement and remove the label and the goto statement.
If a LEAVE/BREAK or ITER/CONTINUE falls under the do-while introduced in step#1, introduce a new variable and set it to true just before the LEAVE/BREAK or ITER/CONTINUE statement. Also create a new conditional block just after the do-while block introduced in step#1, based on this new variable that tracks the LEAVE/BREAK or ITER/CONTINUE statement, and re-set this new variable to false and execute the LEAVE/BREAK or ITER/CONTINUE statement

http://citeseer.ist.psu.edu/viewdoc/download;jsessionid=1B9F0F1D747EC90DA9ADAD03DEA392AF?doi=10.1.1.42.1485&rep=rep1&type=pdf





