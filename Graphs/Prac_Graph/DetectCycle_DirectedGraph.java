class DirectedGraph{

	private int ver;
	private Map<Integer,List<Integer>> adj;
	DirectedGraph(int v){

		ver = v;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<v;i++)
			adj.put(i,new LinkedList<Integer>());
	}

	void addEdge(int src,int des){
		adj.get(src).add(des);
	}
	
	boolean vis[] = new boolean[ver];
	Stack<Integer> st = new Stack<Integer>();
	
	boolean makesCycle(int src){

		st.p(src);
		vis[src] = true;

		for(int neigh:adj.get(src)){
			if(!vis[neigh]){
				st.push(nei);
			}
		}
	}
	boolean isCyclic(){

		for(int i=0;i<ver;i++){
			if(makesCycle(i))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();
			
		DirectedGraph dg = new DirectedGraph(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			dg.addEdge(src,dest);
		}

		if(isCyclic()){
			System.out.println("Graph makes cycle");
		}else{
			System.out.println("Graph not makes cycle");
		}

	}
}