class Node{
	int data;
	Node left,right;

	Node(int d){
		data = d;
		left= right=null;
	}
}

class BST{

	static  Node root;

	void insert(int d){
		this.root = this.insertRec(this.root,d);
	}
	Node insertRec(Node node,int data){

		if(node==null){
			root= new Node(data);
			return root;
		}

		if(data<root.data){
			root.left = insertRec(node.left,data);
		}else if(data>root.data){
			root.right = insertRec(node.right,data);
		}
		return node;
	}

	void printIN(Node root){

		if(root==null) return;

		printIN(root.left);
		System.out.print(root.data+" ");
		printIN(root.right);

	}
	public static void main(String[] args) {
		
		BST bst = new BST();

		bst.insert(11);
		bst.insert(2);
		bst.insert(29);
		bst.insert(1);
		bst.insert(7);
		bst.insert(15);
		bst.insert(40);
		bst.insert(35);

		bst.printIN(root);
		System.out.println();


	}
}