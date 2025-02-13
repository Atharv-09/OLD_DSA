import java.util.*;

// using DFS 
// time : O(v+e) 
// space : O(v);
class CycleDetection_UnDirect{

	private final int ver;
	private Map<Integer,List<Integer>> adj;

		
	CycleDetection_UnDirect(int v){

		ver = v;
		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<v;i++){
			adj.put(i,new LinkedList<Integer>());
		}
	}

	void addEdge(int src,int dest){
		adj.get(src).add(dest);
		adj.get(dest).add(src);
	}
	

	boolean cycleFound(int cur,boolean[] vis,int par){

		vis[cur] = true;

		/*Iterator<Integer> it =  
                adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
			if (!visited[i]) 
            { 
                if (isCyclicUtil(i, visited, v)) 
                    return true; 
            } 
  
            // If an adjacent is visited  
            // and not parent of current 
            // vertex, then there is a cycle. 
            else if (i != parent) 
                return true; 
        } 
         */
		for(int neigh:adj.get(cur)){

			// If an adjacent is not  
            // visited, then recur for that 
            // adjacent 
			if(!vis[neigh]){
				cycleFound(neigh,vis,cur);
			}
			  // If an adjacent is visited  
            // and not parent of current 
            // vertex, then there is a cycle. 
			else if(neigh!=par){
				return true;
			}
		}

		return false;
	}
	boolean detectCycle(){
		boolean vis[] = new boolean[ver];
		
		// int parent[] = new int[ver];


		for(int i=0;i<ver;i++){
			if(!vis[i]){
				if(cycleFound(i,vis,-1))
					return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		CycleDetection_UnDirect unDir = new CycleDetection_UnDirect(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();
			unDir.addEdge(src,dest);
		}

		if(unDir.detectCycle()){
			System.out.println("Cycle detected");			
		}else{
			System.out.println("There is no cycle");
		}
	}
}