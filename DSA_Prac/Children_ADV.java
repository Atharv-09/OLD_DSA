import java.util.*;

class Main{


	static int V;

	Map<Integer,List<Integer>> map;

	Main(int v){
		V = v;
		map = new HashMap<Integer,List<Integer>>();

		for(int i=1;i<=v;i++){
			map.put(i,new LinkedList<Integer>());
		}
	}

	void addEdge(int s,int d){
		map.get(s).add(d);
	}

	int maxStrrength = Integer.MIN_VALUE;

	void dfsTraverse(boolean[] vis,int node,int arr[],int maxTill){

		vis[node-1] = true;

		maxTill  = maxTill + arr[node-1];

		for(int child:map.get(node)){

			if(!vis[child-1]){
				dfsTraverse(vis,child,arr,maxTill);
			}
		}

		if(maxTill>maxStrrength){
			maxStrrength=maxTill;
		}

	}
	void dfs(int arr[]){

		boolean[] vis = new boolean[V];
		Arrays.fill(vis,false);


		for(int i=1;i<=V;i++){

			if(!vis[i-1]){
				dfsTraverse(vis,i,arr,0);
			}
		}

		System.out.println(maxStrrength);
	}
	public static void main(String[] args) {
		
		int n = 6;
		int arr[] = {11,2,3,15,8,22};

		int m = 4;

		Main obj = new Main(6);
		int edges[][] = {{3,2},{1,4},{2,3},{4,5}};

		for(int i=0;i<m;i++){
			obj.addEdge(edges[i][0],edges[i][1]);
		}	
		
		obj.dfs(arr);
	}
}