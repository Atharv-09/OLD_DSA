	
import java.util.*;

class DisJointSet{

	class Node{
		int data;
		int rank;
		Node parent;
	}

	private Map<Integer,Node> map = new HashMap<>();

	void makeSet(int data){

		Node temp = new Node();
		temp.data = data;
		temp.rank = 0;
		temp.parent = temp;
		map.put(data,temp);
	}	

	void union(int data1,int data2){

		Node n1 = map.get(data1);
		Node n2 = map.get(data2);

		Node par1 = findSet(n1);
		Node par2 = findSet(n2); 

		if(par1.data==par2.data) return;

		if(par1.rank>=par2.rank){

			par1.rank = (par1.rank==par2.rank) ? par1.rank++ : par1.rank;
			par2.parent = par1;

		}else{

			par1.parent = par2;

		}
	}

	Node findSet(Node node){

		Node paren = node.parent;

		if(paren == node){ // PATH COMPRESSION 
			return paren;
		}
		// ecursively call to reach at root node 
		node.parent = findSet(node.parent);
		return node.parent;
	}

	int find(int data){

		Node ans = findSet(map.get(data));

		return ans.data;
	}
	public static void main(String[] args) {
			
		DisJointSet dj = new DisJointSet();
		Scanner sc = new Scanner(System.in);


		dj.makeSet(1);
		dj.makeSet(2);
		dj.makeSet(3);
		dj.makeSet(4);

		dj.union(1,2);
		dj.union(3,4);

		System.out.print("Enter value1 : ");
		int val1 = sc.nextInt();
		int ans = dj.find(val1);
		
		System.out.print("Enter value2 : ");
		int val2 = sc.nextInt();
		int ans1 = dj.find(val2);

		if(ans==ans1) System.out.println("Element " + val1+ " & " + val2 + " lies in same set");
		else System.out.println("Element " + val1+ " & " + val2 + " not lies in same set");
	}
}
/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ java DisJointSet
Enter value1 : 1
Enter value2 : 3
Element 1 & 3 not lies in same set

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ java DisJointSet
Enter value1 : 1
Enter value2 : 2
Element 1 & 2 lies in same set

*/