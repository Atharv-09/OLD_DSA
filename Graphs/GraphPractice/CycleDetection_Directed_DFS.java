import java.util.*;
// NOT COMPLETED 

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

	boolean detect(int c,boolean[] vis,boolean[] recStack){

		if(vis[c]) return true;
		if(recStack[c]) return false;
		
		vis[c] = true;
		recStack[c] = true;

		for(int neighbor : adj.get(c)){
			if(detect(neighbor,vis,recStack)){
				return true;
			}
		}

		recStack[c] = false;
		return false;

	}

	boolean detectCycleDirectedDFS(){

		boolean vis[] = new boolean[V];
		boolean recStack[] = new boolean[V];

		for(int i=0;i<V;i++){
			if(detect(i,vis,recStack)){
				return true;
			}
		}
		return false;


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

		if(g.detectCycleDirectedDFS())
			System.out.println("Cycle is detected");
		else
			System.out.println("Cycle is not there!");


	}
}