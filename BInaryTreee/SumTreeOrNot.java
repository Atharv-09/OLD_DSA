

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

            int ans = issumTreeOrNot(root);
            if(ans==1){
                System.out.println("Tree is sumtree");
            }else{
                System.out.println("Tree is not sumtree");
            }
        }
        /*
        static int sum(Node node){
            if(node==null) return 0;

            return(sum(node.left) + node.data + sum(node.right));
        }
        static int issumTreeOrNot(Node root){

            if(root==null) return 1;
            if(root.left==null && root.right==null) return 1;
          
            int lef,rig;

            // sum of its subtrees left and right 
            lef = sum(root.left);
            rig = sum(root.right);
            
            
            if((root.data == lef+rig) && issumTreeOrNot(root.left)!=0 && issumTreeOrNot(root.right)!=0){
                return 1;
            }else{
                return 0;
            }
        }*/
        static int issumTreeOrNot(Node root){

            if(root==null) return 1;
            if(root.left==null && root.right==null) return 1;

            int lef = issumTreeOrNot(root.left);
            if(root.left!=null){
                return root.data;
            }

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
 