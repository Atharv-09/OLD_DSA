import java.util.*;


class Graph_BFS{

	// array of linked list 
	private LinkedList<Integer>[] adj;

	Graph_BFS(int v){
		adj = new LinkedList[v];

		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}


	void addEdge(int src,int dest){

		adj[src].add(dest);
		adj[dest].add(src);

	}

	void BFS(int src,int dest){

		boolean visited[] = new boolean[adj.length];
		Arrays.fill(visited,false);
		Queue<Integer> qu = new LinkedList<>();
		
		// it stores the record who introduce whom
		int parent[] = new int[adj.length];
		
		qu.add(src);
		parent[src] = -1; // as src is not introduced by anuone 
		visited[src] = true;

		while(!qu.isEmpty()){

			int curr = qu.poll();
			//if curr is the dest then brea

			if(curr==dest) break;

			for(int neighbor: adj[curr]){

				if(!visited[neighbor]){
					visited[neighbor] = true;
					qu.add(neighbor);
					parent[neighbor] = curr;
				}
			}
		}

		int curr = dest;
		int dist;
		while(parent[curr] != -1){
			System.out.print(curr+"->");
			curr = parent[curr];
			dist++;
		}
		return dist;
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter vertices and edges : ");
		int v = sc.nextInt();
		int e = sc.nextInt();


		Graph_BFS gb = new Graph_BFS(v);

		System.out.println("Enter " + e + " edges : ");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();

			gb.addEdge(src,dest);
		}

		System.out.print("Enter source : ");
		int src1 = sc.nextInt();
		System.out.print("\nEnter destination : ");
		int dest1 = sc.nextInt();

		int dist = gb.BFS(src1,dest1);
		System.out.println("Smallest distance : " + dist);
	}
}