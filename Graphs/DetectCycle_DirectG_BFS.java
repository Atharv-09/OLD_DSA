import java.util.*;


class CycleDetection_Directed{
	
	private int ver;
	private Map<Integer,List<Integer>> adj;
	CycleDetection_Directed(int v){

		ver = v;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}
	}

	void addEdge(int s,int d){
		adj.get(s).add(d);
	}

	boolean isCyclicConnected(int i,boolean[] vis){

		

	}

	boolean isCyclic(){

		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		CycleDetection_Directed dir = new CycleDetection_Directed(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			dir.addEdge(src,dest);
		}

		if(dir.isCyclic())
				System.out.println("Graph is cyclic");
		else
				System.out.println("Graph is acyclic");
	}
}