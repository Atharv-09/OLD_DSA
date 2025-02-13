import java.util.*;
// BFS 
// TIME : O(ElogV)

class Pair implements Comparable<Pair>{

	int currVer;
	int parentVer;
	int weight;

	Pair(int currVer,int parentVer,int weight){
		this.currVer = currVer;
		this.parentVer = parentVer;
		this.weight = weight;
	}

	// for minHeap
	public int compareTo(Pair p){
		return this.weight-p.weight;
	}
}

class Edge{

	int src;
	int des;
	int wei;

	Edge(int src,int des,int wei){
		this.src = src;
		this.des = des;
		this.wei = wei;
	}
}

class Graph{

	private int ver;
	private Map<Integer,List<Edge>> adj;

	Graph(int v){

		ver = v;

		adj = new HashMap<Integer,List<Edge>>();
		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Edge>());
		}
	}

	void addEdge(int s,int d,int wei){
		adj.get(s).add(new Edge(s,d,wei));
		adj.get(d).add(new Edge(d,s,wei));
	}

	void primsAlgo(){

		boolean vis[] = new boolean[ver];

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0,-1,0));
		/// remove -> mark -> print -> add neighbor 
		
		while(pq.size()>0){

			Pair rem = pq.remove();
			
			// if we not visited then mark that 
			if(vis[rem.currVer] == true){
				continue;	
			}

			vis[rem.currVer] = true;

			if(rem.parentVer!=-1)
				System.out.println(rem.parentVer + " -> " + rem.currVer + " wei = " + rem.weight);

			for(Edge e:adj.get(rem.currVer)){

				if(!vis[e.des]){
					pq.add(new Pair(e.des,rem.currVer,e.wei));
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
			System.out.print("Enter source & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.print("Enter weight : ");
			int wei = sc.nextInt();

			g.addEdge(s,d,wei);
		}

		g.primsAlgo();
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ javac PrimsAlgo_BFS_Newtech.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Graph
Enter vertices and edges count : 7 8
Enter 8 edges
Enter source & dest : 0 1
Enter weight : 10
Enter source & dest : 0 3
Enter weight : 40
Enter source & dest : 3 2
Enter weight : 10
Enter source & dest : 1 2
Enter weight : 10
Enter source & dest : 3 4
Enter weight : 2
Enter source & dest : 4 6
Enter weight : 1
Enter source & dest : 4 5
Enter weight : 3
Enter source & dest : 5 6
Enter weight : 3
0 -> 1 wei = 10
1 -> 2 wei = 10
2 -> 3 wei = 10
3 -> 4 wei = 2
4 -> 6 wei = 1
4 -> 5 wei = 3

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Graph
Enter vertices and edges count : 3 3
Enter 3 edges
Enter source & dest : 0 1
Enter weight : 5
Enter source & dest : 0 2
Enter weight : 1
Enter source & dest : 2 1
Enter weight : 3
0 -> 2 wei = 1
2 -> 1 wei = 3
*/