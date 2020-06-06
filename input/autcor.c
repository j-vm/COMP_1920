/*===============================================================================
*
*       TEXAS INSTRUMENTS, INC.
*
*       AUTOCORRELATION
*
*       Revision Date:  04/16/97
*/

/* DSP performance:
   (N/2) *M + 16 + M/4
   For N=160 and M=10;
   816 cycles or 4.08 �sec
*/

//#include "XPP.h"

#define N 160   //--- Length of Input array vector (sd[]) -
#define M 16 //(MULTIPLE of 2)

short sd[N] = { // --- Input array of autocorrelation
    -19360, 20792, -13446, 28862, -13834, -4038, 28855,
    9475, -17858, -22675, -13013, -4021, -15837, -5811,
    -27857, 3928, 6920, -20217, -19214, -12047, 25103,
    -28048, 26456, -22282, -20584, 21816, -4321, -8012,
    8968, -28833, -25533, 30842, -6453, -3353, -26716,
    3692, -3941, 17098, 26341, -8554, 513, 9006,
    19094, 12356, -21220, 14550, -9580, -15216, 24992,
    19420, -31569, 6715, -14815, 24989, -11890, -25920,
    -7791, 499, -27697, 1190, -9977, 7081, 25970,
    -22763, 17857, 15403, 6007, 17068, 26476, 3709,
    -2108, -23663, -18782, 21870, 4428, 18633, -25677,
    -10996, -13714, -21304, 19879, -8358, -31334, 843,
    7555, 30784, 10298, -32666, -20021, 17602, -21554,
    31960, -2488, -18060, 7513, 2982, -15349, 15405,
    -20741, -11034, -31311, 11514, -16417, 18907, 23527,
    2646, -426, -31166, -31184, 9367, 2116, 29419,
    5093, -27478, 11706, -630, 8573, 27138, 14820,
    31182, 9742, 17357, 26149, 32691, 5396, -13976,
    -9344, -9452, 22640, -18923, 26169, 24707, -6478,
    27627, 16315, -17572, -1638, 16909, 4796, -30441,
    10459, 542, -25186, 21982, -4829, 18676, -26856,
    20063, -12457, -16757, -18155, -17694, -14301, 22843,
    5596, -26723, -27727, 8237, 7024, -8633
};

// Inputs sd
// Outputs ac
    void autcor(short* ac, short* sd, int n, int m) {
      int i,k,sum;

	for (i = 0; i < m; i++){
	
		sum = 0;

		for (k = 0; k < n; k++) {
			sum += sd[k+m] * sd[k+m-i];
		}

		ac[i] = (sum >> 15);
	}

  //return 0;
}

int main() {
	short ac[M]; // --- Resulting array of autocorrelation

  	//int result;

  	autcor(ac, sd, N, M);

  	//return result;
  	return 0;
}


