import java.util.*;


class Graph{

	private int[][] graph;
	private int V;
	Graph(int V){
		this.V = V;
		graph = new int[V][V];
	}


	void addEdge(int s,int d,int wei){

		graph[s][d] = wei;
		graph[d][s] = wei;

	}

	void print(){

		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}

	}

	int minDistance(int dist[],boolean sptSet[]){

		int min = Integer.MAX_VALUE,min_index= -1;

		for(int cur = 0;cur<V;cur++){
			if(sptSet[cur] == false && dist[cur]<=min){
				min = dist[cur];
				min_index = cur;
			}	
		}

		return min_index;

	}

	void printPath(int ind,int parents[]){

		if(ind == -1) return;

		printPath(parents[ind],parents);
		System.out.print(ind+" ");
	}

	void printSolution(int dist[],int parents[],int startVertex){
		System.out.println("The shortest distances are : ");
		for(int i=0;i<dist.length;i++){

			if(i!=startVertex){
				System.out.print("\n"+startVertex+" -> ");
				System.out.print(i+" \t\t ");
				System.out.print(dist[i]+"\t\t");
				printPath(i,parents);
			}
		}


	}
	void dijkstra(int src){

		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];

		for(int i=0;i<V;i++){
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		int[] parents = new int[V]; 
		parents[src] = -1;

		for(int count=0;count<V-1;count++){
			// pick the min distance vertex and chk 
			int minDist = minDistance(dist,sptSet);

			sptSet[minDist] = true;

			for(int v = 0;v<V;v++){
				// update dist[v] if it is not in sptSet and if totalWeig from u to v is smaller then curr path then rupadte
				// if the node is not visited and if the node is not at infinite dist and if the node is not null distance and 
				// if the node dist and dist betn node and next node there addn is less then the next nde dist then replace tht 
				if(!sptSet[v] && dist[minDist]+graph[minDist][v] < dist[v] && dist[minDist]!=Integer.MAX_VALUE && graph[minDist][v]!=0){
					
					parents[minDist] = dist[minDist];
					dist[v] = dist[minDist] + graph[minDist][v];
				}

			}
			// update dist[] only 
		}

		printSolution(dist,parents,src);

	}
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		Graph g = new Graph(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.println("Enter weight : ");
			int wei = sc.nextInt();
			g.addEdge(s,d,wei);
		}

		g.print();
	
		System.out.print("Enter source : ");
		int src = sc.nextInt();

		g.dijkstra(src);
	}

}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/ShortestPathALgo
$ java Graph
Enter vertices and edges count : 9 14
Enter 14 edges
0 1
Enter weight :
4
0 7
Enter weight :
8
1 7
Enter weight :
11
1 2
Enter weight :
8
6 7
Enter weight :
1
7 8
Enter weight :
7
8 6
Enter weight :
6
2 8
Enter weight :
2
2 3
Enter weight :
7
6 5
Enter weight :
2
3 4
Enter weight :
9
5 4
Enter weight :
10
3 5
Enter weight :
14
2 5
Enter weight :
4
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
Enter source : 0
The shortest distances are :
0    0
1    4
2    12
3    19
4    21
5    11
6    9
7    8
8    14

*/
/*
The set sptSet is initially empty and distances assigned to vertices are {0, INF, INF, INF, INF, INF, INF, INF} where INF indicates infinite. Now pick the vertex with minimum distance value. The vertex 0 is picked, include it in sptSet. So sptSet becomes {0}. After including 0 to sptSet, update distance values of its adjacent vertices. Adjacent vertices of 0 are 1 and 7. The distance values of 1 and 7 are updated as 4 and 8. Following subgraph shows vertices and their distance values, only the vertices with finite distance values are shown. The vertices included in SPT are shown in green colour.






Pick the vertex with minimum distance value and not already included in SPT (not in sptSET). The vertex 1 is picked and added to sptSet. So sptSet now becomes {0, 1}. Update the distance values of adjacent vertices of 1. The distance value of vertex 2 becomes 12.



Pick the vertex with minimum distance value and not already included in SPT (not in sptSET). Vertex 7 is picked. So sptSet now becomes {0, 1, 7}. 
Update the distance values of adjacent vertices of 7. 
The distance value of vertex 6 and 8 becomes finite (15 and 9 respectively).


Pick the vertex with minimum distance value and not already included in SPT (not in sptSET). 
Vertex 6 is picked. So sptSet now becomes {0, 1, 7, 6}. Update the distance values of adjacent vertices of 6. The distance value of vertex 5 and 8 are updated.



We repeat the above steps until sptSet does include all vertices of given graph.
 Finally, we get the following Shortest Path Tree (SPT).

*/