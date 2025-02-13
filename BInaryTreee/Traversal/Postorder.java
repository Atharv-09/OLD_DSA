

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

            System.out.print("PostOrder Iteratively : ");
            postOrder(root);
        }

        static void postOrder(Node root){

            Node curr = root;
            Stack<Node> st = new Stack<Node>();
            Stack<Node> st1 = new Stack<Node>();
            st.push(curr);

            while(!st.isEmpty()){

                Node temp = st.pop();
                st1.push(temp);
                
                if(temp.left!=null) st.push(temp.left);
                if(temp.right!=null) st.push(temp.right);
            }

            while(!st1.isEmpty()){
                Node t = st1.pop();

                System.out.print(t.data+" ");
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
 
    /*Enter data : 1
Enter left for 1 : Enter data : 2
Enter left for 2 : Enter data : 4
Enter left for 4 : Enter data : -1
Enter right for 4 : Enter data : -1Enter right for 2 : Enter data : -1
Enter right for 1 : Enter data : 3
Enter left for 3 : Enter data : 6
Enter left for 6 : Enter data : -1
Enter right for 6 : Enter data : -1
Enter right for 3 : Enter data : 8
Enter left for 8 : Enter data : -1
Enter right for 8 : Enter data : -1
Entered tree : 4 2 1 6 3 8 PostOrder Iteratively : 4 2 6 8 3 1 */