import java.util.*;


class NQueen{

	private int N;
	NQueen(int c){
		N = c;
	}
	int k = 1;
	void printSolution(int board[][]){

		System.out.println("Arrangement " + k++ + " : ");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	boolean isSafe(int board[][],int r,int c){

		for(int i=0;i<c;i++){
			if(board[r][i] == 1) return false;
		}

		//left top diag

		for(int i=r,j=c;i>=0&&j>=0;j--,i--){
			if(board[i][j]==1) return false;
		}

		for(int i=r,j=c;i<N&&j>=0;i++,j--){
			if(board[i][j]==1) return false;
		}

		return true;
	}

	boolean nQueenProb(int board[][],int col){

		if(col==N){
			printSolution(board);
			return true;
		}

		/* Consider this column and try placing 
    this queen in all rows one by one */
		boolean res = false;
		for(int row=0;row<N;row++){

			//we checked if the wueen is placed at row col 
			if(isSafe(board,row,col)){
				board[row][col] = 1;
				
				// if(nQueenProb(board,col+1)){
					// return true;
				// }

				// Make result true if any placement 
            	// is possible 
				res = nQueenProb(board,col+1) || res;

				board[row][col] = 0; // backtarcked 
			}
		}
		// return false;
		return res;  /* If queen can not be place in any row in 
        this column col then return false */
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter row count : ");
		int r = sc.nextInt();
		System.out.print("Enter col count : ");
		int c = sc.nextInt();

		NQueen nq = new NQueen(c);

		int board[][] = new int[r][c];

		if(nq.nQueenProb(board,0) == false){
			System.out.println("Solution does not exist ");
			return;
		}
		return;
	}
}
/*
$ java NQueen
Enter row count : 4
Enter col count : 4
Arrangement 1 :
0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0
Arrangement 2 :
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0


*/

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java NQueen
Enter row count : 6
Enter col count : 6
Arrangement 1 :
0 0 0 1 0 0
1 0 0 0 0 0
0 0 0 0 1 0
0 1 0 0 0 0
0 0 0 0 0 1
0 0 1 0 0 0
Arrangement 2 :
0 0 0 0 1 0
0 0 1 0 0 0
1 0 0 0 0 0
0 0 0 0 0 1
0 0 0 1 0 0
0 1 0 0 0 0
Arrangement 3 :
0 1 0 0 0 0
0 0 0 1 0 0
0 0 0 0 0 1
1 0 0 0 0 0
0 0 1 0 0 0
0 0 0 0 1 0
Arrangement 4 :
0 0 1 0 0 0
0 0 0 0 0 1
0 1 0 0 0 0
0 0 0 0 1 0
1 0 0 0 0 0
0 0 0 1 0 0

*/