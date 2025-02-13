class Graph{

	static void drawTreeDFS(boolean[][] vis,int i,int j,int[][] grid){

		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j] == 0) return;

		vis[i][j] = true;

		drawTreeDFS(vis,i-1,j,grid);//upper neightbor
		drawTreeDFS(vis,i,j+1,grid);//lower neightbor
		drawTreeDFS(vis,i,j-1,grid);//prev neightbor
		drawTreeDFS(vis,i+1,j,grid);//next neightbor

	}
	public static void main(String[] args) {
		
	/*	int grid[][] = {{1, 1, 0, 0, 0},

                   {0, 1, 0, 0, 1},

                   {1, 0, 0, 1, 1},

                   {0, 0, 0, 0, 0},

                   {1, 0, 1, 0, 1} };*/

        int grid[][] = {{0,1, 0},
					   {0, 1, 0},
					   {0, 0, 0},
					   {1, 1, 0},
					   {1, 0 ,1},
					   {0, 1 ,1},
					   {1 ,1, 1},
					   {0 ,1 ,1},
					   {1, 0 ,1},
						};


		boolean[][] vis = new boolean[grid.length][grid[0].length];

		int count = 0;

		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){

				if(grid[i][j] == 1 && !vis[i][j]){

					drawTreeDFS(vis,i,j,grid);
					count++;
				}

			}
		}

		System.out.println(count);
	}
}