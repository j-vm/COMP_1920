# FEUP COMP
## Notes for the first assignment

### Index
1. Parsing
    
   - 1.1. Set of Instructions
   - 1.2. Registers

2. Graph Processing
       
   - 2.1. Data-streaming Computation
   - 2.2. Parallelism       
   - 2.3. Memory disambiguation       
   - 2.4. Extraction of Address Generation Units
   - 2.5. Extraction of repeating patterns
   
3. Implementation 
    
    - 3.1. Building and Extraction of Data Flow Graph (Extraction of Repeating Patterns)
    - 3.2. Building of Code Blocks
    - 3.3. Generation of C code
    - 3.4. Extraction of Loads and Stores
    - 3.5. Simulation ?


From https://www.xilinx.com/support/documentation/sw_manuals/xilinx2018_2/ug984-vivado-microblaze-ref.pdf 

# **1. PARSING**


## **1.1 Set of instructions**

All MicroBlaze instructions are 32 bits and are defined as either Type A or Type B.

In our implementation of the parser we divided each type of instructions into sub-types, in order to facilitate the parsing of expressions. Type A instructions are divided into A1, A2 or A3 and type B are divided into B1, B2 or B3. In the documentation numbers are described as immediate values (imm) we will be refering to them as literals.
 
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
 There are differnt uses for each register wich are described bellow:
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


 


# **2. Graph Processing** 

## **2.1 Data-streaming Computation**



## **2.2 Parallelism**

A computer program is a stream of instructions executed by a processor. Without instruction-level parallelism, a processor can only issue less than one instruction per clock cycle (IPC < 1). These instructions can be re-ordered and combined into groups which are then executed in parallel without changing the result of the program. This is known as instruction-level parallelism.

All modern processors have multi-stage instruction pipelines. Each stage in the pipeline corresponds to a different action the processor performs on that instruction in that stage; a processor with an N-stage pipeline can have up to N different instructions at different stages of completion and thus can issue one instruction per clock cycle (IPC = 1). 

Most modern processors also have multiple execution units. They usually combine this feature with pipelining and thus can issue more than one instruction per clock cycle (IPC > 1).Instructions can be grouped together only if there is no data dependency between them. Scoreboarding and the Tomasulo algorithm are two of the most common techniques for implementing out-of-order execution and instruction-level parallelism.



## **2.3 Memory disambiguation**

Memory disambiguation is a set of techniques employed by high-performance out-of-order execution microprocessors that execute memory access instructions (loads and stores) out of program order.

When attempting to execute instructions out of order, a microprocessor must respect true dependencies between instructions. And when executing loads and stores out of order can produce incorrect results if a dependent load/store pair was executed out of order.

So in order to resolve ambiguous dependences and recover when a dependence was violated Modern microprocessors use the following mechanisms:

 * **Avoiding Write-After-Read (WAR) and Write-After-Write (WAW) dependencies** - Values from store instructions are not committed to the memory system when they execute. Instead, the store instructions, including the memory address and store data, are buffered in a store queue until they reach the retirement point. When a store retires, it then writes its value to the memory system.
 
 * **Store to load forwarding** - In addition to buffering stores until retirement, the store queue serves a second purpose: forwarding data from completed but not-yet-retired ("in-flight") stores to later loads. When a load executes, it searches the store queue for in-flight stores to the same address that are logically earlier in program order. If a matching store exists, the load obtains its data value from that store instead of the memory system. If there is no matching store, the load accesses the memory system as usual; any preceding, matching stores must have already retired and committed their values. This technique allows loads to obtain correct data if their producer store has completed but not yet retired.
 


## **2.4 Extraction of Address Generation Units**



## **2.5 Extraction of repeating patterns**






P -> (I <LF>) *
I -> A (IA | IB)
IA -> C1, X, X, X
IA -> C1, X, X
IB -> C2, R, LIT


    


asm("#LOOP BEGIN:"::);

  for (i = 0; i < N; i++) {

     A[i] = B[i] + C;

  }

  asm("#LOOP END:"::);


objdump -> mb-objdump


Calling Convention The caller function passes parameters to the callee function using either the registers (R5 through R10) or on its own stack frame. The callee uses the caller’s stack area to store the parameters passed to the callee. Refer to Figure 3-2. The parameters for Func 2 are stored either in the registers R5 through R10 or on the stack frame allocated for Func 1.

# **3. Implementation**

In this project our goal was to develop and tool that allows the user to anlyse the trace of a program by creating graphs or genarating C code, that emulates the provided program in order to improve readability or even provide information about the stores and load and memory management of the program.

This tool provides 6 types of analysis:

    -Direct conversion from the trace to a graph;
    -Conversion of the trace to a Control-flow graph that allows identification of loops;
    -Genaration of C code by directly translating the assembly instructions;
    -Genaration of C code with labels;
    -Genaration of C code with only the important labels (the ones that allow jumps within the program);
    -Genartation of the C code where the labes and goto's are removed and replaced with corresponding conditions.
    

## **3.1 Genaration of Initial Graph**

The first graph is generated by parsing the trace line by line in 3 different components( Address, Instruction and Variables).


## **3.1 Genaration of Data Flow Graph**

## **3.2. Building of Code Blocks**

At this point we figured that the best step to transition into the genaration of C code was by, firstly analyzing the traces and extracting all of the instructions that are used in the programs provided to us, and secondly refering to the MicroBlaze Processor Reference Guide and study each of the instructions in order to discover what they do individualy.Finally, for each instruction the corresponding C code is written.

## **3.3. Generation of C code**

At an early stage of production we simply translated evry line of the trace to it's C counterpart. Then since we had information about the loops, provided by the Control-flow graph, we added goto's in the corresponding jumps and labels in the adresses where the jump's where going to. At the end we replaced this goto's anb labels with if's and while's, which generated the final runnable C code.

## **3.4. Extraction of Loads and Stores**

## **3.5. Simulation ?**

# **4. Memory Analysis**






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
Goto and label occur at the same indent level in the same container/block and goto occurs before the label.

Conditionally execute all the statements between the goto statement and the label statement, based on the inverse condition that is applied on the goto statement and remove the goto statement and the label
##Case 1.2 Algorithm
Goto and label occur at the same indent level in the same container/block and label occurs before the goto.

Execute all the statements between the label statement and the goto statement in a do-while loop, including the label statement, based on the condition that is applied on the goto statement and remove the label and the goto statement.
If a LEAVE/BREAK or ITER/CONTINUE falls under the do-while introduced in step#1, introduce a new variable and set it to true just before the LEAVE/BREAK or ITER/CONTINUE statement. Also create a new conditional block just after the do-while block introduced in step#1, based on this new variable that tracks the LEAVE/BREAK or ITER/CONTINUE statement, and re-set this new variable to false and execute the LEAVE/BREAK or ITER/CONTINUE statement

http://citeseer.ist.psu.edu/viewdoc/download;jsessionid=1B9F0F1D747EC90DA9ADAD03DEA392AF?doi=10.1.1.42.1485&rep=rep1&type=pdf




