class Solution {
    int count = 0;
    
    int find(TreeNode root){
        
        if(root==null) return 0;
        
        int lef = find(root.left);
        int rig = find(root.right);
        
        int ls=0,rs=0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if(root.left!=null && left.val == root.val ){
            ls+=(lef+1);
        }
        if(root.right!=null &&  right.val == root.val ){
            rs+=(rig+1);
        }
        
        count = Math.max(count,ls+rs);
        
        return Math.max(ls,rs);
        
    }
   
    public int longestUnivaluePath(TreeNode root) {
        
        find(root);
        return count;
    }
}

/*Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [5,4,5,1,1,N,5]
Output: 2
Example 2:


Input: root = [1,4,5,4,4,N,5]
Output: 2*/