int generated(int registers[32], int *memory, ){
   int flags[8];
   int PC = 0;
   int imm = 0;

0x0000014c:
	registers[5] = registers[0] + ( 0 );
0x00000264:
	registers[5] = registers[0] + ( 0 );
0x00000268:
	registers[6] = registers[0] + ( 0 );
0x0000026c:
	registers[1] = registers[1] + ( 0 );
0x00000270:
	registers[7] = registers[0] + ( 0 );
0x00000274:
	registers[8] = registers[0] + ( 0 );
0x00000278:
	memory[registers[1] + registers[0]] = registers[15];
0x0000027c:
	goto [HERE]+ (-66)};
	registers[15] = [HERE] * 4;
0x00000280:
	registers[9] = registers[1] + ( 0 );
0x00000174:
	registers[1] = registers[1] + ( 0 );
0x00000178:
	memory[registers[1] + registers[4]] = registers[19];
0x0000017c:
	memory[registers[1] + registers[8]] = registers[22];
0x00000180:
	registers[4] = memory[registers[5] + registers[0]];
0x00000184:
	registers[3] = memory[registers[6] + registers[0]];
0x00000188:
	registers[19] = registers[9] + registers[0];
0x0000018c:
	registers[11] = registers[6] + registers[0];
0x00000190:
	registers[3] = registers[3] * registers[4];
0x00000194:
	registers[10] = registers[5] + registers[0];
0x00000198:
	registers[22] = registers[7] + registers[0];
0x0000019c:
	memory[registers[19] + registers[0]] = registers[3];
0x000001a0:
	registers[4] = memory[registers[6] + registers[0]];
0x000001a4:
	registers[3] = memory[registers[11] + registers[4]];
0x000001a8:
	registers[6] = memory[registers[5] + registers[4]];
0x000001ac:
	registers[5] = memory[registers[5] + registers[0]];
0x000001b0:
	registers[9] = registers[8] + registers[0];
0x000001b4:
	registers[4] = registers[4] * registers[6];
0x000001b8:
	registers[3] = registers[3] * registers[5];
0x000001bc:
	registers[4] = registers[4] + registers[3];
0x000001c0:
	memory[registers[19] + registers[4]] = registers[4];
0x000001c4:
	registers[3] = memory[registers[11] + registers[0]];
0x000001c8:
	registers[8] = memory[registers[10] + registers[8]];
0x000001cc:
	registers[5] = memory[registers[11] + registers[4]];
0x000001d0:
	registers[7] = memory[registers[10] + registers[4]];
0x000001d4:
	registers[4] = memory[registers[11] + registers[8]];
0x000001d8:
	registers[6] = memory[registers[10] + registers[0]];
0x000001dc:
	registers[3] = registers[3] * registers[8];
0x000001e0:
	registers[5] = registers[5] * registers[7];
0x000001e4:
	registers[4] = registers[4] * registers[6];
0x000001e8:
	registers[3] = registers[3] + registers[5];
0x000001ec:
	registers[3] = registers[3] + registers[4];
0x000001f0:
	registers[18] = registers[0] + ( 0 );
0x000001f4:
	registers[18] = ( registers[18] - registers[22] ); //Not completed
0x000001f8:
	if ( registers[18] >= 0 ) { goto [HERE]+ (23)};
0x000001fc:
	memory[registers[19] + registers[8]] = registers[3];
0x00000200:
	registers[6] = registers[10] + ( 0 );
0x00000204:
	registers[12] = registers[0] + ( 0 );
0x00000208:
	if ( registers[9] <= 0 ) { goto [HERE]+ (13)};
// ------- wile(CONDITION) -------
0x0000020c:
	registers[10] = registers[0] + registers[0];
0x00000210:
	registers[8] = registers[6] + registers[0];
0x00000214:
	registers[7] = registers[10] + registers[0];
0x0000023c:
	registers[3] = ( registers[12] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
0x00000240:
	registers[12] = registers[12] + ( 0 );
0x00000244:
	memory[registers[19] + registers[3]] = registers[10];
0x00000248:
	registers[18] = registers[22] - registers[12] + 1;
0x0000024c:
	if ( registers[18] != 0 ) { goto [HERE]+ (-17)};
0x00000250:
	registers[6] = registers[6] + ( 0 );
// ------- wile(CONDITION) -------
0x00000218:
	registers[3] = ( registers[7] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
0x0000021c:
	registers[5] = memory[registers[8] + registers[0]];
0x00000220:
	registers[4] = memory[registers[11] + registers[3]];
0x00000224:
	registers[7] = registers[7] + ( 0 );
0x00000228:
	registers[8] = registers[8] + ( 0 );
0x0000022c:
	registers[4] = registers[4] * registers[5];
0x00000230:
	registers[18] = registers[9] - registers[7] + 1;
0x00000234:
	if ( registers[18] != 0 ) { goto [HERE]+ (-7)};
0x00000238:
	registers[10] = registers[10] + registers[4];
// ------- wile(CONDITION) -------
0x00000254:
	registers[19] = memory[registers[1] + registers[4]];
0x00000258:
	registers[22] = memory[registers[1] + registers[8]];
0x0000025c:
	PC = registers[15] + ( imm ); //Not completed
0x00000260:
	registers[1] = registers[1] + ( 0 );
0x00000284:
	registers[15] = memory[registers[1] + registers[0]];
0x00000288:
	registers[3] = registers[0] + registers[0];
0x0000028c:
	PC = registers[15] + ( imm ); //Not completed
0x00000290:
	registers[1] = registers[1] + ( 0 );
0x00000150:
	registers[19] = registers[3] + ( 0 );
0x00000154:
	goto [HERE]+ (208)};
	registers[15] = [HERE] * 4;
0x00000158:
	registers[0] = registers[0] || registers[0];
0x00000494:
	registers[1] = registers[1] + ( 0 );
end:
	}
