
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

        System.out.print("\nBoundary traversed View : ");
        boundaryTraverse(root);
    }

    static void leftBoundary(Node root){

        if(root==null) return;

        if(root.left!=null){
            System.out.print(root.data+" ");
            leftBoundary(root.left);
        }else if(root.right!=null){
            System.out.print(root.data+" ");
            leftBoundary(root.right);
        }

    }
    static void leafBoundary(Node root){
        if(root==null) return;

        leafBoundary(root.left);
        if(root.left==null && root.right==null)
            System.out.print(root.data+" ");
        
        leafBoundary(root.right);
    }
    static void rightBoundary(Node root){

        if(root==null) return;
        if(root.right!=null){
            System.out.print(root.data+" ");
            rightBoundary(root.right);
        }else if(root.left!=null){
            System.out.print(root.data+" ");
            rightBoundary(root.left);
        }
    }
    static void boundaryTraverse(Node root){

       // for left 

         leftBoundary(root);

         leafBoundary(root.left);
         leafBoundary(root.right);
         
         rightBoundary(root.right);
        System.out.println();


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
