
class Node{
    int data;
    Node left,right;
    Node(int d){
        data = d;
    }
}

class BinaryTree{
    static Node root;

    static Node LowestCommonAnc(Node root,int m,int n){

        if(root==null) return null;
        
        // if the node found as the root ndoe so directly return that 
        if(root.data == m || root.data == n) return root;

        Node leftLCA = LowestCommonAnc(root.left,m,n);
        Node rightLCA = LowestCommonAnc(root.right,m,n);

        // if the both left and rihgt node is not node we get the lca 
        if(leftLCA!=null && rightLCA!=null) return root;

        // if one substree is null and other subtree is not null so return that node whch is not null
        return (leftLCA!=null ? leftLCA : rightLCA);

    }
    public static void main(String[] args) {

        // root = new Node(1); 
        // root.left = new Node(2); 
        // root.right = new Node(3); 
        // root.left.left = new Node(7); 
        // root.left.right = new Node(6); 
        // root.right.left = new Node(5); 
        // root.right.right = new Node(4);
        
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(9);
        root.left.right=  new Node(4);
        root.right.left = new Node(7);
        
        Node ans = LowestCommonAnc(root,9,4);
        System.out.println(ans.data);
    }
}