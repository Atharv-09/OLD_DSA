import java.util.*;

class Edge{
	int s,d,w;

	Edge(int s,int d,int w){
		this.s = s;
		this.d = d;
		this.w = w;
	}
}

class Pair implements Comparable<Pair>{

	int currVer;
	int parVer;
	int wei;

	Pair(int currVer,int parVer,int wei){
		this.currVer = currVer;
		this.parVer = parVer;
		this.wei = wei;
	}

	public int compareTo(Pair p){
		return this.wei-p.wei;
	}
}
class Graph{

	static int V;
	static Map<Integer,List<Edge>> adj;

	Graph(int v){
		adj = new HashMap<Integer,List<Edge>>();
		V = v;
		for(int i=0;i<V;i++){
			adj.put(i,new LinkedList<Edge>());
		}
	}
	void addEdge(int s,int d,int w){
		
		adj.get(s).add(new Edge(s,d,w));
		adj.get(d).add(new Edge(d,s,w));

	}

	static void primsAlgo(){

		boolean vis[] = new boolean[V];

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0,-1,0));

		while(pq.size()>0){


			Pair rem = pq.remove();

			if(vis[rem.currVer])
				continue;
			vis[rem.currVer] = true;

			if(rem.currVer!=-1)
				System.out.println(rem.parVer + " -> " + rem.currVer  + " wei = " + rem.wei);

			for(Edge nei:adj.get(rem.currVer)){

				if(!vis[nei.d]){
					pq.add(new Pair(nei.d,rem.currVer,nei.w));
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
		primsAlgo();
	}
}