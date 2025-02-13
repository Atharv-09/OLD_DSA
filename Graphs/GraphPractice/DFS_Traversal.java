import java.util.*;
class Graph{

	private final int V;
	private final Map<Integer,List<Integer>> adj;


	Graph(int V){
		this.V = V;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<V;i++){
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

	void findDFS(int src,boolean[] vis){

		vis[src] = true;
		System.out.print(src+" ");

		for(int neighbor:adj.get(src)){
			if(!vis[neighbor]){
				findDFS(neighbor,vis);
			}
		}

	}
	void dfsRecur(int src){

		boolean vis[] = new boolean[V];

		// for(int i=0;i<V;i++){
		findDFS(src,vis);
		// }
	}
	void dfs(int src){
		// using stack

		Stack<Integer> st = new Stack<Integer>(); 
		boolean vis[] = new boolean[V];

		st.push(src);
		vis[src] = true;

		while(!st.isEmpty()){

			int curr = st.pop();

			System.out.print(curr+" ");

			for(int neighbor : adj.get(curr)){

				if(!vis[neighbor]){
					st.push(neighbor);
					vis[neighbor] = true;
				}
			}

		}	


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

		System.out.print("Enter source to traverse : ");
		int s = sc.nextInt();
		g.dfs(s);

		// g.dfsRecur(s);
	}
}
//DIFF DIFF ANS 


/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/GraphPractice
$ java Graph
Enter vertices and edges count : 5 6
Enter 6 edges
0 1
1 2
1 3
3 4
2 4
0 3
Adjacency list of 0 -> 1 -> 3
Adjacency list of 1 -> 0 -> 2 -> 3
Adjacency list of 2 -> 1 -> 4
Adjacency list of 3 -> 1 -> 4 -> 0
Adjacency list of 4 -> 3 -> 2
Enter source to traverse : 0
0 1 2 4 3
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/GraphPractice
$ javac DFS_Traversal.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/GraphPractice
$ java Graph
Enter vertices and edges count : 5 6
Enter 6 edges
0 1
1 2
1 3
3 4
2 4
0 3
Adjacency list of 0 -> 1 -> 3
Adjacency list of 1 -> 0 -> 2 -> 3
Adjacency list of 2 -> 1 -> 4
Adjacency list of 3 -> 1 -> 4 -> 0
Adjacency list of 4 -> 3 -> 2
Enter source to traverse : 0
0 3 4 2 1
*/