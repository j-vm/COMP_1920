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
L612:
	registers[5] = registers[0] + ( 1252 );
L616:
	registers[6] = registers[0] + ( 1236 );
L620:
	registers[1] = registers[1] + ( -1052 );
L624:
	registers[7] = registers[0] + ( 256 );
L628:
	registers[8] = registers[0] + ( 4 );
L632:
	memory[registers[1] + registers[0]] = registers[15];
L640:
	registers[9] = registers[1] + ( 28 );
L636:
	registers[15] = 636;
	goto L372;
L372:
	registers[1] = registers[1] + ( -12 );
L376:
	memory[registers[1] + registers[4]] = registers[19];
L380:
	memory[registers[1] + registers[8]] = registers[22];
L384:
	registers[4] = memory[registers[5] + registers[0]];
L388:
	registers[3] = memory[registers[6] + registers[0]];
L392:
	registers[19] = registers[9] + registers[0];
L396:
	registers[11] = registers[6] + registers[0];
L400:
	registers[3] = registers[3] * registers[4];
L404:
	registers[10] = registers[5] + registers[0];
L408:
	registers[22] = registers[7] + registers[0];
L412:
	memory[registers[19] + registers[0]] = registers[3];
L416:
	registers[4] = memory[registers[6] + registers[0]];
L420:
	registers[3] = memory[registers[11] + registers[4]];
L424:
	registers[6] = memory[registers[5] + registers[4]];
L428:
	registers[5] = memory[registers[5] + registers[0]];
L432:
	registers[9] = registers[8] + registers[0];
L436:
	registers[4] = registers[4] * registers[6];
L440:
	registers[3] = registers[3] * registers[5];
L444:
	registers[4] = registers[4] + registers[3];
L448:
	memory[registers[19] + registers[4]] = registers[4];
L452:
	registers[3] = memory[registers[11] + registers[0]];
L456:
	registers[8] = memory[registers[10] + registers[8]];
L460:
	registers[5] = memory[registers[11] + registers[4]];
L464:
	registers[7] = memory[registers[10] + registers[4]];
L468:
	registers[4] = memory[registers[11] + registers[8]];
L472:
	registers[6] = memory[registers[10] + registers[0]];
L476:
	registers[3] = registers[3] * registers[8];
L480:
	registers[5] = registers[5] * registers[7];
L484:
	registers[4] = registers[4] * registers[6];
L488:
	registers[3] = registers[3] + registers[5];
L492:
	registers[3] = registers[3] + registers[4];
L496:
	registers[18] = registers[0] + ( 3 );
L500:
	registers[18] = ( registers[18] - registers[22] ); //Not completed
L508:
	memory[registers[19] + registers[8]] = registers[3];
L504:
	if ( registers[18] >= 0 ) {
		goto L596;
	}
L512:
	registers[6] = registers[10] + ( 12 );
L516:
	registers[12] = registers[0] + ( 3 );
// ------- wile(CONDITION) -------
L524:
	registers[10] = registers[0] + registers[0];
L520:
	if ( registers[9] <= 0 ) {
		goto L572;
	}
L528:
	registers[8] = registers[6] + registers[0];
L532:
	registers[7] = registers[10] + registers[0];
L572:
	registers[3] = ( registers[12] << ( 1026& 0x1f ) & 0; //Not completed
// ------- wile(CONDITION) -------
L576:
	registers[12] = registers[12] + ( 1 );
L580:
	memory[registers[19] + registers[3]] = registers[10];
L584:
	registers[18] = registers[22] - registers[12] + 1;
L592:
	registers[6] = registers[6] + ( 4 );
L588:
	if ( registers[18] != 0 ) {
		goto L520;
	}
// ------- wile(CONDITION) -------
L536:
	registers[3] = ( registers[7] << ( 1026& 0x1f ) & 0; //Not completed
// ------- wile(CONDITION) -------
L540:
	registers[5] = memory[registers[8] + registers[0]];
L544:
	registers[4] = memory[registers[11] + registers[3]];
L548:
	registers[7] = registers[7] + ( 1 );
L552:
	registers[8] = registers[8] + ( -4 );
L556:
	registers[4] = registers[4] * registers[5];
L560:
	registers[18] = registers[9] - registers[7] + 1;
L568:
	registers[10] = registers[10] + registers[4];
L564:
	if ( registers[18] != 0 ) {
		goto L536;
	}
// ------- wile(CONDITION) -------
L596:
	registers[19] = memory[registers[1] + registers[4]];
L600:
	registers[22] = memory[registers[1] + registers[8]];
L604:
	PC = registers[15] + ( imm ); //Not completed
L608:
	registers[1] = registers[1] + ( 12 );
L644:
	registers[15] = memory[registers[1] + registers[0]];
L648:
	registers[3] = registers[0] + registers[0];
L652:
	PC = registers[15] + ( imm ); //Not completed
L656:
	registers[1] = registers[1] + ( 1052 );
L336:
	registers[19] = registers[3] + ( 0 );
L344:
	registers[0] = registers[0] || registers[0];
L340:
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
