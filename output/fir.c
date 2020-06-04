#include <stdio.h>

#define M 256
#define N  4

#define c0 2
#define c1 4
#define c2 4
#define c3 2

int  c[N] = {c0, c1, c2, c3};

int x[M] = {
    -1155484576, -723955400, 1033096058, -1690734402, -1557280266, 1327362106, -1930858313,
    502539523, -1728529858, -938301587, 1431162155, 1085665355, 1654374947, -1661998771,
    -65105105, -73789608, -518907128, 99135751, -252332814, 755814641, 1180918287,
    1344049776, 553609048, 1580443894, 629649304, -1266264776, 99807007, 5955764,
    -1946737912, 39620447, -152527805, -1877116806, 448784075, 1086124775, -1609984092,
    1227951724, 1764356251, 64111306, -960731419, -100082026, -39845375, -1339022546,
    2092649110, -568315836, -1089884900, -81839914, -1146103148, -1846688624, -784703072,
    55004124, -691960657, 1770461755, -2032810463, -1177788003, -432352882, -65824064,
    575267217, -1949367821, 356750287, 798819494, -92022521, 1318001577, -1192467086,
    -1412716779, -1223932479, 276053035, 615126903, 1542603436, 1988388716, 1177882237,
    19265476, -1430871151, 307082914, -1333570194, 1496453452, -790542135, 1455004595,
    -1690249972, -604059026, -290476856, -122204761, -1097539750, -576617062, -2002123957,
    -1663951485, 193034304, 768747578, 1337360486, 934457803, 873612482, -624972850,
    355564760, 41547336, 1781447028, -1321591463, 1081281446, -982203381, -222544851,
    -1233998085, -1331702554, 907249073, 206843130, -931610657, 1697401307, -234791961,
    -996341162, 61144662, -1638496702, 1693091376, -1667947369, -627963836, 105673451,
    -918940699, -300903254, -28037702, 1358495114, -502062723, 2056481282, 731396580,
    617380302, -162912754, 818693069, -1184143835, -410943565, -1385753324, 1233308008,
    -840115328, -1474241772, 1895913584, 1376826901, 1984652857, 412901507, -632101198,
    2025024491, -2139603013, -1233011876, -34604646, -1854979571, -131984708, -1866233577,
    1516579035, 1612513822, 203005342, -911714850, 307621155, 13453556, 125015832,
    483675743, 2077347671, 37011083, -120473323, 2069609186, -46741469, 1502566715,
    -998828580, -1206282339, -2141482063, -1550311379, 1097472880, 1449582151, 1327824311,
    -1105846005, -651630279, -1174121238, 223701431, 810978550, 43703267, 835843581,
    1519786882, -772329283, 372536197, -317962831, -642907139, -706495414, 15792134,
    -1116133237, 1322391079, -1231319713, -2011725892, 1299386162, -348690342, 1341976962,
    1190607957, -262501494, -540039728, -986836170, -1675546118, -1948015872, -392391576,
    638256747, 191085745, -97160665, -1517309270, 1375971382, 2133755906, 891811204,
    -2118700536, 2110473668, -2058625827, 861211557, 1573507430, 1625767564, 2051434938,
    -1922104200, -1271440420, 927536580, 1386277121, 1184911833, 50057146, -185358571,
    -1284027987, -1025692308, -1093701172, -1116573039, -1686684117, 2068400044, 1009668318,
    -1847249948, 1670927751, 408998980, -380240510, 1439774921, 718930634, -1800042595,
    16808464, -1743967552, 1137718941, 252008887, -460347667, -1053605891, 1278046001,
    947528252, 1842130704, 1599145891, -1341955486, 1631478226, 1754478786, -1370798799,
    1516348954, 730123440, -1409786204, 1491046204, -1114899725, -656053644, -453397258,
    -694901410, -1804067552, 13393714, -2101289195, 176533870, 1339899789, -1511804464,
    -1974699707, -1660688399, -115501757, 86156176
};



int fir_original(int x[], int c[], int M1, int N1, int *y) {
	int j, i;
	y[0]=c[0]*x[0];
	y[1]= c[0]*x[1]+c[1]*x[0];
	y[2]= c[0]*x[2]+c[1]*x[1]+c[2]*x[0];

  for(j=3; j<M1; j++) {
     int output=0;
     for(i=0; i<N1; i++) {
         output+=c[i]*x[j-i];
     }
     y[j] = output;
  }

  return y[j];
}

int main() {
	//int result;
	int y[M];

	printf("Output Original = %i",fir_original(x, c, M, N, y));

	printf(generated(x, c, M, N, y, malloc(1000)));


	//return result;
	return 0;
}


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

	printf("\n1\n");

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
printf("2\n");
	if ( registers[9] <= 0 ) {
		goto L572;
	}
	registers[8] = registers[6] + registers[0];
	registers[7] = registers[10] + registers[0];
L572:
printf("3\n");
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
	printf("4\n");
	registers[3] = ( registers[7] << ( 1026 ) );//Not completed
	printf("5\n");
// ------- wile(CONDITION) -------
	//registers[5] = memory[registers[8] + registers[0]];
	registers[4] = memory[registers[11] + registers[3]];printf("7\n");
	registers[7] = registers[7] + ( 1 );printf("8\n");
	registers[8] = registers[8] + ( -4 );printf("9\n");
	registers[4] = registers[4] * registers[5];printf("10\n");
	registers[18] = registers[9] - registers[7] + 1;printf("11\n");
	printf("12\n");
	registers[10] = registers[10] + registers[4];
	if ( registers[18] != 0 ) {
		goto L536;
	}
	printf("7\n");
// ------- wile(CONDITION) -------
L596:
printf("End");
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
