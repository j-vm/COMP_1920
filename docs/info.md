# FEUP COMP
## Notes for the first assignment

### Index
1. Parsing
       
   - 1.1. Address (Desambiguation)
   - 1.2. Set of Instructions
   - 1.3. Registers
   - 1.4. Values

2. Graph Processing
       
   - 2.1. Data-streaming Computation
   - 2.2. Parallelism       
   - 2.3. Memory disambiguation       
   - 2.4. Extraction of Address Generation Units
   - 2.5. Extraction of repeating patterns
       
3. Executable Dataflow Graph


From https://www.xilinx.com/support/documentation/sw_manuals/xilinx2018_2/ug984-vivado-microblaze-ref.pdf 

# **1. PARSING**

## **1.1 Addresses**



## **1.2 Set of instructions**

All MicroBlaze instructions are 32 bits and are defined as either Type A or Type B.

In our implementation of the parser we divided each type of instructions into sub-types, in order to facilitate the parsing of expressions. Type A instructions are divided into A1, A2 or A3 and type B are divided into B1, B2 or B3. In the documentation numbers are described as immediate values (imm) we will be refering to them as literals.
 
 ### **Type A Instructions**
  Type A instructions have up to two source register operands and one destination register operand. A1 instructions use 1 register, A2 instructions use 2 registers and A3 instructions use 3 registers.

 #### **Type A2 Instructions:**

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

# Other 
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

## **1.3 Registers**

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



## **1.4 Values**
 


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


    




    


