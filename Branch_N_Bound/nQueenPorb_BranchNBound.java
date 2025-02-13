
import java.util.*;

class NQueen{

	private static  int N;
	NQueen(int n){
		N = n;
	}		
	int k=1;

	void printSolution(int board[][]){

		System.out.println("Arrangement "+ k++ + " : "); 
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	void solveNQueen(int board[][],int row,boolean[] cols,boolean[] normalD,boolean[] reverseD){

		if(row==N){
			printSolution(board);
			// System.out.println(ans);
			return;
		}
		for(int col=0;col<N;col++){

			if(cols[col] == false && normalD[row+col]==false && reverseD[(row-col)+N-1]==false){
				board[row][col] = 1;
				// as we are at that ele index
				//we bloc it col left/right diagonal 
				//not take row coz queen kill automatically in row
				//so we direct jump to next row
				cols[col] = true;
				normalD[row+col] = true;
				reverseD[(row-col)+N-1] = true;
				solveNQueen(board,row+1,cols,normalD,reverseD); // to print index add one par as String ans and here add as ans+row+" "+col
				//BACKTRACKED 
				board[row][col] = 0;
				cols[col] = false;
				normalD[row+col] = false;
				reverseD[(row-col)+N-1] = false;
			}
		}


	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter row count : ");
		int r = sc.nextInt();
		System.out.print("Enter col count : ");
		int c = sc.nextInt();

		int board[][] = new int[r][c];

		NQueen nq = new NQueen(c);

		boolean cols[] = new boolean[N];
		//from top right to bottom left diaginal 
		boolean normalD[] = new boolean[2*N-1]; // where comman value is ROW+Col
		boolean reverseD[] = new boolean[2*N-1]; // where comman value is ROW-COl but -ve indexing is not there
		// in array so we make  ==>  ROW-COL + N-1; (n-1 becoz for 4*4 we have last value in array as 6)
		
		nq.solveNQueen(board,0,cols,normalD,reverseD);
	}

}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Branch_N_Bound
$ java NQueen
Enter row count : 4
Enter col count : 4
Arrangement 1 :
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
Arrangement 2 :
0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Branch_N_Bound
$ java NQueen
Enter row count : 5
Enter col count : 5
Arrangement 1 :
1 0 0 0 0
0 0 1 0 0
0 0 0 0 1
0 1 0 0 0
0 0 0 1 0
Arrangement 2 :
1 0 0 0 0
0 0 0 1 0
0 1 0 0 0
0 0 0 0 1
0 0 1 0 0
Arrangement 3 :
0 1 0 0 0
0 0 0 1 0
1 0 0 0 0
0 0 1 0 0
0 0 0 0 1
Arrangement 4 :
0 1 0 0 0
0 0 0 0 1
0 0 1 0 0
1 0 0 0 0
0 0 0 1 0
Arrangement 5 :
0 0 1 0 0
1 0 0 0 0
0 0 0 1 0
0 1 0 0 0
0 0 0 0 1
Arrangement 6 :
0 0 1 0 0
0 0 0 0 1
0 1 0 0 0
0 0 0 1 0
1 0 0 0 0
Arrangement 7 :
0 0 0 1 0
1 0 0 0 0
0 0 1 0 0
0 0 0 0 1
0 1 0 0 0
Arrangement 8 :
0 0 0 1 0
0 1 0 0 0
0 0 0 0 1
0 0 1 0 0
1 0 0 0 0
Arrangement 9 :
0 0 0 0 1
0 1 0 0 0
0 0 0 1 0
1 0 0 0 0
0 0 1 0 0
Arrangement 10 :
0 0 0 0 1
0 0 1 0 0
1 0 0 0 0
0 0 0 1 0
0 1 0 0 0
*/