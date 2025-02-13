

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
        static int ans = -1;
        public static void main(String[] args) {
            Node root = createTree();

            System.out.print("Entered tree : ");
            printTree(root);

            deepestNode(root,0);
            System.out.print("\nDeepest Node : " + ans);
        }
        static int maxLevel = -1;
        static void deepestNode(Node root,int level){

            if(root==null) return;

            if(root!=null){
                deepestNode(root.left, level++);
                if(level>maxLevel){
                    ans = root.data;
                    maxLevel = level;
                }
                deepestNode(root.right, level);
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
 