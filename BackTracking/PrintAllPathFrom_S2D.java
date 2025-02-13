import java.util.*;

class DirectedGraph{

	private int ver;
	private Map<Integer,List<Integer>> adj;

	// private ArrayList<Integer>[] adj;

	 @SuppressWarnings("unchecked")	
	DirectedGraph(int ver){
		this.ver = ver;
		
		adj = new HashMap<Integer,List<Integer>>();
		// adj = new ArrayList[ver];

		for(int i=0;i<ver;i++){
			adj.put(i,new LinkedList<Integer>());
			// adj[i] = new ArrayList<>();	
		}
	}

	void addEdge(int s,int d){
		adj.get(s).add(d);
		// adj[s].add(d);
	}

	void printAllPathsUtil(Integer s,Integer d,boolean[] vis,List<Integer> ans){

		//to check that our src reached at dest we used wrapper class 
		if(s.equals(d)){
			System.out.println(ans);
			return;
		}
		vis[s] = true;

		for(Integer neigh : adj.get(s)){

			if(!vis[neigh]){

					ans.add(neigh);
					printAllPathsUtil(neigh,d,vis,ans);
					ans.remove(neigh); // BACKTRACK 
			}
		}
		vis[s] = false; 
	}
	void printAllPaths(int s,int d){

		boolean vis[] = new boolean[ver];
		ArrayList<Integer> ans = new ArrayList<>();

		ans.add(s);

		printAllPathsUtil(s,d,vis,ans);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		DirectedGraph dg = new DirectedGraph(v);

		System.out.println("Enter eedges : ");
		for(int i=0;i<e;i++){
			System.out.print("Enter u and v : ");
			int u = sc.nextInt();
			int v1 = sc.nextInt();
			dg.addEdge(u,v1);
		}	

		System.out.print("Enter source : ");
		int s = sc.nextInt();
		System.out.print("Enter dest : ");
		int d = sc.nextInt();
		dg.printAllPaths(s,d);

	}
}
/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java DirectedGraph
Enter vertices and edges count : 4 6
Enter eedges :
Enter u and v : 0 2
Enter u and v : 2 0
Enter u and v : 0 1
Enter u and v : 0 3
Enter u and v : 1 3
Enter u and v : 2 1
Enter source : 2
Enter dest : 1
[2, 0, 1]
[2, 1]



hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java DirectedGraph
Enter vertices and edges count : 4 6
Enter eedges :
Enter u and v : 0 2
Enter u and v : 2 0
Enter u and v : 0 1
Enter u and v : 1 3
Enter u and v : 2 1
Enter u and v : 0 3
Enter source : 2
Enter dest : 3
[2, 0, 1, 3]
[2, 0, 3]
[2, 1, 3]


*/
