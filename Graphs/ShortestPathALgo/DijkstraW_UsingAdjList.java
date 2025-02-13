// time : )


import java.util.*;

class Edge{

	int currNode,distFromNode;

	Edge(int dest,int distFromNode){
		this.currNode = currNode;
		this.distFromNode = distFromNode;
	}
}
class Graph{

	private final int V;
	private final Map<Integer,List<Edge>> adj;
	private boolean[] vis;
	private int dist[];

	Graph(int V){
		this.V = V;

		adj = new HashMap<Integer,List<Edge>>();
		vis = new boolean[V];
		dist = new int[V];


		for(int i=0;i<V;i++){
			adj.put(i,new LinkedList<Edge>());
			dist[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}

	}

	void addEdge(int s,int d,int wei){
		adj.get(s).add(new Edge(d,wei));
		adj.get(d).add(new Edge(s,wei));
	}

	void print(){

		for(int i=0;i<V;i++){
			System.out.print("Adjacency list of "+i);

			for(int j=0;j<adj.get(i).size();j++){
				System.out.print(" 	->	 " + "[dest: " +  adj.get(i).get(j).currNode + " wei: " + adj.get(i).get(j).distFromNode + "]");
			}
			System.out.println();
		}
	}

	int DijkStraMinDistance(int src,int des){

		if(src==des) return 0;

		// e1-e2 = means we get MINHEAP
		// e2-e1 = means we get MAXHEAP 
		PriorityQueue<Edge> MinHeap = new PriorityQueue<>((e1,e2) -> e1.distFromNode-e2.distFromNode) ; //comparator 

		dist[src] = 0;
		MinHeap.add(new Edge(0,0));
		vis[src] = true;


		while(!MinHeap.isEmpty()){

			int curr = MinHeap.poll().currNode;

			if(vis[curr]) continue;

			vis[curr] = true;
			for(Edge neighbor:adj.get(curr)){

				int dis = neighbor.distFromNode;
				int childNode = neighbor.currNode;

				if(!vis[childNode] && (dist[curr]+dis < dist[childNode])){
					dist[childNode] = dist[curr] + dis;
					MinHeap.add(neighbor);
					neighbor.distFromNode = dist[curr] + dis;
				}
			}

		}
		return dist[des];

	}	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		Graph g = new Graph(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter src & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.print("Enter weight : ");
			int wei = sc.nextInt();
			g.addEdge(s,d,wei);
		}
			
		g.print();



		System.out.print("Enter source : " );
		int s1 = sc.nextInt();
		System.out.print("\nEnter desti : ");
		int d1 = sc.nextInt();

		System.out.println("Minimum distance betn " + s1 +" & " + d1 + " : "+ g.DijkStraMinDistance(s1,d1));
	}
}


/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/ShortestPathALgo
$ java Graph
Enter vertices and edges count : 4 4
Enter 4 edges
Enter src & dest : 0 1
Enter weight : 4
Enter src & dest : 1 2
Enter weight : 5
Enter src & dest : 2 3
Enter weight : 6
Enter src & dest : 1 3
Enter weight : 8
Adjacency list of 0     ->       [dest: 1 wei: 4]
Adjacency list of 1     ->       [dest: 2 wei: 5]       ->       [dest: 3 wei: 8]
Adjacency list of 2     ->       [dest: 3 wei: 6]
Adjacency list of 3

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/ShortestPathALgo
$ javac DijkstraW_UsingAdjList.java
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs/ShortestPathALgo
$ java Graph
Enter vertices and edges count : 4 4
Enter 4 edges
Enter src & dest : 0 1
Enter weight : 4
Enter src & dest : 1 2
Enter weight : 5
Enter src & dest : 2 3
Enter weight : 6
Enter src & dest : 1 3
Enter weight : 8
Adjacency list of 0     ->       [dest: 1 wei: 4]
Adjacency list of 1     ->       [dest: 0 wei: 4]       ->       [dest: 2 wei: 5]       ->       [dest: 3 wei: 8]
Adjacency list of 2     ->       [dest: 1 wei: 5]       ->       [dest: 3 wei: 6]
Adjacency list of 3     ->       [dest: 2 wei: 6]       ->       [dest: 1 wei: 8]
*/