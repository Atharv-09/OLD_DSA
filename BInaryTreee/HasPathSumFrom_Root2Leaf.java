// Find if sum we pass is eql to the sum of node data from root to leaf

class Node{
    int data;
    Node left,right;

    Node(int d){
        data = d;
    }
}

class BinaryTree{

    static boolean hasPathSum(Node root,int S){
        // BELOW 2 LINES 
        //if(S==0) return true;
        //if(root==null) return false;
        
        // OR 
        
        // If s is not given or 0 then it return true acc to above line but and is 0 
        if(root==null) return S==0;
        
        // LOGIC is
        //1 Traverse from root node to last node 
        // first for the currNode decrese the S value 
        //As like preorder form 
        // as we reaches the leaf node and s==0 then return true
        // else return fales
        // as if one of the end has the found = to S then it return true that's why we taken || 


        /*currSum += root.data;
         if(S==0)
             return true;
        currSum = currSum - root.data;
         */

        boolean lPath = hasPathSum(root.left,S-root.data);
        boolean rPath = hasPathSum(root.right,S-root.data);
        
        return lPath||rPath;
    }
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.left.right.left = new Node(9);
        // root.left.right.right = new Node(1);
        // root.left.right.right.right = new Node(18);
        root.right = new Node(3);
        // root.right.right = new Node(7);
        // root.right.right.left = new Node(8);

        //root.left.right = new Node(30);
        
        boolean ans = hasPathSum(root,5);

        System.out.println(ans);
    }
}

/*Given a binary tree and an integer S, check whether there is root to leaf path with its sum as S.

Example 1:

Input:
Tree = 
            1
          /   \
        2      3
S = 2

Output: 0

Explanation:
There is no root to leaf path with sum 2.
Example 2:

Input:
Tree = 
            1
          /   \
        2      3
S = 4

Output: 1

Explanation:
The sum of path from leaf node 3 to root 1 is 4.*/