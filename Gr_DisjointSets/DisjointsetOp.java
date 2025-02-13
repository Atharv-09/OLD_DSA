// USING 
	
// UNION BY RANK and PATH COMPRESSION 

import java.util.*;
class DisjointSet{
	
	class Node{
		int rank;
		int data;
		Node parent;
	}

	private Map<Integer,Node> map = new HashMap<>();


	// makeSet()
	// create a set with only one node/element


	void makeSet(int data){
		Node temp = new Node();
		temp.rank = 0;
		temp.data = data;
		temp.parent = temp;
		map.put(data,temp);
	}

	// union () 
	// merge 2 diff set and merge into 1 ser 

	void union(int data1,int data2){

		// we get both the nodes which are pointes to resp data 
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		// to get the parent of both nodes
		//or to get the represenatative of that set in which these node exists 
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		// if both element is part of same set
		if(parent1.data == parent2.data) return;

		//whose rank is higher make them as parent 
		//if the node 1 parent has more rank then node 2 parent 
		if(parent1.rank>=parent2.rank){
			// if they has same rank then the parent one rank incrsees by 1
			// if they has not same rank then no increse in rank 
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank+1 : parent1.rank;
			// make node 1 as parent of node2 
			parent2.parent = parent1;
		}else{
			parent1.parent = parent2;
		}


	}

	Node findSet(Node node){

		Node paren = node.parent;
		if(paren==node){
			return paren;
		}
		// by returning paren we are setting all nodes parent as the root node

		//PATH COMPRESSION


		node.parent = findSet(node.parent);
		return node.parent;

	}

	// to get the representative element of any element 

	int find(int data){
		Node root = findSet(map.get(data));
		
		return root.data;
	}

	public static void main(String[] args) {
		

		DisjointSet djs = new DisjointSet();
		djs.makeSet(1);
		djs.makeSet(2);
		djs.makeSet(3);
		djs.makeSet(4);
		djs.makeSet(5);
		djs.makeSet(6);
		djs.makeSet(7);


		djs.union(1,2);
		djs.union(2,3);
		djs.union(4,5);
		djs.union(6,7);
		djs.union(5,6);
		djs.union(3,7);

		System.out.println(djs.find(3));
		System.out.println(djs.find(5));
		System.out.println(djs.find(6));
		

	}

}

