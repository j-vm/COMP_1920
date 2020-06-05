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
	memory[registers[1] + registers[0]] = registers[15];
L548:
	registers[8] = registers[0] + ( 16 );
L544:
	registers[15] = 544;
	goto L372;
L372:
	registers[1] = registers[1] + ( -12 );
L376:
	memory[registers[1] + registers[8]] = registers[22];
L380:
	memory[registers[1] + registers[4]] = registers[19];
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
	registers[4] = ( memory[registers[11] + registers[0]] );//Not complete
// ------- wile(CONDITION) -------
L436:
	registers[3] = ( memory[registers[10] + registers[0]] );//Not complete
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
	registers[3] = ( registers[12] >> ( 527 ) );//Not completed
L480:
	registers[4] = registers[3];//Not Complete
L484:
	registers[3] = registers[5] + registers[5];
L488:
	registers[5] = registers[5] + ( 1 );
L492:
	memory[registers[22] + registers[3]] = registers[4];//Not Complete
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
	registers[19] = memory[registers[1] + registers[4]];
L512:
	registers[22] = memory[registers[1] + registers[8]];
L516:
	PC = registers[15] + ( imm ); //Not completed
L520:
	registers[1] = registers[1] + ( 12 );
L552:
	registers[15] = memory[registers[1] + registers[0]];
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
