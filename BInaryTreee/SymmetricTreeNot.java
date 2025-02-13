
class Node{
    int data;
    Node left,right;
    Node(int d){
        data = d;
    }
}

class BinaryTree{

    static Node root;
    static boolean foundL,foundR;
    static boolean findSymmetry(Node n1,Node n2){

        if(n1==null && n2==null) return true;

        if(n1!=null && n2!=null && n1.data==n2.data)
            return findSymmetry(n1.left, n2.right) && findSymmetry(n1.right, n2.left);
            
        
        // if((n1==null && n2!=null )|| (n1!=null && n2==null)) return false;
        // if(n1!=null) foundL = findSymmetry(n1.left,n2.right);
        // if(n2!=null) foundR = findSymmetry(n1.right,n2.left);

        // if(n1.data == n2.data) return foundL&&foundR;
        
        else return false;
    }
    public static void main(String[] args) {
        
        root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.left.right = new Node(21);
        root.right = new Node(1);
        root.right.right = new Node(2);
        /*
                5
               /  \
              1    1
             / \    \
            2   21   2  false 
        */
        boolean ans = findSymmetry(root,root);
        
        System.out.println(ans);
    }
}