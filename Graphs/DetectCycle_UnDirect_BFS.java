import java.util.*;


class CycleDetection_UnDirect{
	
	private int ver;
	private Map<Integer,List<Integer>> adj;
	CycleDetection_UnDirect(int v){

		ver = v;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}
	}

	void addEdge(int s,int d){
		adj.get(s).add(d);
		adj.get(d).add(s);
	}

	boolean isCyclicConnected(int i,boolean[] vis){

		int parent[] = new int[ver];
		Arrays.fill(parent,-1);

		Queue<Integer> qu = new LinkedList<>();
		vis[i]  = true;
		qu.add(i);
 
		while (!qu.isEmpty()) {
			
			int curr = qu.poll();
			// now get alll the adj element of vertex curr 

			for(int neighbor: adj.get(curr)){
				if(!vis[neighbor]){
					vis[neighbor] = true;
					qu.add(neighbor);
					parent[neighbor] = curr;
				}else if(parent[curr] != neighbor){
					return true;
				}
			}
		}
		return false;

	}

	boolean isCyclic(){

		boolean vis[] = new boolean[ver];

		for(int i=0;i<ver;i++){
			if(!vis[i])
				if(isCyclicConnected(i,vis))
					return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		CycleDetection_UnDirect unDir = new CycleDetection_UnDirect(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			unDir.addEdge(src,dest);
		}

		if(unDir.isCyclic())
				System.out.println("Graph is cyclic");
		else
				System.out.println("Graph is acyclic");
	}
}