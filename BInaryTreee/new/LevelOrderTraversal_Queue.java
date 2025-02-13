// TIME :O(n^2) 
// SPACE : O(n)
// using recursion 
// LEVEL ORDER TRSVERSAL is BREADTH FIRST TRAVERSAL of tree

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data = d;
    }
}

class BinaryTree{
    
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

        System.out.print("\nLevel Ordered traversal of tree(BFT) : ");
        printLevelWiseTree(root);
    }

    static void printLevelWiseTree(Node root){

        Queue<Node> qu = new LinkedList<Node>();

        //base 
        if(root==null) return;

        qu.add(root); // add root node to queue

        while(!qu.isEmpty()){

            Node topNode = qu.peek(); // it gives the head element of que
            qu.remove(); // and we remove the head node from the wuee

            System.out.print(topNode.data+" "); // print the data of head nofe

            // but as the headnode is removed then add its left node and right node to queue because
            // as in queue ther is root node
            // 1) add left node 2) add right node 
            // queue = > 10 20 
            // as we remove 10 then add left and right node of 10 
            // queue => 20 40 60 
            // as we remove the 20 add left and right node of 20 /......go on uptil the end is null and print n add
            if(topNode.left!=null) 
                qu.add(topNode.left);
            
            if(topNode.right!=null)
                qu.add(topNode.right);

        }


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
