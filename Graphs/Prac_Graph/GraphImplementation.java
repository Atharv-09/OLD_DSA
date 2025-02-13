import java.util.*;

class Graph{

	Map<Integer,List<Integer>> adj;

	Graph(int v){

		adj = new HashMap<Integer,List<Integer>>();

		for(int i=1;i<=v;i++){
			adj.put(i,new LinkedList<Integer>()); 
		}
	}

	void addEdge(int src,int dest){

		// List<Integer> sL = adj.get(src);
		// sL.add(dest);
		// OR 

		adj.get(src).add(dest);
		adj.get(dest).add(src);
	}

	void print(int v){

		for(int i=1;i<=v;i++){
			System.out.print("Adjacency list of vertex "+ i + " : ");
			List<Integer> edgeL = adj.get(i);
			for(int j=0;j<edgeL.size();j++){
				System.out.print(" -> "+ edgeL.get(j));
			}
			System.out.println();	
		}
		 
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int V = sc.nextInt();
		int e = sc.nextInt();

		Graph g = new Graph(V);
		
		System.out.print("Enter " +e + " edges ");

		for(int i=0;i<e;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();

			g.addEdge(u,v);
		}

		g.print(V);


	}
}