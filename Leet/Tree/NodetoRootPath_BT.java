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



        static boolean findNodeToRootpath(Node root,int node){

                if(root == null) return false;

                if(root.data==node){
                    System.out.print(root.data + " ");
                    return true; 
                } 

                boolean lef = findNodeToRootpath(root.left,node);
                if(lef){
                    System.out.print(root.data + " ");
                    return true; // if we get on the left sode then directly return true not go for right  
                }

                boolean rig = findNodeToRootpath(root.right,node);
                if(rig) {
                    System.out.print(root.data + " ");
                    return true; // if we get the right side then directlu return true 
                }
                return false;
        }
        public static void main(String[] args) {
            Node root = createTree();

            System.out.print("Entered tree : ");
            printTree(root);

            System.out.print("Enter source node : ");
            int node = sc.nextInt();
            
            if(!findNodeToRootpath(root,node))
                System.out.println("Node value = " + node + " node found ");
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
 