class Node{
    int data;
    Node left,right;

    Node(int d){
        data =d;
    }
}
class BST{

    static Node root;
    static void printNearNodes(Node root, int low, int high)
	{
      // code here.
      
            if(root==null) return ;
            
            if(low<root.data){
                printNearNodes(root.left,low,high);
            }
            if(root.data>=low && root.data<=high){
                ans.add(root.data);
            }
            if(high>root.data){
                printNearNodes(root.right,low,high);
            }
            
            return ans;
            
            // if(root.data<high && root.data>=low){// both
            //     lef = printNearNodes(root.left,low,high);
            //     rig = printNearNodes(root.right,low,high);
            // }
            // if(root.data>high) // all on left
            // root.data < low // all on right 
            // if(root.left!=null && )
        }

        public static void main(String[] args) {
            printNearNodes(root,1,5);
        }

}

/* 
        17  
     /    \
    4     18
  /   \
 2     9 
l = 4, h = 24
Output: 4 9 17 18 
Example 2:

Input:
       16
     /    \
    7     20
  /   \
 1    10
l = 13, h = 23
Output: 16 20  */