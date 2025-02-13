	import java.util.*;

	
class DFS{

	private int ver ;
	private Map<Integer,List<Integer>> adj;

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

	void print(){

		for(int i=0;i<ver;i++){
			System.out.print("Adjacency matrix of "+i +" : ");
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print("->"+adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	void DFSUntil(int s,boolean vis[]){

		vis[s] = true;
		System.out.print(s+" ");

		for(int child:adj.get(s)){
			if(!vis[child]){
				DFSUntil(child,vis);
			}
		}
	}
	void findDFSUsingRecur(int src){

		boolean vis[] = new boolean[ver];

		// calling recur helper func 
		DFSUntil(src,vis);
	}
	void findDFSUsingStack(int src){

		Stack<Integer> st =new Stack<Integer>();
		boolean vis[] = new boolean[ver];

		vis[src] = true;
		st.push(src);

		while(!st.isEmpty()){

			int curr = st.pop();
			System.out.print(curr+" ");
				

				for(int neigh : adj.get(curr)){
					if(!vis[neigh]){
						st.push(neigh);
						vis[neigh] =true;
					}
				}
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

		dfs.print();
		System.out.print("\nEnter source vertex : ");
		int src = sc.nextInt();

		// dfs.findDFSUsingStack(src);
		dfs.findDFSUsingRecur(src);
	}
}
/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Prac_Graph
$ java DFS
Enter edges and vertices count :
10 9
Enter 10 edges
0 1
1 7
7 2
2 5
2 3
3 0
5 6
3 4
0 8
8 4
Enter source vertex : 0
0 8 4 3 2 5 6 7 1
http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/11-Graph/FIGS/Graphs/graph20.gif
*/

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Prac_Graph
$ java DFS
Enter edges and vertices count :
11 7
Enter 11 edges
0 1
0 3
3 4
3 1
4 2
2 5
6 1
2 1
4 6
1 5
3 2
Adjacency matrix of 0 : ->1->3
Adjacency matrix of 1 : ->0->3->6->2->5
Adjacency matrix of 2 : ->4->5->1->3
Adjacency matrix of 3 : ->0->4->1->2
Adjacency matrix of 4 : ->3->2->6
Adjacency matrix of 5 : ->2->1
Adjacency matrix of 6 : ->1->4

Enter source vertex : 5
5 1 6 4 3 0 2

///////////////SAME uSINF RECURSION OUTPUT

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Prac_Graph
$ java DFS
Enter edges and vertices count :
11 7
Enter 11 edges
0 1
0 3
3 1
1 2
2 3
3 4
4 2
2 5
1 6
4 6
3 1
Adjacency matrix of 0 : ->1->3
Adjacency matrix of 1 : ->0->3->2->6->3
Adjacency matrix of 2 : ->1->3->4->5
Adjacency matrix of 3 : ->0->1->2->4->1
Adjacency matrix of 4 : ->3->2->6
Adjacency matrix of 5 : ->2
Adjacency matrix of 6 : ->1->4

Enter source vertex : 1
1 0 3 2 4 6 5


*/