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

L332:
	registers[5] = registers[0] + ( 0 );
L524:
	registers[6] = registers[0] + ( 1148 );
L528:
	registers[1] = registers[1] + ( -60 );
L532:
	registers[5] = registers[1] + ( 28 );
L536:
	registers[7] = registers[0] + ( 160 );
L540:
	store( registers[1] + registers[0], registers[15]);
L548:
	registers[8] = registers[0] + ( 16 );
L544:
	registers[15] = 544;
	goto L372;
L372:
	registers[1] = registers[1] + ( -12 );
L376:
	store( registers[1] + registers[8], registers[22]);
L380:
	store( registers[1] + registers[4], registers[19]);
L388:
	registers[22] = registers[5] + registers[0];
L384:
	if ( registers[8] <= 0 ) {
		goto L508;
	}
L392:
	registers[3] = registers[8] + registers[8];
L396:
	registers[6] = registers[6] + registers[3];
L400:
	registers[19] = registers[6] + registers[0];
L404:
	registers[5] = registers[0] + registers[0];
// ------- wile(CONDITION) -------
L412:
	registers[4] = registers[0] + registers[0];
L408:
	if ( registers[7] <= 0 ) {
		goto L484;
	}
L416:
	registers[12] = registers[4] + registers[0];
L420:
	registers[11] = registers[19] + registers[0];
L424:
	registers[10] = registers[6] + registers[0];
L428:
	registers[9] = registers[4] + registers[0];
L432:
	registers[4] = load( registers[11] + registers[0] );//Not complete
// ------- wile(CONDITION) -------
L436:
	registers[3] = load( registers[10] + registers[0] );//Not complete
L440:
	registers[9] = registers[9] + ( 1 );
L444:
	registers[4] = registers[4];//Not Complete
L448:
	registers[3] = registers[3];//Not Complete
L452:
	registers[4] = registers[4] * registers[3];
L456:
	registers[11] = registers[11] + ( 2 );
L460:
	registers[10] = registers[10] + ( 2 );
L464:
	registers[18] = registers[7] - registers[9] + 1;
L472:
	registers[12] = registers[12] + registers[4];
L468:
	if ( registers[18] != 0 ) {
		goto L432;
	}
// ------- wile(CONDITION) -------
L476:
	registers[3] = ( registers[12] >> ( 527 & 0x1f ) );
L480:
	registers[4] = registers[3];//Not Complete
L484:
	registers[3] = registers[5] + registers[5];
L488:
	registers[5] = registers[5] + ( 1 );
L492:
	registers[22] + registers[3] = registers[4];//Not Complete
L496:
	registers[18] = registers[8] - registers[5] + 1;
L504:
	registers[6] = registers[6] + ( -2 );
L500:
	if ( registers[18] != 0 ) {
		goto L408;
	}
// ------- wile(CONDITION) -------
L508:
	registers[19] = load( registers[1] + registers[4] );
L512:
	registers[22] = load( registers[1] + registers[8] );
L516:
	PC = registers[15] + ( imm ); //Not completed
L520:
	registers[1] = registers[1] + ( 12 );
L552:
	registers[15] = load( registers[1] + registers[0] );
L556:
	registers[3] = registers[0] + registers[0];
L560:
	PC = registers[15] + ( imm ); //Not completed
L564:
	registers[1] = registers[1] + ( 60 );
L336:
	registers[19] = registers[3] + ( 0 );
L344:
	registers[0] = registers[0] || registers[0];
L340:
	registers[15] = 340;
	goto L1080;
L1080:
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
