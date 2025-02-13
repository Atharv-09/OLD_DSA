// this algo is used to get the STRONGLY CONNECTED COMPONENTS 


//TINE : O(V+E);
//SPACE : O(V);

import java.util.*;

class KosarajuDFS{

	private int ver;
	private static Map<Integer,List<Integer>> adj;
	

	KosarajuDFS(int v){

		ver = v;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}
	}

	void addEdge(int s,int v){
		adj.get(s).add(v);
	}

	// we make DFS on graph from below function 
	void DFSUtil(Deque<Integer> st,int vertex,boolean[] vis){

		vis[vertex] = true;

		for(int neigh:adj.get(vertex)){
			if(!vis[neigh]){
				DFSUtil(st,neigh,vis);
			}
		}
		st.offerFirst(vertex);
		

	}
	
	void reverseGraphDFSUtil(int vertex,List<Integer> res,boolean vis[]){

		vis[vertex] = true;
		// res.add(vertex);
		// System.out.println("counter");
		System.out.print(vertex+"->");
// 
		for(int neigh:adj.get(vertex)){
			if(!vis[neigh]){
				reverseGraphDFSUtil(neigh,res,vis);
			}
		}

	}

	void StronglyConnComp(){

		Deque<Integer> st = new ArrayDeque<>();

		// Stack<Integer> st = new Stack<>();
		boolean vis[] = new boolean[ver];

		for(int vertex=0;vertex<ver;vertex++){

			if(!vis[vertex]){
				DFSUtil(st,vertex,vis);
			}
		}

		while(!st.isEmpty())
			System.out.println(st.poll());

		// we get here reversed graph
		Map<Integer,List<Integer>> revAdj = reverseGraph();

		//make the visited as false 
		for (int i = 0; i < ver; i++) 
            vis[i] = false; 

		List<List<Integer>> ans = new ArrayList<>();
		

		while(!st.isEmpty()){

			int curr = st.poll();
			List<Integer> res = new ArrayList<>();
			if(vis[curr]==true) continue;

			reverseGraphDFSUtil(curr,res,vis);
			// ans.add(res);
			System.out.println();

			
		}
		// System.out.println("count = " +count);
		// printComponents(ans);

	}

	void printComponents(List<List<Integer>> ans){

		for(int i=0;i<ans.size();i++){
			for(int j=0;j<ans.get(i).size();j++){
				System.out.print(ans.get(i).get(j));
			}
			System.out.println();
		}
	}

	Map<Integer,List<Integer>> reverseGraph(){

		Map<Integer,List<Integer>> revGraph = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<ver;i++){
			revGraph.put(i,new LinkedList<>());
		}

		for(int i=0;i<ver;i++){
			for(int neigh:adj.get(i)){
				revGraph.get(neigh).add(i);
			}
		}



		return revGraph;

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
			// for(int i=0;i<v;i++){
			// System.out.print(i+"->");
			// for(int nei:adj.get(i)){
			// 	System.out.print(nei+",");
			// }
			// System.out.println();
			// }
		dfs.StronglyConnComp();
	}
}

