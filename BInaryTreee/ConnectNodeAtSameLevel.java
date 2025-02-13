

    import java.util.*;

    class Node{
        int data;
        Node left,right,nextRight;
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

            System.out.print("Right View : ");
            connectNode(root);
        }
        /*RECURSIVE 
        void connectRecur(Node p) 
    { 
        // Base case 
        if (p == null) 
            return; 
  
        // Set the nextRight pointer for p's left child 
        if (p.left != null) 
            p.left.nextRight = p.right; 
  
        // Set the nextRight pointer for p's right child 
        // p->nextRight will be NULL if p is the right most child 
        // at its level 
        if (p.right != null) 
            p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null; 
  
        // Set nextRight for other nodes in pre order fashion 
        connectRecur(p.left); 
        connectRecur(p.right); 
    } 
        */
        static void connectNode(Node root){

            Queue<Node> qu = new LinkedList<Node>();
            qu.add(p);
            
            while(!qu.isEmpty()){
                
                int size = qu.size();
                Node prev=null,curr=null;
                while(size>0){
                    
                    curr = qu.peek();
                    qu.remove();
                    
                    curr.nextRight = prev; // prev.nextRight = curr; 
                    
                    if(curr.right!=null) qu.add(curr.right); // this 2 line reverse 
                    if(curr.left!=null) qu.add(curr.left);
                    
                    size--;
                    prev = curr; // this is not there 
                }
                // prev.nextRight = null; // curr.nextRight = null
                
            }
                        


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
 

    /*Given a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL

 

Example 1:

Input:
     3
   /  \
  1    2
Output:
3 1 2
1 3 2
Explanation:The connected tree is
        3 ------> NULL
     /    \
    1-----> 2 ------ NULL
Example 2:

Input:
      10
    /   \
   20   30
  /  \
 40  60
Output:
10 20 30 40 60
40 20 60 10 30
Explanation:The connected tree is
         10 ----------> NULL
       /     \
     20 ------> 30 -------> NULL
  /    \
 40 ----> 60 ----------> NULL*/