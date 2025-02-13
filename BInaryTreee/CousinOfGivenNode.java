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
    
    class Pair{

        TreeNode curr;
        TreeNode parent;
        int level;

        Pair(TreeNode cur,TreeNode par,int lev){
            curr =cur;
            parent = par;
            level = lev;
        }
    }
    int findLevel(TreeNode root,int key,int level){

        if(root==null) return 0;
        if(root.val == key) return level;

        int downlevel = findLevel(root.left,key,level+1);
        if(downlevel!=0) return downlevel;

        return findLevel(root.right,key,level+1);
    }
    
    ArrayList<Integer> ans = new ArrayList<>();

    TreeNode findParent(TreeNode root,int B){

            if(root.left==null || root.right==null) return null;

            if(root.left.val==B || root.right.val==B){
                return root;
            }
            findParent(root.left,B);
            findParent(root.right,B);
            
            return root;            
    }
   
    public ArrayList<Integer> solve(TreeNode A, int B) {

        if(A.val==B) return new ArrayList<>();


        int levelOfB = findLevel(A,B,1);

        TreeNode ParentOfB = findParent(A,B);

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(A,A,1));

        int level = 2;
        while(!qu.isEmpty()){

            
            int size=qu.size();

            while(size>0){
                Pair p = qu.poll();

                if(p.parent.val!=ParentOfB.val && p.level == levelOfB){

                    // if(){
                         ans.add(p.curr.val);   
                    // }
                }
                if(p.curr.left!=null){
                    qu.add(new Pair(p.curr.left,p.curr,level));
                }

                if(p.curr.right!=null){
                    qu.add(new Pair(p.curr.right,p.curr,level));
                }
                size--;
            }

            level++;
        }

        // printLevel(A,level,B);
        return ans;
    }
}



/*
 void printLevel(TreeNode root,int level,int key){

        if(root==null || level<2) return;

        if(level==2){
            
            if(root.left.val == key || root.right.val==key) return;

            if(root.left!=null)
                ans.add(root.left.val);
            if(root.right!=null)
                ans.add(root.right.val);
        }
        else if(level>2){
            printLevel(root.left,level-1,key);
            printLevel(root.right,level-1,key);
        }
        
    }
*/