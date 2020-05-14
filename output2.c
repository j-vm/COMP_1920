int[32] registers;
memset(memory,0,1024);
int[8] flags;
int PC = 0;
int imm[32] = 0;
int main(){

PC = PC + ( 80 );
registers[13] = registers[0] + registers[2536];
registers[2] = registers[0] + registers[1224];
imm =  ( 8 );
registers[1] = registers[0] + registers[2552];
PC = PC + ( 200 );registers[15] = PC;
registers[0] = registers[0] || registers[0];
registers[1] = registers[1] + ( -20 );
memory[1 + 0] = registers[15];
PC = PC + ( 388 );registers[15] = PC;
registers[0] = registers[0] || registers[0];
PC = registers[15] + ( imm );
registers[0] = registers[0] || registers[0];
PC = PC + ( 824 );registers[15] = PC;
registers[0] = registers[0] || registers[0];
registers[1] = registers[1] + registers[-8];
memory[0 + 1] = registers[15];
PC = PC + ( -932 );registers[15] = PC;
registers[0] = registers[0] || registers[0];
imm =  ( 0 );
registers[3] = registers[0] + registers[0];
registers[1] = registers[1] + registers[-28];
registers[5] = registers[0] + registers[2524];
registers[6] = registers[0] + registers[2540];
if ( registers[3] == 0 ) { PC = PC + ( 16 ); }
memory[1 + 0] = registers[15];
registers[3] = memory[0 + 2528];
imm =  ( 0 );
registers[4] = registers[0] + registers[0];
if ( registers[3] == 0 ) { PC = PC + ( 28 ); }
registers[15] = memory[1 + 0];
PC = registers[15] + ( imm );
registers[1] = registers[1] + registers[28];
PC = PC + ( -80 );registers[15] = PC;
registers[0] = registers[0] || registers[0];
registers[3] = memory[0 + 1200];
registers[1] = registers[1] + registers[-32];
memory[1 + 28] = registers[19];
registers[19] = registers[0] + registers[1200];
registers[18] = registers[3] ^ ( -1 );
if ( registers[18] == 0 ) { PC = PC + ( 28 ); }
memory[1 + 0] = registers[15];
registers[15] = memory[1 + 0];
registers[19] = memory[1 + 28];
PC = registers[15] + ( imm );
registers[1] = registers[1] + registers[32];
registers[15] = memory[0 + 1];
PC = registers[15] + ( imm );
registers[1] = registers[1] + registers[8];
registers[6] = registers[0] + ( 0 );
registers[7] = registers[0] + ( 0 );
PC = PC + ( 284 );registers[15] = PC;
registers[5] = registers[0] + ( 0 );
registers[5] = registers[0] + registers[1252];
registers[6] = registers[0] + registers[1236];
registers[1] = registers[1] + registers[-1052];
registers[7] = registers[0] + registers[256];
registers[8] = registers[0] + registers[4];
memory[1 + 0] = registers[15];
PC = PC + ( -264 );registers[15] = PC;
registers[9] = registers[1] + registers[28];
registers[1] = registers[1] + registers[-12];
memory[1 + 4] = registers[19];
memory[1 + 8] = registers[22];
registers[4] = memory[5 + 0];
registers[3] = memory[6 + 0];
registers[19] = registers[9] + registers[0];
registers[11] = registers[6] + registers[0];
registers[3] = registers[3] * registers[4];
registers[10] = registers[5] + registers[0];
registers[22] = registers[7] + registers[0];
memory[19 + 0] = registers[3];
registers[4] = memory[6 + 0];
registers[3] = memory[11 + 4];
registers[6] = memory[5 + 4];
registers[5] = memory[5 + 0];
registers[9] = registers[8] + registers[0];
registers[4] = registers[4] * registers[6];
registers[3] = registers[3] * registers[5];
registers[4] = registers[4] + registers[3];
memory[19 + 4] = registers[4];
registers[3] = memory[11 + 0];
registers[8] = memory[10 + 8];
registers[5] = memory[11 + 4];
registers[7] = memory[10 + 4];
registers[4] = memory[11 + 8];
registers[6] = memory[10 + 0];
registers[3] = registers[3] * registers[8];
registers[5] = registers[5] * registers[7];
registers[4] = registers[4] * registers[6];
registers[3] = registers[3] + registers[5];
registers[3] = registers[3] + registers[4];
registers[18] = registers[0] + registers[3];
registers[18] = ( registers[18] - registers[22] ) );
if ( registers[18] >= 0 ) { PC = PC + ( 92 ); }
memory[19 + 8] = registers[3];
registers[6] = registers[10] + registers[12];
registers[12] = registers[0] + registers[3];
if ( registers[9] <= 0 ) { PC = PC + ( 52 ); }
// ------- wile(CONDITION) -------
registers[10] = registers[0] + registers[0];
registers[8] = registers[6] + registers[0];
registers[7] = registers[10] + registers[0];
registers[3] = ( registers[12] << ( 1026 ) );
// ------- wile(CONDITION) -------
registers[12] = registers[12] + registers[1];
memory[19 + 3] = registers[10];
registers[18] = registers[22] - registers[12] + 1;
if ( registers[18] != 0 ) { PC = PC + ( -68 ); }
registers[6] = registers[6] + registers[4];
// ------- wile(CONDITION) -------
registers[3] = ( registers[7] << ( 1026 ) );
// ------- wile(CONDITION) -------
registers[5] = memory[8 + 0];
registers[4] = memory[11 + 3];
registers[7] = registers[7] + registers[1];
registers[8] = registers[8] + registers[-4];
registers[4] = registers[4] * registers[5];
registers[18] = registers[9] - registers[7] + 1;
if ( registers[18] != 0 ) { PC = PC + ( -28 ); }
registers[10] = registers[10] + registers[4];
// ------- wile(CONDITION) -------
registers[19] = memory[1 + 4];
registers[22] = memory[1 + 8];
PC = registers[15] + ( imm );
registers[1] = registers[1] + registers[12];
registers[15] = memory[1 + 0];
registers[3] = registers[0] + registers[0];
PC = registers[15] + ( imm );
registers[1] = registers[1] + registers[1052];
registers[19] = registers[3] + registers[0];
PC = PC + ( 832 );registers[15] = PC;
registers[0] = registers[0] || registers[0];
registers[1] = registers[1] + registers[-8];
}
