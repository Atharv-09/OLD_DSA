// TIME :O(n) 
// SPACE : O(1)
// using recursion 
// Diameter of BT (Iterative)

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

        System.out.print("Right View : ");
        // DiaPair dp = new DiaPair(root);
        DiaPair d = diameter(root);
        System.out.println(d.dia);
    }
    static class DiaPair{
        int ht;
        int dia;
    }
    public static DiaPair diameter(Node root){

        if(root==null) {
            DiaPair dp1 = new DiaPair();
            dp1.ht = -1;
            dp1.dia = 0;

            return dp1 ;
        }

        DiaPair lp = diameter(root.left);
        DiaPair rp = diameter(root.right);

        DiaPair dp = new DiaPair();
        dp.ht = Math.max(lp.ht,rp.ht) +1; // for hegiht 

        // diameter 1 st para = diameter lies or pass through root 
        // 2 nd para = diameter on left side or right side so take it max 
        dp.dia = Math.max(lp.ht+rp.ht+2,Math.max(lp.dia,rp.dia));

        return dp;

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
/* DIAMETER : (Recursive) 
            TIME COMP : O(n^2) 

            int currMax;
    int h;
    int height(Node temp){
        
        if(temp==null) return 0;
        
        int l = height(temp.left);
        int r = height(temp.right);
        
        if(l<r) h = 1+r;
        else h = 1+l;
        
        return h;
        
    }
    
    int diameter(Node root) {
        // Your code here
        if(root==null) return 0;
         int lHei = height(root.left);
         int rHei = height(root.right);
         int l = diameter(root.left);
         int r = diameter(root.right);
         
        //  if(l>r){
        //      h = 1+l;
        //  }else{
        //      h  = 1+r;
        //  }
         
         currMax = Math.max(lHei+rHei+1,Math.max(l,r));
         
         return currMax;
    }

*/

/*Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).



Example 1:

Input:
       1
     /  \
    2    3
Output: 3
Example 2:

Input:
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 4*/