

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

            boolean ans = mirrorOrNot(root,root);
            System.out.print("Tree is mirror tree : " + ans);
        }

        static boolean mirrorOrNot(Node root,Node root1){

            if(root==null && root1==null) return true;
            if(root==null || root1==null) return false;


            return(root.data==root1.data && mirrorOrNot(root.left, root1.right) && mirrorOrNot(root.right, root1.left) );          
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
 