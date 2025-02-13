

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
        static Node root;
        public static void main(String[] args) {
            Node root = createTree();

            // root = new Node(1);
            // root.left = new Node(2);
            // root.right = new Node(3);

            System.out.print("Enter node1 data : ");
            int m = sc.nextInt();

            System.out.print("Enter node2 data: ");
            int n = sc.nextInt();
            
            System.out.print("Entered tree : ");
            printTree(root);

            int ans = findDistance(root,m,n);
            System.out.print("\nDistance between "+m +" and "+n+ " : "+ans);
        }
        static Node LCA(Node root,int m,int n){
        
                if(root==null) return root;
                if(root.data==m || root.data==n) return root;

                Node lef;
                lef = LCA(root.left, m, n);
                Node rig;
                rig = LCA(root.right, m, n);

                if(lef!=null && rig!=null) return root;
                if(lef==null && rig==null) return null;

                if(lef!=null) 
                    return LCA(root.left,m,n);                
                else
                    return LCA(root.right,m,n);

        }
        static int findLevel(Node lcn,int val,int level){
            
            if(lcn==null) return -1;
            if(lcn.data==val) return level;

            // firt find left 
            int lef;
            lef = findLevel(lcn.left,val,level+1);
            if(lef==-1)
                lef = findLevel(lcn.right, val, level+1);
            
            return lef;
        }
        static int findDistance(Node root,int m,int n){

            Node LowestCommonNode = LCA(root,m,n);
            
            int firstNodeLevel = findLevel(LowestCommonNode,m,0);
            int secNodeLevel = findLevel(LowestCommonNode,n,0);

            return(firstNodeLevel+secNodeLevel);
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
 