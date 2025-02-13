import java.util.*;

class MColouring{

	static int ver;
	int color[];

	MColouring(int v){
		ver = v;
	}

	boolean isSafe(int[][] graph,int vertex,int[] color,int curr){
		for(int i=0;i<ver;i++){
			if(graph[vertex][i]==1 && curr==color[i]){
				return false;
			}
		}
		return true;
	}
	boolean graphColouringUtil(int[][] graph,int m,int[] color,int vertex){

		if(vertex==ver){
			return true; // if we reached at end of vertex
		}
		for(int i=1;i<=m;i++){

			// chck if the assg color is safe or not
			if(isSafe(graph,vertex,color,i)){

				color[vertex] = i;
				if(graphColouringUtil(graph,m,color,vertex+1)){
					return true;
				}
				color[vertex] = 0;
			}
		}
		return false;
	}

	void printSol(int[] color){
		for(int i=0;i<color.length;i++){
			System.out.println("For vertex " + i + " color = " + color[i]);
		}
	}
	void graphColouring(int[][] graph,int colorCount){


		color = new int[ver];
		for(int i=0;i<ver;i++)
			color[i] = 0;

		if(graphColouringUtil(graph,colorCount,color,0)){
			printSol(color);
		}else{
			System.out.println("Solution does not exist");
			return;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		System.out.print("Enter vertices count : ");
		int vertices = sc.nextInt();

		int[][] graph = new int[vertices][vertices];

		
		System.out.print("Enter adj matrix : ");
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++){
				graph[i][j] = sc.nextInt();
			}
		}
		
		System.out.print("Enter colour count : ");
		int m = sc.nextInt();
		MColouring mc = new MColouring(vertices);
		
		mc.graphColouring(graph,m);
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java MColouring
Enter vertices count : 5
Enter adj matrix :
0 1 0 0 1
1 0 1 0 1
0 1 0 1 1
0 0 1 0 1
1 1 1 1 0
Enter colour count : 3
For vertex 0 color = 1
For vertex 1 color = 2
For vertex 2 color = 1
For vertex 3 color = 2
For vertex 4 color = 3
*/

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java MColouring
Enter vertices count : 4
Enter adj matrix :
0 1 1 1
1 0 1 0
1 1 0 1
1 0 1 0
Enter colour count : 3
For vertex 0 color = 1
For vertex 1 color = 2
For vertex 2 color = 3
For vertex 3 color = 2
*/