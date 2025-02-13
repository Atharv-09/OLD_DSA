import java.util.*;

class BFS{	

	private int ver;
	private Map<Integer,List<Integer>> adj;

	BFS(int v){

		ver = v;
		adj = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}
	}


	void addEdge(int src,int dest){

		adj.get(src).add(dest);
		adj.get(dest).add(src);

	}

	void findBFS(int src){

		Queue<Integer> qu = new LinkedList<Integer>();
		boolean[] vis = new boolean[ver]; 

		qu.add(src);
		vis[src] = true;

		while(!qu.isEmpty()){

			int curr = qu.poll();
			System.out.print(curr+" ");
			for(int neighbor:adj.get(curr)){

				if(!vis[neighbor]){
					vis[neighbor] = true;
					qu.add(neighbor);
				}
			}

		}
	}

	void print(){
		for(int i=0;i<ver;i++){
			System.out.print("Adjacency list of "+i +" : ");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print("->"+adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		BFS bfs = new BFS(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			bfs.addEdge(src,dest);
		}

		bfs.print();

		System.out.print("Enter starting vertex : ");
		int strt = sc.nextInt();
		bfs.findBFS(strt);

	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Prac_Graph
$ javac BFS_trav.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Prac_Graph
$ java BFS
Enter edges and vertices count :
11 7
Enter 11 edges
0 1
0 3
1 3
1 2
3 2
3 4
4 2
2 5
1 5
4 6
6 1
Adjacency list of 0 : ->1->3
Adjacency list of 1 : ->0->3->2->5->6
Adjacency list of 2 : ->1->3->4->5
Adjacency list of 3 : ->0->1->2->4
Adjacency list of 4 : ->3->2->6
Adjacency list of 5 : ->2->1
Adjacency list of 6 : ->4->1
Enter starting vertex : 4
4 3 2 6 0 1 5
*/