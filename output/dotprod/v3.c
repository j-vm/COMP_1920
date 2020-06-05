#include "generated.h"

int generated(int *first_arg, int *second_arg, int *memory){
	int flags[8];
	int PC = 0;
	int imm = 0;
	int registers[32];
	registers[0] = 0;
	registers[5] = first_arg;
	registers[6] = second_arg;

	registers[5] = registers[0] + ( 0 );
	registers[5] = registers[0] + ( 1036 );
	registers[6] = registers[0] + ( 9228 );
	registers[1] = registers[1] + ( -28 );
	memory[registers[1] + registers[0]] = registers[15];
	registers[0] = registers[0] || registers[0];
	registers[15] = 432;
	//removed unconditional goto
	registers[8] = registers[0] + registers[0];
	registers[7] = registers[8] + registers[0];

do {

	registers[3] = memory[registers[5] + registers[7]];
// ------- wile(CONDITION) -------
	registers[4] = memory[registers[6] + registers[7]];
	registers[7] = registers[7] + ( 4 );
	registers[3] = registers[3] * registers[4];
	registers[18] = registers[7] ^ ( 8192 );
	registers[8] = registers[8] + registers[3];
	
} while(  registers[18] != 0 );

// ------- wile(CONDITION) -------
	PC = registers[15] + ( imm ); //Not completed
	registers[3] = registers[8] + registers[0];
	registers[15] = memory[registers[1] + registers[0]];
	registers[3] = registers[0] + registers[0];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 28 );
	registers[19] = registers[3] + ( 0 );
	registers[0] = registers[0] || registers[0];
	registers[15] = 340;
	//removed unconditional goto
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
