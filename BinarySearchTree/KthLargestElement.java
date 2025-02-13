import java.util.*;
class Node{
    Node left,right;
    int data;
    Node(int d){
        data = d;

    }
}
class Count{
    int m=0;
}
class BinaryTree{
    static Node root;
    // static int m;
    static void Kthlargest(Node root,int K,Count C){
        
        //Your code here
        if(root==null || C.m>=K) return;
        
        // if(root.right!=null)
        Kthlargest(root.right,K,C);  
        C.m++;
        if(K==C.m){
            System.out.println(root.data);
            return;
        }
        
        // if(root.left!=null)
        Kthlargest(root.left,K,C);
      
    }
    public static void main(String[] args) {

        root = new Node(15);
        root.left=  new Node(10);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.left =new Node(2);
        root.left.right = new Node(11);
        root.left.right.right = new Node(14);

        root.right = new Node(17);
        root.right.right = new Node(22);
        root.right.right.right =new Node(25);
        root.right.left = new Node(19);
        root.right.right.left = new Node(21);

        Kthlargest(root,4,new Count());
    }
}

