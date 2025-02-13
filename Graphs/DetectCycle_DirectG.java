// USING DFS 

//TIME : O(v+e)
//SPACE :O(v)
import java.util.*;

class CycleDetection_Directed{

	private int ver;
	private Map<Integer,List<Integer>> adj;

	CycleDetection_Directed(int v){

		ver = v;
		adj = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<v;i++)
			adj.put(i,new LinkedList<Integer>());
	}


	void addEdge(int src,int des){

		adj.get(src).add(des);
		// adj.get(des).add(src);

	}

	boolean isCyclicUntil(int cur,boolean[] vis,boolean[] recStack){

		// if we reached the node which is already reached then we simply return true
		// if we have not reached to the node that means the cycle not exists
		// so we make that node as false 
		// so as we markes as visited so if vis[true] thrn return false;
		
		if(recStack[cur]) return true;
		if(vis[cur]) return false;

		vis[cur] = true;
		recStack[cur] = true;

		for(int neighbor:adj.get(cur)){

			if(isCyclicUntil(neighbor,vis,recStack))
				return true;
		}

		recStack[cur] = false;
		return false;

	}

	boolean isCyclic(){

		boolean vis[] = new boolean[ver];
		boolean recStack[] = new boolean[ver];
		
		for(int i=0;i<ver;i++){
			if(isCyclicUntil(i,vis,recStack))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		CycleDetection_Directed dir = new CycleDetection_Directed(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			dir.addEdge(src,dest);
		}


		if(dir.isCyclic()){
			System.out.println("Cycle is detected");
		}
		else{
			System.out.println("There is no cycle !");
		}

	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ java CycleDetection_Directed
Enter edges and vertices count :
4 4
Enter 4 edges
0 1
0 2
1 2
2 3
There is no cycle !

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ java CycleDetection_Directed
Enter edges and vertices count :
4 4
Enter 4 edges
0 1
1 2
2 3
2 0
Cycle is detected
*/