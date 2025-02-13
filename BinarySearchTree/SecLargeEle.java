import java.util.*;

class Node{
		int data;
		Node left,right;

		Node(int data){
			this.data = data;
			left=right=null;
		}
}

class BST{

	

	Node root;

	BST(){
		root=null;
	}



	void insert(int d){
		this.root = this.insertRec(this.root,d);
	}
	Node insertRec(Node node,int data){

		if(node==null){
			this.root= new Node(data);
			return this.root;
		}

		if(data<root.data){
			root.left = this.insertRec(node.left,data);
		}else if(data>root.data){
			root.right = this.insertRec(node.right,data);
		}
		return node;
	}

	class Count{
		int c = 0;
	}
	void findSecLargest(Node node,Count C){

		if(node==null || C.c>=2) return;

		this.findSecLargest(node.right,C);
		C.c++;

		if(C.c==2){
			System.out.println("Second largest number : " + node.data);
			return;
		}

		this.findSecLargest(node.left,C);
	}
	
	void secLarge(Node root){

		Count c =new Count();
		this.findSecLargest(this.root,c);
	}
	public static void main(String[] args) {
		
	
		BST tree = new BST();
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

     	tree.secLarge(tree.root);

        
	}
}