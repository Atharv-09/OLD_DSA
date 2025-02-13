

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
            Node root = createTree();

            System.out.print("Entered tree : ");
            printTree(root);

            long ans = rootToLeafPathSum(root,0);
            System.out.print("Root to leaf path sum : "+ ans);
        }

        static long rootToLeafPathSum(Node root,long currVal){

            if(root==null) return 0;

            currVal = (currVal*10)+root.data;

            // if we reached to the leaf node then return the currVal
            if(root.left==null && root.right==null) return currVal;
            // if we are at mid then direct return value of path addition 
            long lef  = rootToLeafPathSum(root.left, currVal);
            long rig = rootToLeafPathSum(root.right, currVal);

            return lef+rig;
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
 
/*Given a binary tree of N nodes, where every node value is a number. Find the sum of all the numbers which are formed from root to leaf paths.

Example 1:

Input :      
           6                               
         /   \                          
        3     5                      
      /   \     \
     2    5      4             
        /  \                        
       7    4  

Output: 13997

Explanation :
There are 4 leaves, hence 4 root to leaf paths:
Path                      Number
6->3->2                   632
6->3->5->7                6357
6->3->5->4                6354
6->5>4                    654   
Answer = 632 + 6357 + 6354 + 654 = 13997 
Example 2:

Input :    
           10                               
         /   \                          
        20     30                      
      /   \     
     40       60    

Output :  2630

Explanation:
Path                      Number
10->20->40                1240
10->20->60                1260
10->30                    130
1240+1260+130 = 2630*/

