class SurroundedRegion{


	void DFSUtil(char[][] mat,int x,int y){

		if(x<0 || y<0 || x>=mat.length || y>=mat[0].length || mat[x][y]!='o')
			return;

		mat[x][y] = 'M';

		DFSUtil(mat,x+1,y);
		DFSUtil(mat,x-1,y);
		DFSUtil(mat,x,y-1);
		DFSUtil(mat,x,y+1);


	}

	char[][] surroundedRegion(char[][] mat){

		// for the first and last row 
		if(mat.length==0) return null;
		for(int j=0;j<mat[0].length;j++){

			if(mat[0][j] == 'o')
				DFSUtil(mat,0,j);

			if(mat[mat.length-1][j] == 'o')
				DFSUtil(mat,mat.length-1,j);

		}	
		//for first and last column 

		for(int i=0;i<mat.length;i++){

			if(mat[i][0] == 'o')
				DFSUtil(mat,i,0);
			if(mat[i][mat[0].length-1]=='o')
				DFSUtil(mat,i,mat[0].length-1);
		}

		//now chk who is not surrounded by x in all direction ehich we marked as the M 
		// make m as o 
		//and make o as x , as when we check it is already surrounded by the x in all direction 
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){

				if(mat[i][j] == 'o'){
					mat[i][j] = 'x';
				}
				if(mat[i][j] == 'M'){
					mat[i][j] = 'o';
				}
			}
		}

		return mat;

	}

	public static void main(String[] args) {
			
		/*char[][] mat = {{'x','x','x','o','x'},
						{'x','x','o','x','o'},
						{'x','x','o','o','o'},		 
						{'o','x','x','x','x'},
						{'x','x','o','o','x'},
						{'x','x','x','x','x'}
					   }; */

		char[][] mat = {{'x','x','x','x'},
						{'x','o','o','x'},
						{'x','x','o','x'},
						{'x','o','x','x'}};
		char[][] ans = new SurroundedRegion().surroundedRegion(mat);
		for(int i=0;i<ans.length;i++){
			for(int j=0;j<ans[i].length;j++){
				System.out.print(ans[i][j]+" ");
			}

			System.out.println();
		}
	}
}

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/DFS
$ java SurroundedRegion
x x x o x
x x o x o
x x o o o
o x x x x
x x x x x
x x x x x


hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/DFS
$ java SurroundedRegion
x x x x
x x x x
x x x x
x o x x

*/