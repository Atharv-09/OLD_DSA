

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

            System.out.print("Depth of tree : ");
            findDepth(root);
        }

        static int findDepth(Node root){

            if(root==null) return 0;
            // for leaf node if found then return directly 1
            if(root.left==null && root.right==null) return 1;

            // if left node if null go for right 
            if(root.left==null)
                return findDepth(root.right);
            // if right node is null go for left 
            if(root.right==null)
                return findDepth(root.left);

            // if nobody is null then simply go to left and right and find the min val 
            // and return that +! 

            return Math.min(findDepth(root.left),findDepth(root.right))+1;        

            


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
 