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


	}
}