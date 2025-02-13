/*You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1*/

import java.util.*;

class NDT{

	class Edge{
		int s,d,w;

		Edge(int s,int d,int w){
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}

	class Pair implements Comparable<Pair>{
		int curr;
		int weightSofar;

		Pair(int curr,int weightSofar){
			this.curr = curr;
			this.weightSofar = weightSofar;
		}

		public int compareTo(Pair p){
			return this.weightSofar-p.weightSofar;
		}
	}
	private int ver;
	private Map<Integer,List<Edge>> adj;

	NDT(int v){
		ver = v;
		adj = new HashMap<Integer,List<Edge>>();
		for(int i=0;i<ver;i++){
			adj.put(i,new LinkedList<Edge>());
		}
	}

	void addEdge(int s,int d,int w){
		adj.get(s).add(new Edge(s,d,w));
	}

	void delayTime(int src){

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src,0));

		boolean[] vis = new boolean[ver];
		
		Pair removedVer = null;
		int result = 0;

		while(pq.size()>0){

			removedVer = pq.remove();

			if(vis[removedVer.curr]) continue;
			// weight += removedVer.w;
			vis[removedVer.curr] = true;

			ver--;
			result = removedVer.weightSofar;

			for(Edge nei:adj.get(removedVer.curr)){

				if(!vis[nei.d]){
					pq.add(new Pair(nei.d,removedVer.weightSofar+nei.w));
				}
			}
		}
		int ans = ver==0 ? result:-1;
		System.out.println(ans);
		


	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertices and edges count : ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		 NDT ndt = new NDT(v);

		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++){
			System.out.print("Enter source & dest : ");
			int s =sc.nextInt();
			int d =sc.nextInt();
			System.out.print("Enter weight : ");
			int wei = sc.nextInt();

			ndt.addEdge(s,d,wei);
		}

		System.out.print("Enter src(k) : ");
		int k = sc.nextInt();

		// System.out.print("Enter dest(n) : ");
		// int n = sc.nextInt();

		ndt.delayTime(k);
	}

}

/*

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 4 3
Enter 3 edges
Enter source & dest : 1 0
Enter weight : 1
Enter source & dest : 1 2
Enter weight : 1
Enter source & dest : 2 3
Enter weight : 1
Enter src(k) : 1
2

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 5 6
Enter 6 edges
Enter source & dest : 3 2
Enter weight : 2
Enter source & dest : 3 0
Enter weight : 1
Enter source & dest : 0 1
Enter weight : 4
Enter source & dest : 2 4
Enter weight : 1
Enter source & dest : 4 1
Enter weight : 2
Enter source & dest : 2 0
Enter weight : 3
Enter src(k) : 3
5

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 4 3
Enter 3 edges
Enter source & dest : 0 3
Enter weight : 1
Enter source & dest : 3 1
Enter weight : 2
Enter source & dest : 1 2
Enter weight : 3
Enter src(k) : 4
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4      
        at NDT.delayTime(NetworkDelayTime.java:57)
        at NDT.main(NetworkDelayTime.java:105)

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 4 3
Enter 3 edges
Enter source & dest : 0 3
Enter weight : 1
Enter source & dest : 3 1
Enter weight : 2
Enter source & dest : 1 2
Enter weight : 3
Enter src(k) : 3
-1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 2 1
Enter 1 edges
Enter source & dest : 0 1
Enter weight : 1
Enter src(k) : 1
-1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 2 1
Enter 1 edges
Enter source & dest : 0 1
Enter weight : 1
Enter src(k) : 0
1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/Graphs
$ java NDT
Enter vertices and edges count : 6 6
Enter 6 edges
Enter source & dest : 0 1
Enter weight : 1
Enter source & dest : 0 3
Enter weight : 5
Enter source & dest : 1 2
Enter weight : 2
Enter source & dest : 2 3
Enter weight : 1
Enter source & dest : 3 5
Enter weight : 2
Enter source & dest : 2 4
Enter weight : 4
Enter src(k) : 0
7*/