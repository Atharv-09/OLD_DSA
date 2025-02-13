import java.util.*;
/*Given an M x N matrix, with a few hurdles arbitrarily placed, calculate the length of longest possible route possible from source to destination within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contains any diagonal moves and a location once visited in a particular path cannot be visited again.

For example, longest path with no hurdles from source to destination is highlighted for below matrix. The length of the path is 24.*/
class LongestRoute{	

	private static int r,c;
	static boolean vis[][];

	LongestRoute(int r,int c){
		this.r = r;
		this.c = c;
		vis = new boolean[r][c];
	}

	static boolean isSafe(int[][] mat,int x,int y){

		if(x>=0 && y>=0 && x<r && y<c && mat[x][y]==1 && !vis[x][y]){
			return true;
		}
		return false;
	}

	// static int currPathSum = 0;
	static int findShortestPathUtil(int[][] mat,int x,int y,int max_dist,int dist){

		if(x== r-1 && y==c-1){
			
			// System.out.println(res);
			max_dist = Math.max(max_dist,dist);
		}
		// if(isSafe(mat,x,y)){

			// int res = Integer.MIN_VALUE;
			vis[x][y] = true;
			// mat[x][y] = 1;
			// currPathSum++;
			if(isSafe(mat,x,y+1)){

				max_dist = findShortestPathUtil(mat,x,y+1,max_dist,dist+1);
			}
			if(isSafe(mat,x+1,y)) max_dist = findShortestPathUtil(mat,x+1,y,max_dist,dist+1);
			if(isSafe(mat,x-1,y)) max_dist = findShortestPathUtil(mat,x-1,y,max_dist,dist+1);
			if(isSafe(mat,x,y-1)) max_dist = findShortestPathUtil(mat,x,y-1,max_dist,dist+1);

			vis[x][y] = false;
			// mat[x][y] = 0;

		// }
		// return currPathSum;
			return max_dist;
	}
	static void findShortestPath(int[][] mat){

		int max_dist = 0;
		int ans = findShortestPathUtil(mat,0,0,max_dist,0);

		System.out.println(ans);

	}
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter rows count : ");
		int r = sc.nextInt();

		System.out.print("Enter cols count : ");
		int c = sc.nextInt();

		LongestRoute lr=new LongestRoute(r,c);

		int[][] mat = new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				mat[i][j] = sc.nextInt();
			}
		}

		findShortestPath(mat);
	}
}

/*Enter rows count : 3
Enter cols count : 5
1 1 1 1 1
1 1 0 1 1
1 1 1 1 1
12


//answer is getting wrong
$ java LongestRoute
Enter rows count : 3
Enter cols count : 10
1 1 1 1 1 1 1 1 1 1
1 1 0 1 1 0 1 1 0 1
1 1 1 1 1 1 1 1 1 1
23


*/