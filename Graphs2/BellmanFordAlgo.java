// This algo is for directed/undirected weigthted graphs 
// It gives the single source shortest path to all of the vertices 

// It was helpful for -ve weight 
//as using Dijkstra we cannot getproper ans for -ve weight cycle 
// TIME : O(VE);
// which is slower then dijkstra


// DP Problem 


import java.util.*;

class BellmanFordAlgo{
	class Edge{
		int src;
		int dest;
		int wei;
		
		// Edge(int src,int dest,int wei){
		// 	this.src = src;
		// 	this.dest = dest;
		// 	this.wei = wei;
		// }
	}


	private int V,E;
	// private Map<Integer,List<Edge>> adj;

	Edge edge[];


	BellmanFordAlgo(int v,int e){

		V = v;
		E = e;
		// adj = new HashMap<Integer,List<Edge>>();

		edge = new Edge[E];
		for(int i=0;i<e;i++)
			edge[i] = new Edge();
			// adj.put(new LinkedList<Edge>());
	}
	

	void addEdge(int s,int d,int w,int i){	

		edge[i].src = s;
		edge[i].dest = d;
		edge[i].wei = w;

	}

	void printDistances(int[] dist,int src,int parent[]){

		System.out.println("From source : " + src);
		System.out.println("To" + " " + "Distance");
		for(int i=0;i<dist.length;i++){

			System.out.println(i + " " + dist[i]);
		}

		System.out.println("COMES VIA : ");


		for(int i=0;i<parent.length;i++){
			System.out.println(i+" " + parent[i]);
		}
	}
	void findRelaxation(int dist[],int src,int[] parent){

		for(int i=0;i<V;i++){
			for(int j=0;j<E;j++){

				int u = edge[j].src;
				int v = edge[j].dest;
				int weight = edge[j].wei;

				if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
					dist[v] = dist[u]+weight;
					parent[v] = u;
				}
			}
		}

		// now chk for -ve weight cycle above step guarantee that there is no -ve weight cycle 
		//if we get the shorter path then there is cycle 

		for(int i=0;i<E;i++){
			int u = edge[i].src;
			int v = edge[i].dest;
			int weight = edge[i].wei;

			if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
		
				System.out.println("There is negative weight cycle !! Belman Ford aglgo fails here ");
				return;
			}
		}

		printDistances(dist,src,parent);
	}

	void bellmanFord(int source){

		int dist[] = new int[V];
		int parent[] = new int[V];

		dist[source] = 0;
		for(int i=0;i<V;i++){
			if(i!=source)
				dist[i] = Integer.MAX_VALUE;

			parent[i] = 0;
		}

		findRelaxation(dist,source,parent);

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

			BellmanFordAlgo bf = new BellmanFordAlgo(v,e);

			System.out.println("Enter "+e+" edges");
			for(int i=0;i<e;i++){
				System.out.print("Enter source & dest : ");
				int s =sc.nextInt();
				int d =sc.nextInt();
				System.out.print("Enter weight : ");
				int wei = sc.nextInt();

				bf.addEdge(s,d,wei,i);
			}

		System.out.print("Enter source : ");
		int src = sc.nextInt();

		bf.bellmanFord(src);
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java BellmanFordAlgo
Enter vertices and edges count : 7 10
Enter 10 edges
Enter source & dest : 0 1
Enter weight : 5
Enter source & dest : 0 2
Enter weight : 5
Enter source & dest : 0 3
Enter weight : 5
Enter source & dest : 2 1
Enter weight : -2
Enter source & dest : 3 2
Enter weight : -2
Enter source & dest : 1 4
Enter weight : -1
Enter source & dest : 2 4
Enter weight : 1
Enter source & dest : 3 5
Enter weight : -1
Enter source & dest : 5 6
Enter weight : 3
Enter source & dest : 4 6
Enter weight : 3
Enter source : 0
From source : 0
To Distance
0 0
1 1
2 3
3 5
4 0
5 4
6 3


hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java BellmanFordAlgo
Enter vertices and edges count : 4 4
Enter 4 edges
Enter source & dest : 0 3
Enter weight : 5
Enter source & dest : 0 1
Enter weight : 4
Enter source & dest : 3 2
Enter weight : 3
Enter source & dest : 2 1
Enter weight : -10
Enter source : 0
From source : 0
To Distance
0 0
1 -2
2 8
3 5


hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java BellmanFordAlgo
Enter vertices and edges count : 4 5
Enter 5 edges
Enter source & dest : 0 1
Enter weight : 4
Enter source & dest : 0 3
Enter weight : 5
Enter source & dest : 3 2
Enter weight : 3
Enter source & dest : 2 1
Enter weight : -10
Enter source & dest : 1 3
Enter weight : 5
Enter source : 0
There is negative weight cycle !! Belman Ford aglgo fails here



hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
Enter vertices and edges count : 4 4
Enter 4 edges
Enter source & dest : 0 1
Enter weight : 4
Enter source & dest : 0 3
Enter weight : 5
Enter source & dest : 3 2
Enter weight : 3
Enter source & dest : 2 1
Enter weight : -10
Enter source : 0
From source : 0
To Distance
0 0
1 -2
2 8
3 5
COMES VIA :
0 -1
1 2
2 3
3 0


*/