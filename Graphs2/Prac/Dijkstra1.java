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
	

	int minDistance(int[] dist,boolean[] splitSet){
		
	}
	void dijkstra(int src){


		int dist[] = new int[V];
		boolean splitSet[] = new boolean[V];

		for(int i=0;i<V;i++){
			dist[i] = Integer.MAX_VALUE;
			splitSet[i] = false;
		}

		dist[src] = 0;

		int[] parents = new int[V];
		parents[src] = -1;

		for(int c=0;c<V-1;c++){
			int minDist = minDistance(dist,splitSet);


		}

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