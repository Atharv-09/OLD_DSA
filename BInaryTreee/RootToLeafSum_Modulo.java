/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {

    int totalSum = 0;

    void find(TreeNode root,int currVal){

        if(root==null) return;
        

        currVal = ((currVal*10)+root.val)%1003;

        if(root.left==null && root.right==null){
        
            totalSum = (totalSum+currVal)%1003;
            return ;
        }

        find(root.left,currVal);
        find(root.right,currVal);
    }
    public int sumNumbers(TreeNode A) {

        find(A,0);

        // int finAns = ans%1003;
        return totalSum;
    }
}
