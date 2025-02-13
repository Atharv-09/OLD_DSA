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


        static ArrayList<Node> nodeToRoot = new ArrayList<>();
        static boolean findNodeToRootpath(Node root,int node){

                if(root == null) return false;

                if(root.data==node){
                    nodeToRoot.add(root);
                    return true; 
                } 

                boolean lef = findNodeToRootpath(root.left,node);
                if(lef){
                    nodeToRoot.add(root);
                    return true; // if we get on the left sode then directly return true not go for right  
                }

                boolean rig = findNodeToRootpath(root.right,node);
                if(rig) {
                    nodeToRoot.add(root);
                    return true; // if we get the right side then directlu return true 
                }
                return false;
        }

        static void printLevelDown(Node node,int downLen,Node blocker){

            if(node==null || downLen<0 || blocker==node) return;

            if(downLen == 0)
            System.out.println(node.data +" ");


            printLevelDown(node.left,downLen--,blocker);
            printLevelDown(node.right,downLen--,blocker);

        }
        static void printKNodesFar(Node root,int target,int k){

                // nodeToRoot = new ArrayList<>();

                findNodeToRootpath(root,target); // here we get the target node to root path
                // here we do from the target node we print k-i nodes downnodes 
                // then from above the target node we print next k-i nodes 
                // but we have to block the already vis node 
                for(int i=0;i<nodeToRoot.size();i++){
                    printLevelDown(nodeToRoot.get(i),k-i,i==0 ? null : nodeToRoot.get(i-1));
                    // System.out.println();
                }
        }
        public static void main(String[] args) {
            Node root = createTree();

            System.out.print("Entered tree : ");
            printTree(root);

            System.out.print("Enter target node : ");
            int node = sc.nextInt();

            System.out.print("Enter distance from target node : ");
            int dist = sc.nextInt();

            printKNodesFar(root,node,dist);
            

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
 