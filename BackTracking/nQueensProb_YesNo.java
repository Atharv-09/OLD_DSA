
import java.util.*;

class NQueen{
	private int N;

	NQueen(int n){
		N = n;
	}

	boolean isSafe(int board[][],int r,int c){

		// for row on left size 
		for(int i=0;i<c;i++){
			if(board[r][i] == 1) 
				return false;
		}

		for(int i=r,j=c;i>=0 && j>=0 ;i--,j--){
			if(board[i][j]==1)
				return false;
		}

		//diagonal on left lower side
		for(int i=r,j=c;j>=0 && i<N;i++,j--){
			if(board[i][j]==1)
				return false;
		}


		return true;
	}

	// we are calling here for sub problem 
	// we are calling for sub column as not for sub row as we have done in book
	//because of calling for sub colm from left to right 
	//prob becom easy to chek is safe or not
	//becoz we have to ogo from left utto queen col only not whole left,right,bot,up,let/right up.down daigonal
	boolean nQueenProb(int board[][],int col){

		if(col==N) return true;

		for(int row=0;row<N;row++){

			if(isSafe(board,row,col)){

				board[row][col] = 1;

				if(nQueenProb(board,col+1)){
					return true;
				}

				board[row][col] = 0;
			}	
		}
		return false;

	}

	void printSolution(int board[][]){

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter row count : ");
		int r = sc.nextInt();
		System.out.print("Enter col count : ");
		int c = sc.nextInt();

		NQueen nq = new NQueen(c);

		int board[][] = new int[r][c];

		if(nq.nQueenProb(board,0)){
			nq.printSolution(board);
		}else{
			System.out.println("Solution does not exist ");
		}
	}
}