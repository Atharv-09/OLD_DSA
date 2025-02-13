import java.util.*;

class Graph{


	// Bipartite 
	// if there is cycle and the lenght of cycle is odd then NOT BIPARTITE
	// if there is cycle and the lenght of cycle is even then  BIPARTITE
	// if there is acyclic graph then it is always BIPARTITE 


	static class Pair{

		int ver;
		String psf;
		int level;

		Pair(int ver,String psf,int level){
			
			this.ver = ver;
			this.psf = psf;
			this.level = level;

		}
	}


	static 

	
	Graph(int v){

		adj = new HashMap<Integer,List<Integer>>();

		for(int i=0;i<=v;i++){
			adj.put(i,new ArrayList<Integer>());
		}
	}

	void addEdge(int s,int d){

		adj.get(s).add(d);
		adj.get(d).add(s);

	}


	static boolean checkCompForBipartite(int src,int v,int[] vis){

		ArrayDeque<Pair> qu = new ArrayDeque<>();

		qu.add(new Pair(src,src+" ",0));

		while(qu.size() > 0){

			Pair p = qu.removeFirst();
			// if this is already visited then do somethind 
			if(vis[p.ver] != -1){

				if(vis[p.ver] != p.level){

					return false;
				}
			}else{
				vis[p.ver] = p.level;
			}

			// vis[p.ver] = true;

			for(int nei:adj.get(p.ver)){

				if(vis[nei] == -1 ){ // is not visited 		
					qu.add(new Pair(nei,p.psf+nei,p.level+1));
				}
			}
		}	
		return true;

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices & edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		System.out.println("Enter edges : ");
			
		Graph obj = new Graph(v);

		for(int i=0;i<e;i++){

			int s = sc.nextInt();
			int d = sc.nextInt();

			obj.addEdge(s,d);
		}


		int[] vis = new int[v];
		Arrays.fill(vis,-1);

		for(int i=0;i<v;i++){

			if(vis[i] == -1){
				boolean isCompBipartite = checkCompForBipartite(i,v,vis);

				if(!isCompBipartite){
					System.out.println(false);
					return;
				}
			}
		}
		System.out.println(true);
		// if(isBipartite(v)){
		// 	System.out.println("The graph is bipartitie ");			
		// }else 	
		// 	System.out.println("The graph is non bipartitie");

	}
}