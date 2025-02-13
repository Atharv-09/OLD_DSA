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

	boolean detect(int c,boolean[] vis){

		int parent[] = new int[V];
		Arrays.fill(parent,-1);

		vis[c] = true;
		Queue<Integer> qu = new LinkedList<>();
		qu.add(c);

		while(!qu.isEmpty()){

			int curr = qu.poll();

			for(int nei:adj.get(curr)){
				if(!vis[nei]){
					qu.add(nei);
					vis[nei] = true;
					parent[nei] = curr;
				}else if(parent[curr]!=nei){
					return true;
				}
			}
		}
		return false;

	}
	boolean detectCycleUnDirectedBFS(){

		boolean vis[] = new boolean[V];

		// we will take al vertex coz if sometime happen that the 

		// 0	3	4\	
		// |	|	| \	
		// |	|	|  \
		// |	|	|	\
		// 1 	2	5____6
		// if we get this type of graph and say is it cyclic or not then ans is yes
		// so instead of only going from source vertex to its DFS
		// we have to go through all the vertex 
		for(int i=0;i<V;i++){

			if(!vis[i]){
				if(detect(i,vis))
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

		if(g.detectCycleUnDirectedBFS())
			System.out.println("Cycle is detected");
		else
			System.out.println("Cycle is not there!");


	}
}