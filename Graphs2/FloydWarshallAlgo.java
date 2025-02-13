// It gives the shortest path betn all the vertices 
// as dijkstra give the shortes path from 1 src to other vertices 
// but lfoyd warshall algo gives the shortest path from all the vertices to alll other vertices 
/* Time complexity - O(V^3)
 * Space complexity - O(V^2)
 */


// NOT GIVING Ans

import java.util.*;


 class FloydWarshall{

 	private int ver ;
 	private static int INF = 99999;

 	// private Map<Integer,List<Edge>> map;
 	int distanceMat[][];

 	FloydWarshall(int v){

 		ver = v;
 		distanceMat = new int[ver][ver];
	}

 	void addEdge(int s,int d,int w){

 		distanceMat[s][d] = w;
 	}
 		
 	void addInfi(){

 		for(int i=0;i<ver;i++){
 			for(int j=0;j<ver;j++){
 				if(distanceMat[i][j]==0 && i==j){
 					distanceMat[i][j] = -1;
 				}else if(distanceMat[i][j]==0 && i!=j){
 					distanceMat[i][j] = INF;
 				}
 			}
 		}
 	}

 	 int distance[][];
 	 int path[][];
 	

 	void floydWarshallAlgo(){

 		distance= new int[ver][ver];
 		path = new int[ver][ver];

 		/// initialise both matrix 
 		for(int i=0;i<ver;i++){
 			for(int j=0;j<ver;j++){

 				distance[i][j] = distanceMat[i][j];
 				if(distanceMat[i][j]!=INF && i!=j){
 					path[i][j] = i;
 				}else{
 					path[i][j] = -1;
 				}
 			}
 		}

 		// for(int i=0;i<ver;i++){
 		// 	for(int j=0;j<ver;j++){
 		// 		System.out.print(distanceMat[i][j]+" ");
 		// 	}
 		// 	System.out.println();
 		// }

 		for(int k=0;k<ver;k++){
 			for(int i=0;i<ver;i++){
 				for(int j=0;j<ver;j++){

 					if(distance[i][k] == INF || distance[k][j] == INF)	
 						continue;

 					if(distance[i][j]>(distance[i][k]+distance[k][j])){
 						distance[i][j] = distance[i][k]+distance[k][j];
 						path[i][j] = distance[k][j];
 					}
 				}
 			}
 		}
 	}

 	void print(){

 		for(int i=0;i<ver;i++){
 			for(int j=0;j<ver;j++){
 				System.out.print(distance[i][j]+" ");
 			}
 			System.out.println();
 		}


 		for(int i=0;i<ver;i++){
 			for(int j=0;j<ver;j++){
 				System.out.print(path[i][j]+" ");
 			}
 			System.out.println();
 		}
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

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		FloydWarshall floyW = new FloydWarshall(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter source & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.print("Enter weight : ");
			int wei = sc.nextInt();

			floyW.addEdge(s,d,wei);
			
			floyW.addInfi();
		}
		floyW.floydWarshallAlgo();
 			
 		System.out.print("Enter vertex1 and vertex2 : ");
 		int v1=sc.nextInt();
 		int v2=sc.nextInt();

 		floyW.printPath(v1,v2);	
 		// floyW.print();
 	}

 }