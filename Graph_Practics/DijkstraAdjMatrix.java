import java.util.*;

class Graph{

	private int graph[][];
	private int ver;

	Graph(int v){
		ver = v;
		graph = new int[v][v];
	}

	void addEdge(int s,int d,int w){
		graph[s][d] = w;
		graph[d][s] = w;
	}

	int minimumDist(int val,boolean vis[]){

		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for(int i=0;i<ver;i++){

			if(!vis[i]){
				if(graph[val][i]<min){
					min = graph[val][i];
					min_index = i;
				}
			}
		}

		return min_index;

	}

	void printSolution(int key[],int str){

		for(int i=0;i<ver;i++){

			System.out.println(i + " " + key[i]);
		}

	}

	void dijkstraAdjMat(){

		int key[] = new int[ver];
		boolean vis[] = new boolean[ver];

		for(int i=0;i<ver;i++){
			key[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}

		key[0] = 0;

		for(int i=0;i<ver-1;i++){

			int minDist = minimumDist(i,vis);
			vis[minDist]  = true;

			for(int j=0;j<ver;j++){

				if(!vis[j] && graph[minDist][j]+key[minDist]<key[j] && key[minDist]!=Integer.MAX_VALUE && graph[minDist][j]!=0 ){
					key[j] = key[minDist]+graph[minDist][j]; 
				}
			}

		}

		printSolution(key,0);

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
			System.out.println("Enter weight : ");
			int wei = sc.nextInt();
			g.addEdge(s,d,wei);
		}

		// g.print();
	
		System.out.print("Enter source : ");
		int src = sc.nextInt();

		g.dijkstraAdjMat();


	}
}
	
