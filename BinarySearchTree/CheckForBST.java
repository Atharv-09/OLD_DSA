

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

            String ans = CheckBST(root) ? "Given tree is BST " : " Given tree is not BST";
            
            System.out.println(ans);

        }

        static  boolean check(Node root,int max,int min){

            if(root==null) return true;
            
            if(root.data<min || root.data>max) return false;

            boolean lef = check(root.left,root.data-1,min);
            boolean rig = check(root.right,max,root.data+1);

            return lef&&rig;
        }
        static boolean CheckBST(Node root){

                return check(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
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


//  Returns true if a binary tree is a binary search tree 
// int isBST(struct node* node)  
// {  
//   if (node == NULL)  
//     return 1;  
      
//   /* false if the max of the left is > than us */
//   if (node->left!=NULL && maxValue(node->left) > node->data)  
//     return 0;  
      
//   /* false if the min of the right is <= than us */
//   if (node->right!=NULL && minValue(node->right) < node->data)  
//     return 0;  
    
//   /* false if, recursively, the left or right is not a BST */
//   if (!isBST(node->left) || !isBST(node->right))  
//     return 0;  
      
//   /* passing all that, it's a BST */
//   return 1;  
// }   */