import java.util.*;
class Graph{

	private final int V;
	private final Map<Integer,List<Integer>> adj;


	Graph(int V){
		this.V = V;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<V;i++){
			adj.put(i,new LinkedList<Integer>());
		}

	}

	void addEdge(int s,int d){
		adj.get(s).add(d);
		adj.get(d).add(s);
	}

	void print(){

		for(int i=0;i<V;i++){
			System.out.print("Adjacency list of "+i);

			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	void BFS(int src){
		// using queue 

		boolean vis[] = new boolean[V];
		Queue<Integer> qu = new LinkedList<>();

		qu.add(src);
		vis[src] = true;

		while(!qu.isEmpty()){

			int curr = qu.poll();
			System.out.print(curr+" ");

			for(int neighbor: adj.get(curr)){
				if(!vis[neighbor]){
					qu.add(neighbor);
					vis[neighbor] = true;
				}
			}
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

			g.addEdge(s,d);
		}
			
		g.print();

		System.out.print("Enter source to traverse : ");
		int s = sc.nextInt();
		g.BFS(s);
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/GraphPractice
$ java Graph
Enter vertices and edges count : 5 6
Enter 6 edges
0 1
0 3
2 4
3 4
1 2
1 3
Adjacency list of 0 -> 1 -> 3
Adjacency list of 1 -> 0 -> 2 -> 3
Adjacency list of 2 -> 4 -> 1
Adjacency list of 3 -> 0 -> 4 -> 1
Adjacency list of 4 -> 2 -> 3
Enter source to traverse : 1
1 0 2 3 4
*/