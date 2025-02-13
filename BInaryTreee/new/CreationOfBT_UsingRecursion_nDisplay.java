// creating the BT uinsg recursion and printing its 2 ordes 

import java.util.*;

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class BinaryTree{
// 
    // Node root;
    static Scanner sc = new Scanner(System.in);

    static void printInorder(Node root){

        if(root==null) return;

        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);

    }

    static void printPreOrder(Node root){

        if(root==null) return;

        System.out.print(root.data+" ");
        printPreOrder(root.left);    
        printPreOrder(root.right);
    }
    static void printPostOrder(Node root){

        if(root==null) return;

        printPostOrder(root.left);    
        printPostOrder(root.right);
        System.out.print(root.data+" ");
    }


    public static void main(String[] args){

        Node root = createTree();

        System.out.println("----IN-ORDER----");
        printInorder(root);
        System.out.println("\n----PRE-ORDER----");
        printPreOrder(root);
        System.out.println("\n----POST-ORDER----");
        printPostOrder(root);
    }

    static Node createTree(){

        Node root = null;
        System.out.print("Enter data: ");
        int data = sc.nextInt();

        // if the user enter -1 so its left/right is null so it return from that point
        if(data==-1) return null;
        // is it is not -1 then it will create new node 
        root = new Node(data);
        System.out.print("\nEnter left for "+data+" : ");
        root.left = createTree();

        System.out.print("\nEnter right for "+data+" : ");
        root.right = createTree();


        return root;
    }   

}
/*$ java BinaryTree
Enter data: 1

Enter left for 1 : Enter data: 2

Enter left for 2 : Enter data: 4

Enter left for 4 : Enter data: -1

Enter right for 4 : Enter data: -1

Enter right for 2 : Enter data: 5

Enter left for 5 : Enter data: -1

Enter right for 5 : Enter data: -1

Enter right for 1 : Enter data: 3

Enter left for 3 : Enter data: -1

Enter right for 3 : Enter data: -1
----IN-ORDER----
4 2 5 1 3
----PRE-ORDER----
1 2 4 5 3
----POST-ORDER----
4 5 2 3 1*/