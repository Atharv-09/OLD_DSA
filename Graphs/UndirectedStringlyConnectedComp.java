	import java.util.*;

//O(V + E) 
class DFS{

	private int ver ;
	private static Map<Integer,List<Integer>> adj;

	DFS(int v){
		ver = v;

		adj = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}
	}

	void addEdge(int src,int des){

		adj.get(src).add(des);
		adj.get(des).add(src);

	}

	static void dfsUtil(boolean[] vis,int src){

		vis[src] = true;
		System.out.print(src+" - ");

		for(int i:adj.get(src)){
			if(!vis[i])
				dfsUtil(vis,i);
		}

		System.out.println();

	}
	static void findComp(int v){

		boolean[] vis = new boolean[v];

		for(int i=0;i<v;i++){
			if(!vis[i])
				dfsUtil(vis,i);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		DFS dfs = new DFS(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			dfs.addEdge(src,dest);
		}

		findComp(v);
	}
}