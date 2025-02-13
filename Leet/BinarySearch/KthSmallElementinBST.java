class Solution {
    
    int num = 0;
    int ans = 0;
    void find(TreeNode root,int k){
            
        if(root==null) return;
        
        
        find(root.left,k);
        num++;
        if(num == k){
            ans = root.val;
            return;
        }
        find(root.right,k);
        
        // return num;
    }
    public int kthSmallest(TreeNode root, int k) {
        
        if(root==null) return 0;
        find(root,k);
        return ans;    
    }
}

/*

Stack<TreeNode> stack = new Stack<>();
        int counter = 0;
        TreeNode node = root;
        // We can run this while either there's still a node on the stack or we haven't reached the end of the tree
        // Do inorder traversal
        while (!stack.isEmpty() || node != null) {
            // Keep going left while we can 
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                // In order traversal
                // Last added node is obviously the middle node
                TreeNode top = stack.pop();
                counter++;
                if (counter == k) return top.val;
                // Add the right node
                node = top.right;
            }
        }
        // This value literaly doesn't matter, we're never going to reach it given the test cases are guaranteed to return at some point but we need to return something or the method will yell at us
        return -1;


*/

/*
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/