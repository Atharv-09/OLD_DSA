import java.util.*;

class SudokuSolver{	

	public static boolean isSafe(int[][] board,int r, int c,int num)
    {
         //   for row 
         for(int i=0;i<board.length;i++){
             if(board[r][i] == num) return false;
         }
         //for col 
         for(int i=0;i<board.length;i++){
             if(board[i][c] == num) return false;
         }
         //now chk in 3x3 matrix around it 

         int sqrt = (int)Math.sqrt(board.length);
         int rowStart = r-r%sqrt;
         int colStart = c-c%sqrt;

         for(int rowS=rowStart;rowS<rowStart+sqrt;rowS++){
             for(int colS=colStart;colS<colStart+sqrt;colS++){
                 if(board[rowS][colS] == num) return false;
             }
         }
 
    
        // if there is no clash, it's safe
        return true;
    }
 
    public static boolean sudokuSolve(int[][] board, int n)
    {   
         int row = -1;
         int col = -1;
         boolean isEmpty = true;
         // firwst get the empy row and col 
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){

                 if(board[i][j] == 0){
                     row = i;
                     col = j;
                     isEmpty = false;
                     break;
                 }
             }
             if(!isEmpty) break; // is not empty then break form that row 
         }

        if(isEmpty) return true; // no empty space left 
       
        for(int i=1;i<=n;i++){

             if(isSafe(board,row,col,i)){

                 board[row][col] = i;

                 if(sudokuSolve(board,n))
                     return true;
                 else
                     board[row][col] = 0; // BACKTRACK 

             }
         }
        return false;
    }
 
    public static void printSolution(int[][] board, int N)
    {
        for (int r = 0; r < N; r++){
            for (int d = 0; d < N; d++){
                System.out.print(board[r][d]+" ");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter board of 9x9 matrix : ");
		int[][] board = new int[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = sc.nextInt();
			}
		}

		SudokuSolver ss = new SudokuSolver();
		
		if(sudokuSolve(board,9))
			printSolution(board,9);
		else
			System.out.println("No solution");
		
	}
}

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java SudokuSolver
Enter board of 9x9 matrix :
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

ans : 
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9

*/