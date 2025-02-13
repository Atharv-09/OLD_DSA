class Main{

	boolean isSafe(int[][] board,int r,int c){

		for(int i=0;i<col;i++){
			if(board[r][i]==1) return false;
		}

		for(int i=row,j=col;j>=0,i<n;i++,j--){
			if(board[i][j] == 1) return false;
		}

		for(int i=row)
	}
	boolean find(int[][] board,int row,int n){

		for(int col=row;col<n;col++){

			if(isSafe(board,row,col)){

			}

		}

	}
	public static void main(String[] args) {
		

		int queen = 4;

		int board[][] = new int[queen][queen];

		for(int i=0;i<queen;i++){
			for(int j=0;j<queen;j++){
				board[i][j] = 0;
			}
		}
		find(board,0,queen);
	
	}
}