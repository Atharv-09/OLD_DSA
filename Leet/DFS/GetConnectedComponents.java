import java.util.*;

class ConnectedComp{

	int ver;
	ArrayList<ArrayList<Integer>> adj ;

	ConnectedComp(int V){
		ver = V;

		adj = new ArrayList<>();
		for(int i=0;i<V;i++){
			adj.add(i,new ArrayList<>());
		}
	}

	void DFSUtil(boolean[] vis,int vertex){

		vis[vertex] = true;
		System.out.print(vertex+" ");
		for(int neigh:adj.get(vertex)){
			if(!vis[neigh])
				DFSUtil(vis,neigh);
		}

	}
	void getComponents(){
		boolean[] vis  = new boolean[ver];
		int count = 0;

		for(int i=0;i<ver;i++){
			if(!vis[i]){
				DFSUtil(vis,i);
				count++;
				System.out.println();
			}
		}
		System.out.println("Total strnogly connected componenets :  " +count);
	}

	void addEdge(int s,int d){
		adj.get(s).add(d);
		adj.get(d).add(s);
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		ConnectedComp cc = new ConnectedComp(v);

			System.out.println("Enter "+e+" edges");
			for(int i=0;i<e;i++){
				System.out.print("Enter source & dest : ");
				int s =sc.nextInt();
				int d =sc.nextInt();
			
				cc.addEdge(s,d);
			}

		cc.getComponents();

	}
}