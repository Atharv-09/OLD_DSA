

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data = d;
    }
}

class BinaryTree{
    static int totalNodes = 0;
    static Scanner sc = new Scanner(System.in);
    static void printTree(Node temp){

        if(temp==null) return;
        else{

            printTree(temp.left);
            System.out.print(temp.data+" ");
            printTree(temp.right);

        }
    }
    public static void main(String[] args) {
        Node root = createTree();

        System.out.print("Entered tree : ");
        printTree(root);

        System.out.print("Total Nodes: ");
        int ans = nodesCount(root);
        System.out.println(ans);
    }
    static int nodesCount(Node root){

        if(root==null)  return 0;
        
        totalNodes++;
        if(root.left!=null)
             nodesCount(root.left);
        if(root.right!=null)
            nodesCount(root.right);

        return totalNodes;

    }


    static Node createTree(){

        Node root = null;
        System.out.print("Enter data : ");
        int in = sc.nextInt();

        if(in==-1) return null;

        root = new Node(in);

        System.out.print("Enter left for " + in + " : ");
        root.left = createTree();

        System.out.print("Enter right for " + in + " : ");
        root.right = createTree();

        return root;

    }

}
