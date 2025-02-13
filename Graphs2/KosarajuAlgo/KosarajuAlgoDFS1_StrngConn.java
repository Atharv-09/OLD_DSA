import java.util.*;

// TO PRINT THE STRONGLY CONNECTED COMPONENTS 


class KosarajuDFS{

	private int ver;
	private static Map<Integer,List<Integer>> adj;

	KosarajuDFS(int v){

		ver = v;
		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<>());
		}
	}

	void addEdge(int s,int v){
		adj.get(s).add(v);
	}


	void DFSUtil(Stack<Integer> st,int vertex,boolean[] vis){

		vis[vertex] = true;

		for(int neighbor:adj.get(vertex)){
			if(!vis[neighbor]){
				DFSUtil(st,neighbor,vis);
			}
		}

		st.push(vertex);

	}

	Map<Integer,List<Integer>> getTranspose(){

		Map<Integer,List<Integer>> rev = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<ver;i++){
			rev.put(i,new LinkedList<>());
		}
		for(int v=0;v<ver;v++){

			for(int neigh:adj.get(v)){
				rev.get(neigh).add(v);
			}
		}	
		return rev;
	}

	void reverseGraphDFSUtil(int vertex,boolean[] vis,Map<Integer,List<Integer>> revAdj){

		vis[vertex] = true;
		System.out.print(vertex+" ");

		for(int neigh:revAdj.get(vertex)){
			if(!vis[neigh])
				reverseGraphDFSUtil(neigh,vis,revAdj);
		}
	}

	void StronglyConnComp(){

		boolean vis[] = new boolean[ver];
		Stack<Integer> st = new Stack<>();


		for(int i=0;i<ver;i++)
			vis[i] = false;

        // Fill vertices in stack according to their finishing 

		for(int vertex=0;vertex<ver;vertex++){

			if(!vis[vertex]){
				DFSUtil(st,vertex,vis);
			}
		}

		// now reverse the graph 
		Map<Integer,List<Integer>> revAdj = getTranspose();

		//mark againg vis as false
		//as we have the element in array not pop element and do bfs accordingly 
		for(int i=0;i<ver;i++)
			vis[i] = false;


		while(st.empty() == false){

			int curr = (int)st.pop();
			// print stringly connnected comp 

			if(!vis[curr]){
				reverseGraphDFSUtil(curr,vis,revAdj);
				System.out.println();
			}

		}

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		KosarajuDFS dfs = new KosarajuDFS(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter source & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();

			dfs.addEdge(s,d);

		}

		dfs.StronglyConnComp();
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2/KosarajuAlgo
$ java KosarajuDFS
Enter vertices and edges count : 11 13
Enter 13 edges
Enter source & dest : 0 1
Enter source & dest : 1 2
Enter source & dest : 2 0
Enter source & dest : 1 3
Enter source & dest :
3 4
Enter source & dest : 4 5
Enter source & dest : 5 3
Enter source & dest : 6 5
Enter source & dest : 6 7
Enter source & dest : 7 8
Enter source & dest : 8 9
Enter source & dest : 9 10
Enter source & dest : 9 6
6 9 8 7
10
0 2 1
3 5 4
*/