import java.util.*;


// Used to find the topoplogical sort 

// Time : O(V+E);

// BFS + QUEUE 
class KahnAlgo{
	private int ver;
	private boolean[] vis;
	private Map<Integer,List<Integer>> adj;

	KahnAlgo(int v){

		ver = v;
		vis = new boolean[v];
		adj = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}

	}

	void addEdge(int s,int d){
		adj.get(s).add(d);
	}

	
	
	void KahnAlgoBFS(){

		int inDeg[] = new int[ver];
		Arrays.fill(inDeg,0);

		for(int i=0;i<ver;i++){

			for(int nei:adj.get(i)){
				inDeg[nei]++;
			}
		}

		

		Queue<Integer> qu = new LinkedList<>();
		for(int i=0;i<ver;i++){
			if(inDeg[i] == 0){
				qu.add(i);
			}
		}


		int count =0 ; // to 
		while(!qu.isEmpty()){

			int top = qu.poll();
			System.out.print(top+" ");

			for(int nei:adj.get(top)){

				// decrese ingree of poped element and chk if the indegree is 0 then add to queeie 
				inDeg[nei]--;

				if(inDeg[nei] == 0) qu.add(nei);
			}

			count++;
		}

		if(count!=ver){
			System.out.println("\nThere is cycle \nKahn algo fail here for topological sort\n because it only consider acyclic directed graph");
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		KahnAlgo topo = new KahnAlgo(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter src : ");
			int src = sc.nextInt();
			System.out.print("Enter dest : ");	
			int dest = sc.nextInt();
			topo.addEdge(src,dest);
		}


		topo.KahnAlgoBFS();
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java KahnAlgo
Enter edges and vertices count :
7 6
Enter 7 edges
Enter src : 5
Enter dest : 3
Enter src : 5
Enter dest : 0
Enter src : 3
Enter dest : 0
Enter src : 3
Enter dest : 2
Enter src : 2
Enter dest : 1
Enter src : 4
Enter dest : 0
Enter src : 4
Enter dest : 1
4 5 3 0 2 1
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java KahnAlgo
Enter edges and vertices count :
4 4
Enter 4 edges
Enter src : 0
Enter dest : 1
Enter src : 1
Enter dest : 2
Enter src : 2
Enter dest : 3
Enter src : 3
Enter dest : 1
0 There is cycle
Kahn algo fail here for topological sort
 because it only consider acyclic directed graph
*/