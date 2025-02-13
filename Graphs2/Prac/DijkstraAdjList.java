import java.util.*;

class Edge{

	int s,d,w;

	Edge(int s,int d,int w){
		this.s = s;
		this.d = d;
		this.w = w;
	}
}



class Pair implements Comparable<Pair> {

	int currVer;
	String psf;
	int wsf;

	Pair(int currVer,String psf,int wsf){
		this.currVer = currVer;
		this.psf = psf;
		this.wsf = wsf;
	}

	public int compareTo(Pair p){
		return this.wsf-p.wsf;
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

	void dijkstra(){

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean vis[] = new boolean[V];

		pq.add(new Pair(0,"",0));
			
		Pair p = null;

		String pathSoFar = "0";
		while(pq.size() >0){

			p = pq.remove();

			if(vis[p.currVer]==true)
				continue;

			vis[p.currVer] = true;
			
			// pathSoFar += e.d;

			System.out.println(p.currVer + " " + "PathSoFar : " + p.psf + " weightSofar : "+ p.wsf);

			for(Edge e : adj.get(p.currVer)){
				if(!vis[e.d]){
					pq.add(new Pair(e.d,p.psf+e.d,e.w+p.wsf));
				}
			}

		}	

		System.out.println("----ANS----");

		System.out.println(pathSoFar);
		System.out.println(p.psf);

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
		g.dijkstra();
	}
}