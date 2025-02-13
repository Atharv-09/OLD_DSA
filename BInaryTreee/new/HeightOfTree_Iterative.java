// TIME :O(n) 
// SPACE : O(n)
// using queue(Iterative) 

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

    static int heightIterative(Node root){

        if(root==null) return 0;

        Queue<Node> qu = new LinkedList<Node>();

        qu.add(root);
        int height=0;

        while(true){

            int nodeCount = qu.size();
            if(nodeCount==0) return height;

            height++;

            while(nodeCount>0){
                Node headNode = qu.peek();
                qu.remove();

                if(headNode.left!=null) 
                    qu.add(headNode.left);
                
                if(headNode.right!=null)
                    qu.add(headNode.right);

                nodeCount--;
            }
        }
    }


    public static void main(String[] args) {
        Node root = createTree();

        System.out.print("tree : ");
        printTree(root);
    
        System.out.println();

        int h = heightIterative(root);
        System.out.println("Height of tree : " + h);
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

