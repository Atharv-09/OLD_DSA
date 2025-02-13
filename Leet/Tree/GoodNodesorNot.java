/*Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

 

Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.*/



class GoodNodeorNot{
	int count = 0;
    // TreeNode prev = new TreeNode(0);
    void findCount(TreeNode root,int max){
           
         if(root == null){
            return;
        }    
        
        if(root.val >= max){
            max = root.val;
            count++;
        }
        
        findCount(root.left, max);
        findCount(root.right, max);
        
//         int count = 0;
        
//         TreeNode left = root.left;
//         TreeNode righ = root.right;
        
//         if(left!=null){
//             if(left.val >= rootData){
//                 count++;
//             }
            
//             count += findCount(left,Math.max(rootData,left.val));
//         }
        
//         if(righ!=null){
//             if(righ.val >= rootData){
//                 count++;
//             }
            
//             count += findCount(righ,Math.max(rootData,righ.val));
//         }
//         return count;
        
    }
    
    public int goodNodes(TreeNode root) {
        
        // int count = 0;
        // if(root==null ) return 0;
       
        findCount(root,root.val);
        return count;
        // findNode(root.right,root.val);
        
        // return count;
    }
}