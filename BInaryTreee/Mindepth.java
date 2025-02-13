public class Solution {
    public int minDepth(TreeNode A) {

        if(A==null) return 1;
        
        if(A.left==null && A.right==null) return 1;
        if(A.left==null) return minDepth(A.right)+1;
        if(A.right==null) return minDepth(A.left)+1;
        
        int lef = minDepth(A.left);
        int rig = minDepth(A.right);

        if(lef<=rig)
            return lef+1;
        else
            return rig+1;
    }
}
