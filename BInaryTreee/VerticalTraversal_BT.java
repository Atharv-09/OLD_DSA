

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

    
        static void verticalTraverse(Node root){

            HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();

            // using level order traversal and hashmap 

            Queue<Node> qu = new LinkedList<Node>();
            qu.add(root);

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(root.data);
                    
            map.put(0,ans);
            ans.clear(); 
            
            int hd=0;
            while(!qu.isEmpty()){

                // while(size>0){
                    Node temp = qu.poll();
 
                    if(temp.left!=null){
                        qu.add(temp.left);
                        ans.add(temp.data);
                        hd = hd-1;
                        map.put(hd,ans);
                        ans.clear();
                    }

                    if(temp.right!=null){
                        qu.add(temp.right);
                        ans.add(temp.data);
                        hd = hd+1;
                        map.put(hd,ans);
                        ans.clear();
                    }
                // }

            } 

            for (Map.Entry<Integer,ArrayList<Integer>> e : map.entrySet()) 
            System.out.println("Key: " + e.getKey() 
                               + " Value: " + e.getValue()); 

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
 