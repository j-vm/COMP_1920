#include "generated.h"
#include "uthash.h"
#include <stdio.h> 

struct memAddress {
    int address;                    /* key */
    int value;
    UT_hash_handle hh;         /* makes this structure hashable */
};

struct memAddress *memory = NULL;

int load(int address) {
    struct memAddress *s;

    HASH_FIND_INT(memory, &address, s);
    if (s==NULL){
        fprintf( stderr, "Attempted access to unused memory address at: %d\n", address);
        return 0;
    }
    printf("Loaded value : %d from address: %d\n", s->value, address);
    return s->value;}

void store(int address, int value) {
    struct memAddress *s;

    printf("Stored value : %d at address: %d\n", value, address);
    HASH_FIND_INT(memory, &address, s);
    if (s==NULL) {
            s = (struct memAddress *)malloc(sizeof *s);
            s->address = address;
            s->value = value;
            HASH_ADD_INT( memory, address, s );
    }else{
            struct memAddress *newS;
            newS = (struct memAddress *)malloc(sizeof *newS);
            newS->address = address;
            newS->value = value;
            HASH_REPLACE_INT( memory, address, newS, s);
    }
    return;
}

int generated(int first_arg, int second_arg, int third_arg, int fourth_arg){
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
	store( registers[1] + registers[0], registers[15]);
	registers[8] = registers[0] + ( 16 );
	registers[15] = 544;
	//removed unconditional goto
	registers[1] = registers[1] + ( -12 );
	store( registers[1] + registers[8], registers[22]);
	store( registers[1] + registers[4], registers[19]);
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

	registers[4] = load( registers[11] + registers[0] );//Not complete
// ------- wile(CONDITION) -------
	registers[3] = load( registers[10] + registers[0] );//Not complete
	registers[9] = registers[9] + ( 1 );
	registers[4] = registers[4];//Not Complete
	registers[3] = registers[3];//Not Complete
	registers[4] = registers[4] * registers[3];
	registers[11] = registers[11] + ( 2 );
	registers[10] = registers[10] + ( 2 );
	registers[18] = registers[7] - registers[9] + 1;
	registers[12] = registers[12] + registers[4];
	
} while(  registers[18] != 0 );

// ------- wile(CONDITION) -------
	registers[3] = ( registers[12] >> ( 527 & 0x1f ) );
	registers[4] = registers[3];//Not Complete

}

	registers[3] = registers[5] + registers[5];
	registers[5] = registers[5] + ( 1 );
	registers[22] + registers[3] = registers[4];//Not Complete
	registers[18] = registers[8] - registers[5] + 1;
	registers[6] = registers[6] + ( -2 );
	
} while(  registers[18] != 0 );

// ------- wile(CONDITION) -------

}

	registers[19] = load( registers[1] + registers[4] );
	registers[22] = load( registers[1] + registers[8] );
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 12 );
	registers[15] = load( registers[1] + registers[0] );
	registers[3] = registers[0] + registers[0];
	PC = registers[15] + ( imm ); //Not completed
	registers[1] = registers[1] + ( 60 );
	registers[19] = registers[3] + ( 0 );
	registers[0] = registers[0] || registers[0];
	registers[15] = 340;
	//removed unconditional goto
	registers[1] = registers[1] + ( -8 );
	printf("Register 0= %i\n", registers[0]);
	printf("Register 1= %i\n", registers[1]);
	printf("Register 2= %i\n", registers[2]);
	printf("Register 3= %i\n", registers[3]);
	printf("Register 4= %i\n", registers[4]);
	printf("Register 5= %i\n", registers[5]);
	printf("Register 6= %i\n", registers[6]);
	printf("Register 7= %i\n", registers[7]);
	printf("Register 8= %i\n", registers[8]);
	printf("Register 9= %i\n", registers[9]);
	printf("Register 10= %i\n", registers[10]);
	printf("Register 11= %i\n", registers[11]);
	printf("Register 12= %i\n", registers[12]);
	printf("Register 13= %i\n", registers[13]);
	printf("Register 14= %i\n", registers[14]);
	printf("Register 15= %i\n", registers[15]);
	printf("Register 16= %i\n", registers[16]);
	printf("Register 17= %i\n", registers[17]);
	printf("Register 18= %i\n", registers[18]);
	printf("Register 19= %i\n", registers[19]);
	return registers[3];
}
