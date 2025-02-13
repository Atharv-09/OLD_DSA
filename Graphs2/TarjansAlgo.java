import java.util.*;

class Tarjans{

	int V;
	LinkedList<Integer> adj[];
	int time;
	Tarjans(int v){

		V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList();
		}

		time = 0;
	}
	void addEdge(int s,int d){
		adj[s].add(d);	
	}


	void scsUtil(int[] low,int[] disc,boolean[] inStack,Stack<Integer> st,int src){

		disc[src] = time;
		low[src] = time;
		time++;

		st.push(src);
		inStack[src] = true;

		// go for neightbor 
		Iterator<Integer> it = adj[src].iterator();
		int n=0;

		while(it.hasNext()){

			n = it.next();

			// if not visited then do the same procedire 
			// i.e update low n disc n inStack n stack 
			if(disc[n] == -1){
				// call the same 
				scsUtil(low,disc,inStack,st,n);

				// for the edge not present in staack 
				// BACK EDGE 

				low[src] = Math.min(low[src],low[n]);

			}else if(inStack[n] == true){ // CROSS EDGE 
				// is already viside and want to check that it is CROSS EDGE or BACK EDGE 
				// CROSS : chcekc if the ele is present in the stack
				// BACK : if not present in stack 

				// if we get the ele present in stack means its tack is true
				// CROSS EDGE 
				low[src] = Math.min(low[src],disc[n]);
			}

		}

		// if all the outgoing edges are coverd
		//before backtracking  we check that the curr this is the head of STRINGLY CONNECTED COMP.
		// check if there low and misc is same 

		if(low[src] == disc[src]){

			// as if we get the head 
			// pop until the stack not has the head node 
			int w =-1;

			while( w != src){

				w = st.pop();
				System.out.print(w+" ");
				inStack[w] = false;
			}
			System.out.println();
		}


	}

	void scc(){

		int low[] = new int[V];
		int disc[] = new int[V];

		boolean inStack[] = new boolean[V];
		Arrays.fill(low,-1);
		Arrays.fill(disc,-1);
		Arrays.fill(inStack,false);

		Stack<Integer> st = new Stack<>();

		for(int i=0;i<V;i++){

			if(disc[i] == -1){
				scsUtil(low,disc,inStack,st,i);
			}
		}

	}
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter edges and vertices count : ");
		int e = sc.nextInt();
		int v = sc.nextInt();

		Tarjans tj = new Tarjans(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			int src = sc.nextInt();
			int dest = sc.nextInt();

			tj.addEdge(src,dest);
		}


		tj.scc();
	}
}

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs2
$ java Tarjans
Enter edges and vertices count :
10 7
Enter 10 edges
0 1
1 2
1 3
3 4
4 5
4 6
5 6
6 5
5 2
4 0
2
6 5
4 3 1 0

*/