	import java.util.*;
// TIME : O(v^2);
class Graph{

	private final int V;
	private int graph[][];

	Graph(int V){
		this.V = V;
		graph = new int[V][V];


	}

	int findMinKey(int key[],boolean vis[]){

		int min = Integer.MAX_VALUE;
		int min_index = -1;


		for(int i=0;i<V;i++){

			if(!vis[i] && key[i] < min){

				// as we stored in adj matrix 
				min_index = i;
				min = key[i];
			}
		}

		return min_index;

	}

	void printMST(int parent[]){
		int totalCost = 0;
		System.out.println("Edge \t weigth");
		for(int i=1;i<V;i++){
			System.out.println(parent[i]+" - "+ i + "\t" + graph[i][parent[i]]);
			totalCost+=graph[i][parent[i]];
		}

		System.out.println("Total Minimum cost of MST : " + totalCost);  
	}

	void primsMST(){

		int parent[] = new int[V];
		boolean vis[] = new boolean[V];
		int key[] = new int[V];

		for(int i=0;i<V;i++){
			key[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		// as the mst has v-1 vertices 
		for(int i=0;i<V-1;i++){

			int minKey = findMinKey(key,vis); // 1

			vis[minKey] = true;

			for(int v=0;v<V;v++){

				// is the graph is not visited 
				// and the dist is small then the curr distance 
				// and not eql to 0
				if(graph[minKey][v]!=0 && graph[minKey][v]<key[v] && vis[v] == false){

					key[v] = graph[minKey][v];
					parent[v] = minKey;

				}		

			}
		}

		printMST(parent);
	}



	void addEdge(int s,int d,int wei){
		
		graph[s][d] = wei;
		graph[d][s] = wei;

	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		Graph g = new Graph(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter source & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.print("Enter weight : ");
			int wei = sc.nextInt();

			g.addEdge(s,d,wei);
		}
			
		// g.print();

		g.primsMST();
	}
}