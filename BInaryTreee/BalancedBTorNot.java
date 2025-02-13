import java.util.*;
class Node{
    int data;
    Node left,right;

    Node(int d){
        data = d;
    }
}

class Height{
    int height = 0; 
}
class BinaryTree{
        // O (n^2)
        // static int h;
        // static int height(Node root){

        //     if(root==null) return 0;

        //     int l = height(root.left);
        //     int r = height(root.right);

        //     if(l>r) h = 1+l;
        //     else h = 1+r;

        //     return h;
        // }

        // static boolean isBalance(Node root){
        //     if(root==null) return true;

        //     int lh;
        //     lh = height(root.left);
        //     int rh;
        //     rh =height(root.right);

        //     // it first calcualte the left hei or root and right hei of root 
        //     // then chk if there diff is less then 1 
        //     // then again also we have to heck for each node left and right 
        //     // so we recursilvely call the isBalance funcrtion and at each call it calcualte the hieght
        //     // compare the height and give result
        //     if(Math.abs(lh-rh) <= 1 && isBalance(root.left) && isBalance(root.right)){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }   

        
         boolean isBalance(Node root,Height height){
            if(root==null){
                height.height = 0;
                return true;
            }

            Height lh = new Height();
            Height rh = new Height();

            boolean l = isBalance(root.left,lh);
            boolean r = isBalance(root.right,rh);
            
            int lefH = lh.height,rigH = rh.height;

            height.height = (lefH>rigH ? lefH:rigH)+1;

            if(Math.abs(lefH-rigH) >=2 ) 
                return false;
            else 
                return l&&r;

        }
        static Node root;
        public static void main(String[] args) {
            root = new Node(10);
            root.left = new Node(20);
            root.left.right = new Node(30);
            Height h = new Height();
            BinaryTree bt = new BinaryTree();
            boolean ans = bt.isBalance(root,h);

            System.out.println(ans);
        }
}



/*Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5

Example 1:

Input:
      1
    /
   2
    \
     3 
Output: 0
Explanation: The max difference in height
of left subtree and right subtree is 2,
which is greater than 1. Hence unbalanced
Example 2:

Input:
       10
     /   \
    20   30 
  /   \
 40   60
Output: 1
Explanation: The max difference in height
of left subtree and right subtree is 1.
Hence balanced. */