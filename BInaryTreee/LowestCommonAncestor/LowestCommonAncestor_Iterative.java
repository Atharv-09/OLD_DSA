import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data = d;
    }
}

class BinaryTree{
    static Node root;
    static List<Integer> pat1 = new ArrayList<>();
    static List<Integer> pat2 = new ArrayList<>();
    // static void print(){
    //     for(int i=0;i<pat1.size();i++){
    //         System.out.print(pat1.get(i)+" ");
    //     }
    //     System.out.println();
    //     for(int i=0;i<pat2.size();i++){
    //         System.out.print(pat2.get(i)+" ");
    //     }
    // }
    static boolean findPath(Node root,int n,List<Integer> l){

        if(root==null) return true;

        l.add(root.data);
        if(root.data==n) return true;

        if(root.left!=null && findPath(root.left,n,l)){
            return true;
        }
        if(root.right!=null && findPath(root.right,n,l)){
            return true;
        }
        l.remove(l.size()-1);


        return false;
    }
    static int LowestCommonAnc(Node root,int m,int n){

        if(root==null) return 0;

        boolean first = findPath(root,m,pat1);
        boolean second = findPath(root,n,pat2);
        
        if(!first && !second) return 0;

        int i;
        for(i=0;i<pat1.size() && i<pat2.size();i++){
            if(!pat1.get(i).equals(pat2.get(i)))
                break;
        }
        return pat1.get(i-1);

    }
    public static void main(String[] args) {

        root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        
        int ans = LowestCommonAnc(root,2,6);
        System.out.println(ans);

        print();
    }
}

/*private int findLCAInternal(Node root, int n1, int n2) {
 
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
 
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
             
        // System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
 
        return path1.get(i-1);
    }
     
    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private boolean findPath(Node root, int n, List<Integer> path)
    {
        // base case
        if (root == null) {
            return false;
        }
         
        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.data);
 
        if (root.data == n) {
            return true;
        }
 
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
 
        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size()-1);
 
        return false;
    } */