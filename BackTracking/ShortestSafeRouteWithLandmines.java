import java.util.*;
/*Given an M x N matrix, with a few hurdles arbitrarily placed, calculate the length of longest possible route possible from source to destination within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contains any diagonal moves and a location once visited in a particular path cannot be visited again.

For example, longest path with no hurdles from source to destination is highlighted for below matrix. The length of the path is 24.*/
class SafeRoute{	

	private int r,c;
	boolean vis[][];
	int rowNum[] = {-1,0,0,1};
	int colNum[] = {0,-1,1,0};
	int min_dist = 0;

	SafeRoute(int r,int c){
		this.r = r;
		this.c = c;
		vis = new boolean[r][c];
	}

	boolean isValid(int x,int y){
		return(x>=0 && y>=0 && x<r && y<c);
	}
	void marKAdjCellAsUnsafe(int mat[][]){

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){

				if(mat[i][j] == 0){
					//mark all adj as unsafe 

					for(int k=0;k<4;k++){

						int x_next = rowNum[k]+i;
						int y_next = colNum[k]+j;

						if(isValid(x_next,y_next)){
							mat[x_next][y_next] = -1; // we markes that as the unsafe 
						}
					}
				}
			}
		}
		for(int i = 0; i < r; i++) 
    	{
        	for(int j = 0; j < c; j++) 
        	{
            if (mat[i][j] == -1)
                mat[i][j] = 0;
        	}
    	}

	}
	boolean isSafe(int[][] mat,int x,int y,boolean[][] vis){

		if(mat[x][y]==1 || !vis[x][y]) return true;

		return false;	
	}
	void shortestSafeRouteInLandminesUtil(int[][] mat,boolean[][] vis,int x,int y,int dist){

		if(y==c-1) // if the j index reached at last column then stpo 
		{
			min_dist = Math.min(min_dist,dist);
			return;
		}

		if(dist>min_dist) return;

		vis[x][y] = true;
		// Recurse for all safe adjacent neighbours
    	for(int k = 0; k < 4; k++) 
    	{
			if(isValid(x+rowNum[k],y+colNum[k]) && isSafe(mat,x,y,vis)){

				shortestSafeRouteInLandminesUtil(mat,vis,x+rowNum[k],y+colNum[k],dist+1);
			}
		}
		vis[x][y] = false;
	}
	void shortestSafeRouteInLandmines(int[][] mat){

		min_dist = Integer.MAX_VALUE;
		boolean[][] vis = new boolean[r][c];

		marKAdjCellAsUnsafe(mat);

		for(int col=0;col<r;col++){

			if(mat[col][0] == 1){ // it was safe

				for(int k=0;k<r;k++)
					Arrays.fill(vis[k],false);

				shortestSafeRouteInLandminesUtil(mat,vis,col,0,0);


				if(min_dist == c-1)
					break;
			}
		}
		// s
		if(min_dist==Integer.MAX_VALUE){
			System.out.println("Destination cannot be reached");
		}else{
			System.out.println("Shortest route length : "+min_dist);
		}

	}
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter rows count : ");
		int r = sc.nextInt();

		System.out.print("Enter cols count : ");
		int c = sc.nextInt();

		SafeRoute lr=new SafeRoute(r,c);

		int[][] mat = new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				mat[i][j] = sc.nextInt();
			}
		}

		lr.shortestSafeRouteInLandmines(mat);

	}
}
