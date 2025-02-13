
//TINE : O(n) -- > as in inorder n is no of nodes 
// SPace : O(h)

class DLL{

	static Node root;

	class Node{
		Node left,right;
		int data;
		Node(int d){
			data = d;
		}
	}

	Node head;
	Node prev = null;

	void printDLL(){
		Node node = head;
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.right;
		}

		System.out.println("\nIN REVERSE : ");
		node = head;
		while(node.right!=null){
			node=node.right;
		}

		while(node!=null){
			System.out.print(node.data+" ");
			node = node.left;
		}
	}
	void bstToDLL(Node root){

		if(root==null) return; //base 

		bstToDLL(root.left);

		if(prev==null){
			//if we are at left most node then it becomse head node
			head = root;
		}else{
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		bstToDLL(root.right);
	}

	public static void main(String[] args) {
			
			DLL obj = new DLL();
			root = obj.new Node(1);
			root.left = obj.new Node(2);
			root.left.left = obj.new Node(4);
			root.left.right = obj.new Node(5);
			root.right = obj.new Node(3);

			obj.bstToDLL(root);

			obj.printDLL();
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ java DLL
4 2 5 1 3
IN REVERSE :
3 1 5 2 4
*/