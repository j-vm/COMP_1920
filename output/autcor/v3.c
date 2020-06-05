#include "generated.h"
#include "uthash.h"

int generated(int *first_arg, int *second_arg, int *third_arg, int *fourth_arg, int *memory){
	int flags[8];
	int PC = 0;
	int imm = 0;
	int registers[32];
	registers[0] = 0;
	registers[5] = first_arg;
	registers[6] = second_arg;
	registers[7] = third_arg;
	registers[8] = fourth_arg;

	registers[5] = registers[0] + ( 0 );
	registers[6] = registers[0] + ( 1148 );
	registers[1] = registers[1] + ( -60 );
	registers[5] = registers[1] + ( 28 );
	registers[7] = registers[0] + ( 160 );
	memory[registers[1] + registers[0]] = registers[15];
	registers[8] = registers[0] + ( 16 );
	registers[15] = 544;
	//removed unconditional goto
	registers[1] = registers[1] + ( -12 );
	memory[registers[1] + registers[8]] = registers[22];
	memory[registers[1] + registers[4]] = registers[19];
	registers[22] = registers[5] + registers[0];
	
if(!( registers[8] <= 0 )){

	registers[3] = registers[8] + registers[8];
	registers[6] = registers[6] + registers[3];
	registers[19] = registers[6] + registers[0];
	registers[5] = registers[0] + registers[0];
// ------- wile(CONDITION) -------
	registers[4] = registers[0] + registers[0];

do {

	
if(!( registers[7] <= 0 )){

	registers[12] = registers[4] + registers[0];
	registers[11] = registers[19] + registers[0];
	registers[10] = registers[6] + registers[0];
	registers[9] = registers[4] + registers[0];

do {

	//[ERROR]: Couldn't understand instruction
// ------- wile(CONDITION) -------
	//[ERROR]: Couldn't understand instruction
	registers[9] = registers[9] + ( 1 );
	//[ERROR]: Couldn't understand instruction
	//[ERROR]: Couldn't understand instruction
	registers[4] = registers[4] * registers[3];
	registers[11] = registers[11] + ( 2 );
	registers[10] = registers[10] + ( 2 );
	registers[18] = registers[7] - registers[9] + 1;
	registers[12] = registers[12] + registers[4];
	
} while(  registers[18] != 0 );

// ------- wile(CONDITION) -------
	//[ERROR]: Couldn't understand instruction
	//[ERROR]: Couldn't understand instruction

}

	registers[3] = registers[5] + registers[5];
	registers[5] = registers[5] + ( 1 );
	//[ERROR]: Couldn't understand instruction
	registers[18] = registers[8] - registers[5] + 1;
	registers[6] = registers[6] + ( -2 );
	
} while(  registers[18] != 0 );

// ------- wile(CONDITION) -------

}

	registers[19] = memory[registers[1] + registers[4]];
	registers[22] = memory[registers[1] + registers[8]];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 12 );
	registers[15] = memory[registers[1] + registers[0]];
	registers[3] = registers[0] + registers[0];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 60 );
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
