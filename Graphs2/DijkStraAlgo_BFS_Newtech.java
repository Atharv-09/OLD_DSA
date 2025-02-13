import java.util.*;


 // TIME : O(ElogV);

// BFS 
// Priority Queue 
// Gives weight upto 
// gives 

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

class Pair implements Comparable<Pair>{

	int curr;
	String pathSoFar;
	int weightSoFar;

	Pair(int curr,String pathSoFar,int weightSoFar){

		this.curr = curr;
		this.pathSoFar = pathSoFar;
		this.weightSoFar = weightSoFar;
	}

	public int compareTo(Pair obj){
		return this.weightSoFar-obj.weightSoFar;
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

	void addEdge(int s,int d,int w){
		adj.get(s).add(new Edge(s,d,w));
		adj.get(d).add(new Edge(d,s,w));
	}

	void DijkStraAlgo(int startVertex,int endVertex){

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0,startVertex+"",0));

		boolean vis[] = new boolean[ver];
		int shortestWeight =0 ;


		System.out.print(startVertex);
		Pair removedVertex = null;

		while(pq.size()>0){

			removedVertex = pq.remove();

			// we we marked already then dont mark
			if(vis[removedVertex.curr] == true) continue; 

			vis[removedVertex.curr] = true;

	
			// if(removedVertex.curr!=0)
			// 	System.out.print(" -> " + removedVertex.curr);
			
			// TO FIND THE SHORTES PATH AND DIST BETN @ END 

			// if we reached to end vertex we wanr 
			// if(removedVertex.curr == endVertex) break; 


			// to get the path vertex at every node 	
			System.out.println(removedVertex.curr + " via " + removedVertex.pathSoFar + " @ " + removedVertex.weightSoFar);
		
			// shortestWeight+=removedVertex.weightSoFar;


			for(Edge e : adj.get(removedVertex.curr)){

				if(!vis[e.des]){
					pq.add(new Pair(e.des,removedVertex.pathSoFar+e.des,removedVertex.weightSoFar+e.wei));						
				}

			}

		}
		// for calculating the total minimum path weight 
		System.out.println("\n Total Minimum weight : " + removedVertex.weightSoFar);
		System.out.println("Path is : " + removedVertex.pathSoFar);


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

		System.out.print("Enter startVertex : ");
		int sV = sc.nextInt();

		System.out.print("Enter endVertex : ");
		int eV = sc.nextInt();

		g.DijkStraAlgo(sV,eV);
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Graph
Enter vertices and edges count : 4 5
Enter 5 edges
Enter source & dest : 0 1
Enter weight : 4
Enter source & dest : 1 2
Enter weight : 2
Enter source & dest : 0 2
Enter weight : 1
Enter source & dest : 1 3
Enter weight : 4
Enter source & dest : 3 2
Enter weight : 5
Enter startVertex : 0
Enter endVertex :
1
0 -> 2 -> 1
 Total minimum weight : 3
Path is : 021

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Graph
Enter vertices and edges count : 4 5
Enter 5 edges
Enter source & dest : 0 1
Enter weight : 4
Enter source & dest : 1 2
Enter weight : 2
Enter source & dest : 0 2
Enter weight : 1
Enter source & dest : 1 3
Enter weight : 4
Enter source & dest : 3 2
Enter weight : 5
Enter startVertex : 0
Enter endVertex : 3
0 -> 2 -> 1 -> 3
 Total minimum weight : 6
Path is : 023
*/









/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Graph
Enter vertices and edges count : 7 8
Enter 8 edges
Enter source & dest : 0 1
Enter weight : 10
Enter source & dest : 1 2
Enter weight : 10
Enter source & dest : 0 3
Enter weight : 40
Enter source & dest : 3 2
Enter weight : 10
Enter source & dest : 3 4
Enter weight : 2
Enter source & dest : 4 5
Enter weight : 3
Enter source & dest : 4 6
Enter weight : 8
Enter source & dest : 5 6
Enter weight : 3
Enter startVertex : 0
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
3 via 0123 @ 30
4 via 01234 @ 32
5 via 012345 @ 35
6 via 0123456 @ 38

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Graph
Enter vertices and edges count : 7 8
Enter 8 edges
Enter source & dest : 0 1
Enter weight : 10
Enter source & dest : 1 2
Enter weight : 10
Enter source & dest : 0 3
Enter weight : 40
Enter source & dest : 3 2
Enter weight : 10
Enter source & dest : 3 4
Enter weight : 2
Enter source & dest : 4 5
Enter weight : 3
Enter source & dest : 4 6
Enter weight : 8
Enter source & dest : 5 6
Enter weight : 3
Enter startVertex : 2
0 via 2 @ 0
1 via 21 @ 10
2 via 212 @ 20
3 via 2123 @ 30
4 via 21234 @ 32
5 via 212345 @ 35
6 via 2123456 @ 38
/*
private int ver;
	private Map<Integer,List<Integer>> adj;

    Solution(int v){
        ver = v;
        adj = new HashMap<Integer,List<Integer>>();

        for(int i=1;i<=v;i++){
            adj.put(i,new LinkedList<Integer>());
        }
    }

    void addEdge(int s,int e){
        adj.get(s).add(e);
        adj.get(e).add(s);
    }

    void findMinTime(int start,int end){

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cities,roads,timeTraf,timeDis;

        cities = sc.nextInt();
        roads = sc.nextInt();
        timeTraf = sc.nextInt();
        timeDis = sc.nextInt();

        Solution obj = new Solution(roads);

        for(int i=0;i<roads,i++){
            int r1 = sc.nextInt();
            int r2 = sc.nextInt();

            obj.addEdge(r1,r2);
            obj.addEdge(r2,r1);

        }

        obj.findMinTime(1,cities);
         
    }
*/