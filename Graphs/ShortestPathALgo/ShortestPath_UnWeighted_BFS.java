// Time Complexity : O(V + E) 
// Auxiliary Space: O(V)

import java.util.*;
class Graph{

	private final int V;
	private final Map<Integer,List<Integer>> adj;


	Graph(int V){
		this.V = V;

		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<V;i++){
			adj.put(i,new LinkedList<Integer>());
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

	boolean BFS(int s,int d,int par[],int dist[]){

		Queue<Integer> qu = new LinkedList<Integer>();
		boolean vis[] = new boolean[V];
		// initialise all with -ve and false values 
		for(int i=0;i<V;i++){
			vis[i] = false;
			par[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}

		// initialise for src value 
		vis[s] = true;
		qu.add(s);
		dist[s] = 0;

		while(!qu.isEmpty()){

			int curr = qu.poll();

			// as we get the curr element take all the adj element of it 
			//and mark the distance as curr element dist + 1
			// adj element  parent as curr element 
			// as we do in level order
			// until the queu is not emoty or its anchestor is not cmomlpted take a loop of its size 
			for(int i=0;i<adj.get(curr).size();i++){

				if(!vis[adj.get(curr).get(i)]){

					qu.add(adj.get(curr).get(i));
					vis[adj.get(curr).get(i)] = true; // mark the adj element as visites 
					par[adj.get(curr).get(i)] = curr; // as the parent of adj eleement of curr is curr itself
					// as the adj element is introduced by curr elemnet 
					dist[adj.get(curr).get(i)] = dist[curr]+1; // as we are forst at src whose dist is 0
					// as we do bFS we are spreading side nodes so its distance increse by 1 
		

					if(adj.get(curr).get(i) == d) // if we reached to destinatio 
						return true;
				}
			}

		}

		return false;	
	}

	void shortestPath_BFS(int src,int dest){

		int par[] = new int[V];
		int dist[] = new int[V];

		// check if the given src and destn are connectes or not 

		if(BFS(src,dest,par,dist) == false){
			System.out.println("Sourse and Destination are not connected");
			return;
		}


		LinkedList<Integer> ans = new LinkedList<>();

		int val = dest;
		ans.add(val);

		while(par[val] != -1){
			
			ans.add(par[val]);
			val = par[val]; // 

		}

		System.out.println("Shortest Path length is : " + dist[dest]);
		System.out.print("Shortest Path : ");
		for(int i=0;i<ans.size();i++){
			System.out.print(ans.get(i)+" ");
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

		System.out.print("Enter source : ");
		int s1 = sc.nextInt();
		System.out.print("Enter dest : ");
		int d1 = sc.nextInt();

		g.shortestPath_BFS(s1,d1);
	}
}
/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ javac ShortestPath_UnD_BFS.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ java Graph
Enter vertices and edges count : 8 10
Enter 10 edges
1 2
1 0
0 3
3 7
3 4
4 6
7 6
4 5
6 5
4 7
Adjacency list of 0 -> 1 -> 3
Adjacency list of 1 -> 2 -> 0
Adjacency list of 2 -> 1
Adjacency list of 3 -> 0 -> 7 -> 4
Adjacency list of 4 -> 3 -> 6 -> 5 -> 7
Adjacency list of 5 -> 4 -> 6
Adjacency list of 6 -> 4 -> 7 -> 5
Adjacency list of 7 -> 3 -> 6 -> 4
Enter source : 0
Enter dest : 6
Shortest Path length is : 3
Shortest Path : 6 7 3 0
*/


/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/ShortestPathALgo
$ java Graph
Enter vertices and edges count : 8 10
Enter 10 edges
1 2
1 0
0 3
3 7
7 4
4 3
4 6
6 5
4 5
7 6
Adjacency list of 0 -> 1 -> 3
Adjacency list of 1 -> 2 -> 0
Adjacency list of 2 -> 1
Adjacency list of 3 -> 0 -> 7 -> 4
Adjacency list of 4 -> 7 -> 3 -> 6 -> 5
Adjacency list of 5 -> 6 -> 4
Adjacency list of 6 -> 4 -> 5 -> 7
Adjacency list of 7 -> 3 -> 4 -> 6
Enter source : 1
Enter dest : 4
Shortest Path length is : 3
Shortest Path : 4 3 0 1
*/