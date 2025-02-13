

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

            verticalTraverse(root);
            //System.out.print("Vertical Traversal : ");

        }

        // we will use tree map instead of hash map
        // coz
        //The map is sorted according to the natural ordering of its keys

        static void getVerticalOrder(Node root,int hd,TreeMap<Integer,Vector<Integer>>){

            if(root==null) return;
            

        }

        static void verticalTraverse(Node root){

            TreeMap<Integer,Vector<Integer>> map  = new TreeMap<>();
            int hd = 0;
            getVerticalOrder(root,hd,map);

      
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
 