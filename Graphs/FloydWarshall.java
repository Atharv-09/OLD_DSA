import java.util.*;


class FloydWarshall{
	private static int INF = 99999,ver=4;


	int path[][];
	void printAns(int dist[][]){

		for(int i=0;i<ver;i++){
			for(int j=0;j<ver;j++){
				if(dist[i][j]==INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
	void floydWarshall(int graph[][]){

					path = new int[ver][ver];

			int dist[][] = new int[ver][ver];

			for(int i=0;i<ver;i++){
				for(int j=0;j<ver;j++){
					dist[i][j] = graph[i][j];

					if(graph[i][j]!=INF && i!=j){
 						path[i][j] = i;
 					}else{
 						path[i][j] = -1;
 					}
				}
			}

			for(int k=0;k<ver;k++){
				for(int i=0;i<ver;i++){
					for(int j=0;j<ver;j++){
						if(dist[i][k]+dist[k][j]<dist[i][j]){
							dist[i][j] = dist[i][k]+dist[k][j];
	 						path[i][j] = dist[k][j];
						}
					}
				}
			}

			printAns(dist);
	}

	void printPath(int src,int des){

 		if(src<0 || des<0 || src>=ver || des>=ver)
 				throw new IllegalArgumentException();

 		System.out.println("Actual Path between : " + src + " and " + des);

 		Deque<Integer> st = new LinkedList<>();
 		st.addFirst(des);

 		while(true){

 			des = path[src][des];
 			if(des==-1) return ; // if there is no path /self path 
 			st.addFirst(des);
 			if(src==des) break;
 		} 

 		while(!st.isEmpty()){

 			System.out.print(st.pollFirst()+" -> ");
 		}

 	}
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		int graph[][] = {{0,3,6,15},{INF,0,-2,INF},{INF,INF,0,2},{1,INF,INF,0}};

		FloydWarshall fw = new FloydWarshall();
		
		System.out.print("Enter src : ");
		int s = sc.nextInt();
		System.out.println("Enter dest : ");
		int d = sc.nextInt();

		fw.floydWarshall(graph);

		fw.printPath(s,d);


	}
}