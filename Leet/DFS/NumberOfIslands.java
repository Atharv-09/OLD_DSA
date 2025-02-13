import java.util.*;

class NumberOfIslands{

	//TIME : O(ROW*COL)
	// 1 - > land 
	// 2 -> water 

	static void drawTreeForComp(int[][] adj,boolean[][] vis,int i,int j){

		if(i<0 || j<0 || i>=adj.length || j>=adj[0].length || adj[i][j]==0 || vis[i][j] == true)
				return ;


		vis[i][j] = true;
		drawTreeForComp(adj,vis,i+1,j);
		drawTreeForComp(adj,vis,i-1,j);
		drawTreeForComp(adj,vis,i,j+1);
		drawTreeForComp(adj,vis,i,j-1);

	}
	static void countIslands(int[][] adj,int row,int col){

		boolean vis[][] = new boolean[row][col];
		int count = 0;

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){

				if(adj[i][j]==1 && !vis[i][j]){
					drawTreeForComp(adj,vis,i,j);
					count++;
				}
			}
		}

		System.out.println("Total islands : " + count); 

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter row count : ");
		int r = sc.nextInt();

		System.out.print("Enter col count : ");
		int c = sc.nextInt();

		int[][] adj = new int[r][c];
		System.out.println("Enter matriz : ");
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				adj[i][j] = sc.nextInt();
			}
		}
		
		countIslands(adj,r,c);

	}
}


/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/DFS
$ java NumberOfIslands
Enter row count : 4
Enter col count : 5
Enter matriz :
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0
Total islands : 1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/DFS
$ java NumberOfIslands
Enter row count : 4
Enter col count : 5
Enter matriz :
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1
Total islands : 3

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/DFS
$ java NumberOfIslands
Enter row count : 8
Enter col count : 8
Enter matriz :
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
0 0 0 0 0 0 0 0
1 0 1 1 0 1 0 1
Total islands : 5*/