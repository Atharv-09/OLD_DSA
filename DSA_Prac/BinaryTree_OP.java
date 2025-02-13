import java.util.*;

class Node{

		int data;
		Node left,right;

		Node(int d){
			data = d;
			left = right = null;
		}
}

class BT{


	static Node root = null;
	

	static void inorder(Node node){

		if(node==null) return;

		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);

	}

	static void preorder(Node node){

		if(node==null) return;

		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);
		
	}

	static void postorder(Node node){

		if(node==null) return;

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data+" ");

	}

	static Node createTree(){

		Node root1 = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter data : ");
		int d = sc.nextInt();

		if(d==-1) return null;

		root1 = new Node(d);
		System.out.print("Enter left of " + d + " : ");
		root1.left = createTree();

		System.out.print("Enter right of " + d + " : ");
		root1.right = createTree();

		return root1;
	}

	static void insert(int val,Node root){


		if(root==null){
			root = new Node(val);
			return;
		}

		//l evevel order 

		Queue<Node> qu = new LinkedList<>();

		qu.add(root);

		while(!qu.isEmpty()){

			Node curr = qu.remove();

			if(curr.left==null){
				curr.left = new Node(val);
				break;
			}else{
				qu.add(curr.left);
			}

			if(curr.right==null){
				curr.right = new Node(val);
				break;
			}else{
				qu.add(curr.right);
			}

		}
	}

	static void delete(Node val,Node root){


		Queue<Node> qu = new LinkedList<>();

		qu.add(root);

		while(!qu.isEmpty()){

			Node curr = qu.remove();

			if(curr == val){
				curr = null;
				return;
			}

			if(curr.left!=null){

				if(curr.left == val){
					curr.left = null;
					return;
				}else{
					qu.add(curr.left);
				}
			}

			if(curr.right!=null){
				
				if(curr.right == val){
					curr.right = null;
					return;
				}else{
					qu.add(curr.right);
				}
			}

		}
	}
	public static void main(String[] args) {
		
		// hardcoded 
		root = new Node(10);
		root.left = new Node(2);
		root.left.left = new Node(8);
		root.left.right = new Node(16);
		root.right = new Node(14);

		System.out.print("\n INORDER : ");
		inorder(root);

		System.out.print("\n PREORDER : ");
		preorder(root);

		System.out.print("\n POSTORDER : ");
		postorder(root);

		System.out.println();


		/*System.out.println("Enter tree manual : ");


		Node root1 = createTree();
		System.out.print("\n INORDER : ");
		inorder(root1);

		System.out.print("\n PREORDER : ");
		preorder(root1);

		System.out.print("\n POSTORDER : ");
		postorder(root1);

		System.out.println();
		*/
		//INSERT 90 into tree

		insert(90,root);

		System.out.println("INORER AFTER INSERTION : ");
		inorder(root);

		delete(,root);

		System.out.println("INORER AFTER DELEtioN : ");
		inorder(root);

	}
}