

    import java.util.*;

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
        }
    }

    class MaxVal{
        int val = 0;
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
            BinaryTree bt = new BinaryTree();
            Node root = createTree();

            System.out.print("Entered tree : ");
            printTree(root);

            int ans = bt.maxPathSumBetnLeaf(root);
            System.out.print("\nMax Path sum between leaf nodes : " + ans);
        }
        int maxPath(Node root,MaxVal obj){

            if(root==null) return 0;
            // for the leaf node
            // directly retiurn root's data 
            if(root.left==null && root.right==null) return root.data;

            int lef = maxPath(root.left, obj);
            int rig = maxPath(root.right,obj);

            // if we are not on thr leaf node 
            // then firt chanfe the maxVal to the all the threee node sum root left right data sum 
            // then return max betn left and right + root.data 
            if(root.left!=null && root.right!=null){

                obj.val = Math.max((lef+rig+root.data),obj.val);
                return Math.max(lef,rig)+root.data;

            }
            // if any of the left/right is null then return the not null left/right data and root data 

            if(root.left!=null)
                return root.data+lef;
            else
                return root.data+rig;

        }
        int maxPathSumBetnLeaf(Node root){

            MaxVal obj = new MaxVal();
            obj.val = Integer.MIN_VALUE;
            maxPath(root,obj); // we are passing the ref of class maxVa

            return obj.val;

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
 
    /*$ java BinaryTree
Enter data : 3
Enter left for 3 : Enter data : 4
Enter left for 4 : Enter data : -10
Enter left for -10 : Enter data : -1
Enter right for -10 : Enter data : -1
Enter right for 4 : Enter data : 4
Enter left for 4 : Enter data : -1
Enter right for 4 : Enter data : -1
Enter right for 3 : Enter data : 5
Enter left for 5 : Enter data : -1
Enter right for 5 : Enter data : -1
Entered tree : -10 4 4 3 5
Max Path sum between leaf nodes : 16*/

/*Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.


Example 1:

Input :      
           3                               
         /    \                          
       4       5                     
      /  \      
    -10   4                          
Output: 16
Explanation :
Maximum Sum lies between leaf node 4 and 5.
4 + 4 + 3 + 5 = 16.
Example 2:

Input :    
            -15                               
         /      \                          
        5         6                      
      /  \       / \
    -8    1     3   9
   /  \              \
  2   -3              0
                     / \
                    4  -1
                       /
                     10  
Output :  27
Explanation:
The maximum possible sum from one leaf node 
to another is (3 + 6 + 9 + 0 + -1 + 10 = 27) */