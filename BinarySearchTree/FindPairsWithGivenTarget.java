

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

            System.out.print("\nEnter target value : " );
            int tar = sc.nextInt();

            System.out.print("\nPairs are :\n ");
            isPairPresent(root,tar);
        }

        static ArrayList<Integer> arr = new ArrayList<>();
    
        static void inorder(Node root){
            if(root==null) return;
            
            inorder(root.left);
            arr.add(root.data);
            inorder(root.right);
            
        }
        static void findPair(ArrayList<Integer> arr,int l,int r,int target){
            
            while(l<=r){
                if(arr.get(l)+arr.get(r) == target){
                    System.out.println(arr.get(l)+ " " + arr.get(r)); // just if find present or return simply return true from herer
                    l++;
                    r--;
                }else if(arr.get(l)+arr.get(r) > target){
                    r--;   
                }else{
                    l++;
                }
            }
            
        }
        //TIME : O(n);
        //SPACE : O(n);
        public static void isPairPresent(Node root, int target)
        {

            // as here after inordering bst we get in sorted order
            inorder(root);
        // two pointer algo            
            int l = 0;
            int r = arr.size()-1;
            
            findPair(arr,l,r,target);
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
 