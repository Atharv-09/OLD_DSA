/*Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

Example 1:

Input:
T:      1          S:   3
      /   \            /
     2     3          4
   /  \    /
  N    N  4
Output: 1 
Explanation: S is present in T

Example 2:

Input:
T:      26         S:   26
       /   \           /  \
     10     N        10    N
   /    \           /  \
   20    30        20  30
  /  \            /  \
 40   60         40  60
Output: 1 
Explanation: 
S and T are both same. Hence, 
it can be said that S is a subtree 
of T. */


// TIME : O(mn) -> m for bt1 n for bt2
// IN THIS WE CHECK FIRST THAT THE NODE MATCHES with each other or not from root node
// if not then we go for left subtree 
// againg check the root of left subtree mathes if mathes check for anotheer subtree data matches or not if matches return true else false
// again for right subtree if there root data matches then go for left n right of that rightsubtree root
//else againg gor for subtree

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
        Node root1  = createTree();
        Node root2 = createTree() ;
        System.out.print("Entered tree : ");
        printTree(root1);

        boolean ans = SubtreeOrNot(root1,root2);

        if(ans) System.out.println("It is subtree");
        else System.out.println("It is not subtree");
    }

    static boolean currNodeMatch(Node t1,Node t2){

        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        // if(t1.data!=t2.data && t1.left==null ||  t1.right==null) return false;

        // if(t1.data==t2.data){
            return t1.data==t2.data && currNodeMatch(t1.left, t2.left) && currNodeMatch(t1.right, t2.right);
        // }

    }

    static boolean SubtreeOrNot(Node t1,Node t2){

        if(t2==null) return true;
        if(t1==null) return false;

        // if the currnode matches from root node
        if(currNodeMatch(t1,t2)) return true;   

        // if root node not match go to leaft of the tree otherwise go to right subtree of tree
        // if(t1.left!=null && t1.right!=null)
        return SubtreeOrNot(t1.left, t2) || SubtreeOrNot(t1.right, t2);

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
