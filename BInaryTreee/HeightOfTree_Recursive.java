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
    static int count=1;
    static Node create(){
        Node root = null;

        if(count==1){
            count++;
            System.out.print("Enter data : ");
        }
        int d = sc.nextInt();

        if(d==-1) return null;

        
        root = new Node(d);
        System.out.print("\nEnter left for " + d + " : ");
        root.left = create();
        
        System.out.print("\nEnter right for " + d + " : ");
        root.right = create();

        return root;
    }
    /* public int depth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }*/
    static int findHeight(Node root){
        int h;
        if(root==null) return 0;
        else{
            int lDep = findHeight(root.left);
            int rDep = findHeight(root.right);
            
            if(lDep>rDep){
                 h = lDep+1;
            }else{
                 h = rDep+1;
            }
        }

        return h;
    }


    public static void main(String[] args) {
        Node root = create();

        int hei = findHeight(root);
        System.out.println(hei);
    }
}