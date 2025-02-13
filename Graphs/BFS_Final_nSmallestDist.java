import java.util.*;


class Graph_BFS{
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked") Graph_BFS(int v) {
		adj = new LinkedList[v];
		for(int i = 0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	int bfs(int source, int destination) {
		
		boolean vis[] = new boolean[adj.length];
		int parent[] = new int[adj.length];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(source);
		parent[source] = -1;
		vis[source] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == destination) break;
			
			for(int neighbor: adj[cur]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					q.add(neighbor);
					parent[neighbor] = cur;
				}
			}
		}
		
		int cur = destination;
		int distance = 0;
		
		
		while(parent[cur] != -1) {
			System.out.print(cur+" -> ");
			cur = parent[cur];
			distance++;
		}
		System.out.print(cur);
		
		return distance;
	}
	
	/*private LinkedList<Integer> adj[];

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
		Queue<Integer> qu = new LinkedList<>();
		
		// it stores the record who introduce whom
		int parent[] = new int[adj.length];
		parent[src] = -1; // as src is not introduced by anuone 
		qu.add(src);


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
		while(parent[curr]!=-1){
			System.out.print(curr+"->");
			curr = parent[curr];
		}
	}
	*/
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
		int ans = gb.bfs(src1,dest1);
		
		System.out.println("Smallest distance : " + ans);
	}
}
/*$ java Graph_BFS
Enter vertices and edges :
5 6
Enter 6 edges :
0 1
0 4
1 2
4 2
3 4
2 3
Enter source : 0

Enter destination : 3
3 -> 4 -> 0Smallest distance : 2*/