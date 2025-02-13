import java.util.*;

class KnightTour{

	int N;
	KnightTour(int n){
		N = n;
	}
	boolean isSafe(int x,int y,int[][] sol){

		return(x>=0 && y>=0 && x<N && y<N && sol[x][y] == -1);

	}

	void printSolution(int[][] sol){

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}

	boolean knightTour(int x, int y, int moveI,int sol[][], int xMove[],int yMove[])                           
    {
        int k, nextX, nextY;
        if (moveI == N * N)
            return true;
 
        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < N; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, sol)) {
            	// igf it is safe then add to sol mat and chk from new position to next
                sol[nextX][nextY] = moveI;
                if (knightTour(nextX, nextY, moveI + 1,sol, xMove, yMove))
                    return true;
                else
                    sol[nextX][nextY] = -1; // BACKTRACK
            }
        }
 
        return false;
    }

	void findCell(int sol[][])
    {
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
 
        // int xMove[] = {1,1,-1,-1,2,2,-2,-2 };
        // int yMove[] = {2,-2,2,-2,1,-1,1,-1 };   
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
 
        // knight is initially at the first block
        sol[0][0] = 0;
 
      	//start from 0,0 all the tours
        if (!knightTour(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return;
        }
        else
            printSolution(sol);
 
        return;
    }

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter dimension : ");
		int n = sc.nextInt();

		KnightTour kt = new KnightTour(n);

		int sol[][] = new int[n][n];

		kt.findCell(sol);


	}
}


/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java KnightTour
Enter dimension : 8
0 59 38 33 30 17 8 63
37 34 31 60 9 62 29 16
58 1 36 39 32 27 18 7
35 48 41 26 61 10 15 28
42 57 2 49 40 23 6 19
47 50 45 54 25 20 11 14
56 43 52 3 22 13 24 5
51 46 55 44 53 4 21 12

*/