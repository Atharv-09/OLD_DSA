class Prims{
	private final int V;
	private int graph[][];

	Prims(int V){
		this.V = V;
		graph = new int[V][V];


	}	

	int minWei(boolean[] vis,int[] wei){

		int min = Integer.MAX_VALUE;
		int min_ind =-1;

		for(int i=0;i<V;i++){

			if(!vis[i] && wei[i] < min){
				min = wei[i];
				min_ind = i;
			}
		}

		return min_ind;
	}

	void printMST(int[] parent){

			int totalCost = 0;
			System.out.println("Edge \t weigth");
			for(int i=1;i<V;i++){
				System.out.println(parent[i]+" - "+ i + "\t" + graph[i][parent[i]]);
				totalCost+=graph[i][parent[i]];
			}

			System.out.println("Total Minimum cost of MST : " + totalCost);  
	}
	void findMST_Prims(){

		int parent[] = new int[V];
		int wei[] = new int[V];
		boolean vis[] = new boolean[V];

		for(int i=0;i<V;i++){
			wei[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}

		wei[0] = 0;
		parent[0] = -1;

		for(int i=0;i<V-1;i++){
			// this looopp go though all the vertexes 
			// then find the min weight edge to go thought that edge 
			// this minWei return the dest point of minweight 

			int minWeiKey = minWei(vis,wei);

			// this loop find the all the edges MST 
			// as we get our first edge in fort loop then from that edge ths woll loop al the other edges
			// and then do same for the next edges 
			for(int ver=0;ver<V;ver++){

				if(graph[minWeiKey][ver]!=0 && !vis[ver] && graph[minWeiKey][ver] < wei[ver]){
					wei[ver] =graph[minWeiKey][ver];
					parent[ver] = minWei;	
				}

			}
		}
		printMST(parent);
	}

	public static void main(String[] args) {
			

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		Prims g = new Prims(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter source & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.print("Enter weight : ");
			int wei = sc.nextInt();

			g.addEdge(s,d,wei);
		}

		g.findMST_Prims();
	}
}