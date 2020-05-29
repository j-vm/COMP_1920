int generated(int registers[32], int *memory, ){
   int flags[8];
   int PC = 0;
   int imm = 0;

0:
	registers[5] = registers[0] + ( 0 );
1:
	registers[5] = registers[0] + ( 0 );
2:
	registers[6] = registers[0] + ( 0 );
3:
	registers[1] = registers[1] + ( 0 );
4:
	registers[7] = registers[0] + ( 0 );
5:
	registers[8] = registers[0] + ( 0 );
6:
	memory[1 + 0] = registers[15];
7:
	goto [HERE]+-264};
	registers[15] = [HERE];
8:
	registers[9] = registers[1] + ( 0 );
9:
	registers[1] = registers[1] + ( 0 );
10:
	memory[1 + 4] = registers[19];
11:
	memory[1 + 8] = registers[22];
12:
	registers[4] = memory[5 + 0];
13:
	registers[3] = memory[6 + 0];
14:
	registers[19] = registers[9] + registers[0];
15:
	registers[11] = registers[6] + registers[0];
16:
	registers[3] = registers[3] * registers[4];
17:
	registers[10] = registers[5] + registers[0];
18:
	registers[22] = registers[7] + registers[0];
19:
	memory[19 + 0] = registers[3];
20:
	registers[4] = memory[6 + 0];
21:
	registers[3] = memory[11 + 4];
22:
	registers[6] = memory[5 + 4];
23:
	registers[5] = memory[5 + 0];
24:
	registers[9] = registers[8] + registers[0];
25:
	registers[4] = registers[4] * registers[6];
26:
	registers[3] = registers[3] * registers[5];
27:
	registers[4] = registers[4] + registers[3];
28:
	memory[19 + 4] = registers[4];
29:
	registers[3] = memory[11 + 0];
30:
	registers[8] = memory[10 + 8];
31:
	registers[5] = memory[11 + 4];
32:
	registers[7] = memory[10 + 4];
33:
	registers[4] = memory[11 + 8];
34:
	registers[6] = memory[10 + 0];
35:
	registers[3] = registers[3] * registers[8];
36:
	registers[5] = registers[5] * registers[7];
37:
	registers[4] = registers[4] * registers[6];
38:
	registers[3] = registers[3] + registers[5];
39:
	registers[3] = registers[3] + registers[4];
40:
	registers[18] = registers[0] + ( 0 );
41:
	registers[18] = ( registers[18] - registers[22] ); //Not completed
42:
	if ( registers[18] >= 0 ) { goto [HERE]+92};
43:
	memory[19 + 8] = registers[3];
44:
	registers[6] = registers[10] + ( 0 );
45:
	registers[12] = registers[0] + ( 0 );
46:
	if ( registers[9] <= 0 ) { goto [HERE]+52};
// ------- wile(CONDITION) -------
47:
	registers[10] = registers[0] + registers[0];
48:
	registers[8] = registers[6] + registers[0];
49:
	registers[7] = registers[10] + registers[0];
50:
	registers[3] = ( registers[12] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
51:
	registers[12] = registers[12] + ( 0 );
52:
	memory[19 + 3] = registers[10];
53:
	registers[18] = registers[22] - registers[12] + 1;
54:
	if ( registers[18] != 0 ) { goto [HERE]+-68};
55:
	registers[6] = registers[6] + ( 0 );
// ------- wile(CONDITION) -------
56:
	registers[3] = ( registers[7] << ( 1026 ) );//Not completed
// ------- wile(CONDITION) -------
57:
	registers[5] = memory[8 + 0];
58:
	registers[4] = memory[11 + 3];
59:
	registers[7] = registers[7] + ( 0 );
60:
	registers[8] = registers[8] + ( 0 );
61:
	registers[4] = registers[4] * registers[5];
62:
	registers[18] = registers[9] - registers[7] + 1;
63:
	if ( registers[18] != 0 ) { goto [HERE]+-28};
64:
	registers[10] = registers[10] + registers[4];
// ------- wile(CONDITION) -------
65:
	registers[19] = memory[1 + 4];
66:
	registers[22] = memory[1 + 8];
67:
	PC = registers[15] + ( imm ); //Not completed
68:
	registers[1] = registers[1] + ( 0 );
69:
	registers[15] = memory[1 + 0];
70:
	registers[3] = registers[0] + registers[0];
71:
	PC = registers[15] + ( imm ); //Not completed
72:
	registers[1] = registers[1] + ( 0 );
73:
	registers[19] = registers[3] + ( 0 );
74:
	goto [HERE]+832};
	registers[15] = [HERE];
75:
	registers[0] = registers[0] || registers[0];
76:
	registers[1] = registers[1] + ( 0 );
77:
	}
