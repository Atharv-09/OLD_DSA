import java.util.*;

class Node{
    int data;   
    Node left,right;

    Node(int d){
        data = d;
    }
}

class BinaryTree{
    static Node root;
    static void showTree(Node temp){
        
            if(temp==null) return;

            showTree(temp.left);
            System.out.print(temp.data+" ");
            showTree(temp.right);

    }

    static void findSpiral(Node node) 
      {
         
           if(root==null) return;

           Stack<Node> st1 = new Stack<Node>();
           Stack<Node> st2 = new Stack<Node>();
           
           st1.push(root);
           while(!st1.empty() || !st2.empty()){
               
               while(!st1.empty()){
                   
                   Node curr = st1.peek();
                   st1.pop();
                   System.out.print(curr.data+" ");                   
                   
                   if(curr.right!=null) st2.push(curr.right);
                   if(curr.left!=null) st2.push(curr.left);
               }
               while(!st2.empty()){
                            
                    Node curr = st2.peek();
                    st2.pop();
                    System.out.print(curr.data+" ");                   
                    
                    if(curr.left!=null) st1.push(curr.left);
                    if(curr.right!=null) st1.push(curr.right);
                
               }
            
           }
        }
    public static void main(String[] args) {
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(7); 
        root.left.right = new Node(6); 
        root.right.left = new Node(5); 
        root.right.right = new Node(4); 
        // root = new Node(1);
        // root.left = new Node(3);
        // root.right= new Node(2);
        // root.right.left = new Node(6);
        // root.right.left.right = new Node(11);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.left.right.left = new Node(7);
        // root.left.right.right = new Node(8);
        // root.left.right.right.left = new Node(9);

        System.out.print("Inorder of Binary tree : ");
        showTree(root);

        System.out.print("\nLevel Order Spiral tree : ");
        findSpiral(root);    
        // showTree(ans);
    }
}

/*@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ java BinaryTree
Inorder of Binary tree : 3 1 4 2 5Level Order Spiral tree : 1 3 2 5 4
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BIn

Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.



Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
*/