import java.util.*;

class Main{

	static class Node{

		int data;
		Node left,right;

		Node(int d){
			data = d;
			left = right = null;
		}
	}
	static Node root;

	static Scanner sc= new Scanner(System.in);

	static Node createTree(int[] arr,int i,Node root){


        // Node root = null;
        // System.out.print("Enter data: ");
        // int data = sc.nextInt();

		if(i<arr.length){
	        // is it is not -1 then it will create new node 
	        Node temp = new Node(arr[i]);
	        root=temp;
	        // System.out.print("\nEnter left for "+data+" : ");
	        root.left = createTree(arr,2*i+1,root.left);

	        // System.out.print("\nEnter right for "+data+" : ");
	        root.right = createTree(arr,2*i+2,root.right);
		}
      


        return root;

		
	}	

	static void inorder(Node temp){

		if(temp==null) return;

		inorder(temp.left);
		System.out.print(temp.data+" ");
		inorder(temp.right);


	}

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6};


			root= createTree(arr,6,root);


		
		inorder(root);
	}
}