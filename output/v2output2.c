#include "generated.h"

int generated(int *first_arg, int *second_arg, int *third_arg, int *fourth_arg, int *fifth_arg, int *memory){
	int flags[8];
	int PC = 0;
	int imm = 0;
	int registers[32];
	registers[0] = 0;
	registers[5] = first_arg;
	registers[6] = second_arg;
	registers[7] = third_arg;
	registers[8] = fourth_arg;
	registers[9] = fourth_arg;

	registers[5] = registers[0] + ( 0 );
	registers[5] = registers[0] + ( 1252 );
	registers[6] = registers[0] + ( 1236 );
	registers[1] = registers[1] + ( -1052 );
	registers[7] = registers[0] + ( 256 );
	registers[8] = registers[0] + ( 4 );
	memory[registers[1] + registers[0]] = registers[15];
	registers[9] = registers[1] + ( 28 );
	registers[15] = 636;
	goto L372;
L372:
	registers[1] = registers[1] + ( -12 );
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
	registers[18] = registers[0] + ( 3 );
	registers[18] = ( registers[18] - registers[22] ); //Not completed
	memory[registers[19] + registers[8]] = registers[3];
	if ( registers[18] >= 0 ) {
		goto L596;
	}
	registers[6] = registers[10] + ( 12 );
	registers[12] = registers[0] + ( 3 );
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
	registers[12] = registers[12] + ( 1 );
	memory[registers[19] + registers[3]] = registers[10];
	registers[18] = registers[22] - registers[12] + 1;
	registers[6] = registers[6] + ( 4 );
	if ( registers[18] != 0 ) {
		goto L520;
	}
// ------- wile(CONDITION) -------
L536:
	registers[3] = ( registers[7] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
	registers[5] = memory[registers[8] + registers[0]];
	registers[4] = memory[registers[11] + registers[3]];
	registers[7] = registers[7] + ( 1 );
	registers[8] = registers[8] + ( -4 );
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
	registers[1] = registers[1] + ( 12 );
	registers[15] = memory[registers[1] + registers[0]];
	registers[3] = registers[0] + registers[0];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 1052 );
	registers[19] = registers[3] + ( 0 );
	registers[0] = registers[0] || registers[0];
	registers[15] = 340;
	goto L1172;
L1172:
	registers[1] = registers[1] + ( -8 );
	printf("Register 0= %i", registers[0]);
	printf("Register 1= %i", registers[1]);
	printf("Register 2= %i", registers[2]);
	printf("Register 3= %i", registers[3]);
	printf("Register 4= %i", registers[4]);
	printf("Register 5= %i", registers[5]);
	printf("Register 6= %i", registers[6]);
	printf("Register 7= %i", registers[7]);
	printf("Register 8= %i", registers[8]);
	printf("Register 9= %i", registers[9]);
	printf("Register 10= %i", registers[10]);
	printf("Register 11= %i", registers[11]);
	printf("Register 12= %i", registers[12]);
	printf("Register 13= %i", registers[13]);
	printf("Register 14= %i", registers[14]);
	printf("Register 15= %i", registers[15]);
	printf("Register 16= %i", registers[16]);
	printf("Register 17= %i", registers[17]);
	printf("Register 18= %i", registers[18]);
	printf("Register 19= %i", registers[19]);
	return registers[3];
}
