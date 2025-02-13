import java.util.*;

// DFS + STACK 


//Time Complexity: O(V+E).
//Auxiliary space: O(V). 
/*Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs.
 In computer science, applications of this type arise in instruction scheduling, 
 ordering of formula cell evaluation when recomputing formula values in spreadsheets, logic synthesis, 
determining the order of compilation tasks to perform in make files, data serialization, and resolving symbol dependencies in linkers*/
class TopologicalSort{

	private int ver;
	private boolean[] vis;
	private Map<Integer,List<Integer>> adj;

	TopologicalSort(int v){

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

	Stack<Integer> st = new Stack<>();


	void topoSortDFS(int i){

		vis[i] = true;
		
		for(int neigh : adj.get(i)){

			if(!vis[neigh]){
				topoSortDFS(neigh);
			}
		}	

		st.push(i);

	}


	void topoSort(){

		for(int i=0;i<ver;i++){
			if(!vis[i]){
				topoSortDFS(i);
			}
		}

		while(st.size()>0){
			System.out.print(st.pop()+ " ");
		}
	}



	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		TopologicalSort topo = new TopologicalSort(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter src : ");
			int src = sc.nextInt();
			System.out.print("Enter dest : ");	
			int dest = sc.nextInt();
			topo.addEdge(src,dest);
		}


		topo.topoSort();
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java TopologicalSort
Enter edges and vertices count :
8 7
Enter 8 edges
Enter src : 0
Enter dest : 1
Enter src : 1
Enter dest : 2
Enter src : 2
Enter dest : 3
Enter src : 0
Enter dest : 3
Enter src : 4
Enter dest : 3
Enter src : 4
Enter dest : 5
Enter src : 5
Enter dest : 6
Enter src : 4
Enter dest : 6
4 5 6 0 1 2 3


hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java TopologicalSort
Enter edges and vertices count :
8 8
Enter 8 edges
Enter src : 0
Enter dest : 2
Enter src : 1
Enter dest : 2
Enter src : 2
Enter dest : 3
Enter src : 3
Enter dest : 7
Enter src : 3
Enter dest : 5
Enter src : 5
Enter dest : 6
Enter src : 4
Enter dest : 5
Enter src : 1
Enter dest : 4
1 4 0 2 3 5 6 7

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java TopologicalSort
Enter edges and vertices count :
6 6
Enter 6 edges
Enter src : 5
Enter dest : 2
Enter src : 2
Enter dest : 3
Enter src : 3
Enter dest : 1
Enter src : 4
Enter dest : 1
Enter src : 4
Enter dest : 0
Enter src : 5
Enter dest : 0
5 4 2 3 1 0


*/