int generated(int registers[32], int *memory, ){
   int flags[8];    int PC = 0;    int imm = 0; 
	registers[5] = registers[0] + ( 0 );
	registers[5] = registers[0] + ( 0 );
	registers[6] = registers[0] + ( 0 );
	registers[1] = registers[1] + ( 0 );
	registers[7] = registers[0] + ( 0 );
	registers[8] = registers[0] + ( 0 );
	memory[registers[1] + registers[0]] = registers[15];
	registers[9] = registers[1] + ( 0 );
	registers[15] = 636;
	goto L372;
L372:
	registers[1] = registers[1] + ( 0 );
	memory[registers[1] + registers[4]] = registers[19];
	memory[registers[1] + registers[8]] = registers[22];
	registers[4] = memory[registers[5] + registers[0]];
	registers[3] = memory[registers[6] + registers[0]];
	registers[19] = registers[9] + registers[0];
	registers[11] = registers[6] + registers[0];
	registers[3] = registers[3] * registers[4];
	registers[10] = registers[5] + registers[0];
	registers[22] = registers[7] + registers[0];
	memory[registers[19] + registers[0]] = registers[3];
	registers[4] = memory[registers[6] + registers[0]];
	registers[3] = memory[registers[11] + registers[4]];
	registers[6] = memory[registers[5] + registers[4]];
	registers[5] = memory[registers[5] + registers[0]];
	registers[9] = registers[8] + registers[0];
	registers[4] = registers[4] * registers[6];
	registers[3] = registers[3] * registers[5];
	registers[4] = registers[4] + registers[3];
	memory[registers[19] + registers[4]] = registers[4];
	registers[3] = memory[registers[11] + registers[0]];
	registers[8] = memory[registers[10] + registers[8]];
	registers[5] = memory[registers[11] + registers[4]];
	registers[7] = memory[registers[10] + registers[4]];
	registers[4] = memory[registers[11] + registers[8]];
	registers[6] = memory[registers[10] + registers[0]];
	registers[3] = registers[3] * registers[8];
	registers[5] = registers[5] * registers[7];
	registers[4] = registers[4] * registers[6];
	registers[3] = registers[3] + registers[5];
	registers[3] = registers[3] + registers[4];
	registers[18] = registers[0] + ( 0 );
	registers[18] = ( registers[18] - registers[22] ); //Not completed
	memory[registers[19] + registers[8]] = registers[3];
	if ( registers[18] >= 0 ) {
		goto L596;
	}
	registers[6] = registers[10] + ( 0 );
	registers[12] = registers[0] + ( 0 );
// ------- wile(CONDITION) -------
	registers[10] = registers[0] + registers[0];
L520:
	if ( registers[9] <= 0 ) {
		goto L572;
	}
	registers[8] = registers[6] + registers[0];
	registers[7] = registers[10] + registers[0];
L572:
	registers[3] = ( registers[12] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
	registers[12] = registers[12] + ( 0 );
	memory[registers[19] + registers[3]] = registers[10];
	registers[18] = registers[22] - registers[12] + 1;
	registers[6] = registers[6] + ( 0 );
	if ( registers[18] != 0 ) {
		goto L520;
	}
// ------- wile(CONDITION) -------
L536:
	registers[3] = ( registers[7] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
	registers[5] = memory[registers[8] + registers[0]];
	registers[4] = memory[registers[11] + registers[3]];
	registers[7] = registers[7] + ( 0 );
	registers[8] = registers[8] + ( 0 );
	registers[4] = registers[4] * registers[5];
	registers[18] = registers[9] - registers[7] + 1;
	registers[10] = registers[10] + registers[4];
	if ( registers[18] != 0 ) {
		goto L536;
	}
// ------- wile(CONDITION) -------
L596:
	registers[19] = memory[registers[1] + registers[4]];
	registers[22] = memory[registers[1] + registers[8]];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 0 );
	registers[15] = memory[registers[1] + registers[0]];
	registers[3] = registers[0] + registers[0];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 0 );
	registers[19] = registers[3] + ( 0 );
	registers[0] = registers[0] || registers[0];
	registers[15] = 340;
	goto L1172;
L1172:
	registers[1] = registers[1] + ( 0 );
	return registers[3];
}
