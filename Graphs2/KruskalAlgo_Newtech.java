/******************TIME COMPLEXITY**************************************************/
/*
O(ElogE) or O(ElogV). Sorting of edges takes O(ELogE) time. 
After sorting, we iterate through all edges and apply find-union algorithm. 
The find and union operations can take atmost O(LogV) time. 
So overall complexity is O(ELogE + ELogV) time. 
The value of E can be atmost O(V2), so O(LogV) are O(LogE) same. 
Therefore, overall time complexity is O(ElogE) or O(ElogV)

*/

import java.util.*;

class krusKal{

	class Edge implements Comparable<Edge> {

		int src,dest,wei;

		// Edge(int src,int dest,int wei){
		// 	this.src = src;
		// 	this.dest = dest;
		// 	this.wei = wei;
		// }
		public int compareTo(Edge e){
			return this.wei-e.wei;
		}

		// arrange in ascending order of weight 
	}

	private Map<Integer,Node> map = new HashMap<>();


	class Node{
		int data;
		Node parent;
		int rank;
	}

	int V,E;
	Edge edge[];

	krusKal(int v,int e){
		V = v;
		E = e;
		edge = new Edge[e];
		for(int i=0;i<e;i++){
			edge[i] = new Edge();
		}
	}

	void addEdge(int index,int s,int d,int w){
		edge[index].src = s;
		edge[index].dest = d;
		edge[index].wei = w;
	}

	void makeSet(int data){

		Node temp = new Node();
		temp.data = data;
		temp.rank = 0;
		temp.parent = temp;

		map.put(data,temp);
	}

	Node findSet(Node temp){

		Node parentNode = temp.parent;

		if(parentNode == temp){
			return parentNode;
		}
		temp.parent = findSet(temp.parent);
		return temp.parent;

	}
	int find(int data){

		Node temp = findSet(map.get(data));

		return temp.data;	
	}


	void union(int data1,int data2){

		Node n1 = map.get(data1);
		Node n2 = map.get(data2);

		Node par1 = findSet(n1);
		Node par2 = findSet(n2);

		if(par1.data == par2.data) return;

		if(par1.rank>=par2.rank){

			par1.rank = (par1.rank==par2.rank) ? par1.rank++ :par1.rank;
			par2.parent = par1;
		}else{
			par1.parent = par2;
		}

	}

	void KruskalAlgo(){

		//to store the src des and wei of min spannin tree
		Edge[] result = new Edge[V];
		int resIndex = 0;

		// INitialisw the sorted array to take the edge type of data 
		for(int i=0;i<V;i++){
			result[i] = new Edge();
		}

		Arrays.sort(edge);

		for(int i=0;i<V;i++){
			makeSet(i);
		}
		// int i=0;
		int j=0;
		while(resIndex<V-1){

			Edge next_Edge = new Edge();
			next_Edge = edge[j++];

			// now store the representative element of set 
			// as for source check if the representaive element is what
			// and same for destination 

			int x = find(next_Edge.src);
			int y = find(next_Edge.dest);
			// as if both s and y values are same so they lies in same set 
			// if not lies in same set

			if(x!=y){
				result[resIndex++] = next_Edge;
				union(x,y);
			}

		}

		System.out.println("Edges in constructed MST : ");
		int minCost = 0 ;

		for(int i=0;i<resIndex;i++){

			System.out.println(result[i].src+"->"+result[i].dest+"=="+result[i].wei);
			minCost += result[i].wei;

		}
		System.out.println("Minimum cost spannin tree : " + minCost);


	}
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		krusKal kru = new krusKal(v,e);

		for(int i=0;i<e;i++){
			System.out.print("Enter src & dest : ");
			int s = sc.nextInt();
			int d = sc.nextInt();
			System.out.print("Enter weight : ");
			int w = sc.nextInt();

			kru.addEdge(i,s,d,w);
		}

		kru.KruskalAlgo();

	}

}

/*

0___1___3___6__ 4
|	/  |\	  |
| /	   |   \	|
1/___1___2__4___5


*/
/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java krusKal
Enter vertices and edges count : 6
9
Enter src & dest : 0 1
Enter weight : 3
Enter src & dest : 1 2
Enter weight : 1
Enter src & dest : 2 3
Enter weight : 1
Enter src & dest : 0 3
Enter weight : 1
Enter src & dest : 2 4
Enter weight : 5
Enter src & dest : 3 4
Enter weight : 6
Enter src & dest : 4 5
Enter weight : 2
Enter src & dest : 2 5
Enter weight : 4
Enter src & dest : 1 3
Enter weight : 3
Edges in constructed MST :
1->2==1
2->3==1
0->3==1
4->5==2
2->5==4
Minimum cost spannin tree : 9
*/

/*// take clas edge and store the edges and therw weight 
// make array of type edge and add above into that
// and make sure to implment comparable by edge class as we have weight in decresing order 
// initilize result array of type edge as it store alseo the src - dest and its wight 
// sort the edge type array according to weight
// make the makeSet() or create obj of the stores rank,parent in map 
//to get the disjoint set 
// then unitl we not get count of Vertices-1
// loop 
// then we first take the first edge src,dest 
// pass it to get the representaive element of set 
// in find() funtion call findSet 
// which return the root node 
// as if the first (src) root node == second (Des) root node
//it means both src and des lies in the same set so don't don nothing
// if both lies in diff set then 
// add in result array
//and union(src,des)
// to get into same set 
//repeat step
//then print the result array src,des,weight */