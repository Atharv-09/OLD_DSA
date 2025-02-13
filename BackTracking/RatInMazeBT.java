import java.util.*;

class RatInMaze{

	int N;
	RatInMaze(int N){
		this.N = N;
	}

	void printSolution(int[][] sol){

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}

	boolean isSafe(int x,int y,int[][] maze){
		// if the rat is in maze size
		//amd
		//rat where it is going is not blocked  
		return(x>=0 && y>=0 && x<N && y<N && maze[x][y]==1);
	}
	boolean solveMazeUntil(int x,int y,int[][] maze,int sol[][]){

		//if we reach at dest return tre;

		if(x==N-1 && y==N-1 && maze[x][y]==1){
			sol[x][y] = 1;
			return true;
		}

		if(isSafe(x,y,maze)){

			//we assumed that the way we are going will give ans
			//if it will not give solution then we backtrack below and make as 0
			sol[x][y] = 1;
				
			//to go i right direction
			if(solveMazeUntil(x+1,y,maze,sol))
				return true;

			//if we move in x dir and dont give a solution increment row
			//or move in y dir
			if(solveMazeUntil(x,y+1,maze,sol))
				return true;
			
			
			//if we move in y direction dosnt give the sol then move backward in x dir
			if(solveMazeUntil(x-1,y,maze,sol))
				return true;
			//if we move in  x dir doesnt giv the sol then move upwards in y dir
			if(solveMazeUntil(x,y-1,maze,sol))
				return true;
			
			sol[x][y] = 0; // BACKTRACK
			return false;
		}

		return false;

	}

	boolean ratInMaze(int[][] maze,int[][] sol){

		return solveMazeUntil(0,0,maze,sol);

	}
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter n for n*n matrx : ");
		int n =sc.nextInt();

		int matrix[][] = new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print("Enter "+i+" "+j+" : ");
				matrix[i][j] = sc.nextInt();
			}
			// System.out.println();
		}

		RatInMaze rim = new RatInMaze(n);

		int sol[][] = new int[n][n];


		if(!rim.ratInMaze(matrix,sol))
			System.out.println("Solution does not exist");
		else
			rim.printSolution(sol);
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java RatInMaze
Enter n for n*n matrx : 4
Enter 0 0 : 1
Enter 0 1 : 0
Enter 0 2 : 0
Enter 0 3 : 0
Enter 1 0 : 1
Enter 1 1 : 1
Enter 1 2 : 0
Enter 1 3 : 1
Enter 2 0 : 0
Enter 2 1 : 1
Enter 2 2 : 0
Enter 2 3 : 0
Enter 3 0 : 1
Enter 3 1 : 1
Enter 3 2 : 1
Enter 3 3 : 1
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1
*/


/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java RatInMaze
Enter n for n*n matrx : 5
Enter 0 0 : 1
Enter 0 1 : 0
Enter 0 2 : 1
Enter 0 3 : 0
Enter 0 4 : 1
Enter 1 0 : 1
Enter 1 1 : 1
Enter 1 2 : 1
Enter 1 3 : 1
Enter 1 4 : 1
Enter 2 0 : 0
Enter 2 1 : 1
Enter 2 2 : 0
Enter 2 3 : 1
Enter 2 4 : 0
Enter 3 0 : 1
Enter 3 1 : 0
Enter 3 2 : 0
Enter 3 3 : 1
Enter 3 4 : 1
Enter 4 0 : 1
Enter 4 1 : 1
Enter 4 2 : 1
Enter 4 3 : 0
Enter 4 4 : 1
1 0 0 0 0
1 1 1 1 0
0 0 0 1 0
0 0 0 1 1
0 0 0 0 1
*/

/* https://geekstocode.com/wp-content/uploads/2020/06/Screenshot-from-2020-06-09-13-56-11.png
$ java RatInMaze
Enter n for n*n matrx : 5
Enter 0 0 : 1
Enter 0 1 : 0
Enter 0 2 : 1
Enter 0 3 : 1
Enter 0 4 : 1
Enter 1 0 : 1
Enter 1 1 : 1
Enter 1 2 : 1
Enter 1 3 : 0
Enter 1 4 : 1
Enter 2 0 : 1
Enter 2 1 : 0
Enter 2 2 :
0
Enter 2 3 : 1
Enter 2 4 : 1
Enter 3 0 : 1
Enter 3 1 : 0
Enter 3 2 : 0
Enter 3 3 : 1
Enter 3 4 : 0
Enter 4 0 : 1
Enter 4 1 : 0
Enter 4 2 : 0
Enter 4 3 : 1
Enter 4 4 : 1
1 0 1 1 1
1 1 1 0 1
0 0 0 1 1
0 0 0 1 0
0 0 0 1 1
*/