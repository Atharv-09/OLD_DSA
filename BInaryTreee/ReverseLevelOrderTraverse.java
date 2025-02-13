

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

            System.out.print("Reverse Level order traversal : ");
            reverseLevelOrder(root);
        }

        static void reverseLevelOrder(Node root){

            if(root==null) return;
            Queue<Node> qu = new LinkedList<Node>();
            ArrayList<Integer> ans = new ArrayList<Integer>();
            qu.add(root);

            while(!qu.isEmpty()){

                int size = qu.size();

                while(size>0){

                    Node curr = qu.peek();
                    qu.remove();

                    ans.add(curr.data);

                    if(curr.right!=null) qu.add(curr.right);
                    if(curr.left!=null) qu.add(curr.left);
                    
                    size--;
                }
            }

            //ITERATION OF LIST 
            // Iterator i = ans.iterator();
            // while(i.hasNext()){
            //     System.out.print(i.next());
            // }

            //ITERATION OF LIST REVERSELY
            ListIterator<Integer> iter = ans.listIterator(ans.size());

            while (iter.hasPrevious()) {
                int s = iter.previous();
                System.out.print(s+" ");
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
 