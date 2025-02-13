
class BinaryTree{

    static class Node{
        int data;
        Node l,r = null;

        Node(int d){
            data=d;
            l=r=null;
        }
    }
    static void inorder(Node temp){

        if(temp==null) return;
        else{

            inorder(temp.l);
            System.out.print(temp.data+" ");
            inorder(temp.r);
        }

    }
    static Node root;
    public static void main(String[] args) {

        // BinaryTree bt = new BinaryTree();
        root = new Node(1);
        root.l = new Node(11);
        root.l.l = new Node(9);
        root.r = new Node(15);
        root.r.l = new Node(18);
        root.r.r = new Node(8);

        System.out.print("Inorder transversal(Left-root-right) : ");
        inorder(root);

        System.out.println();
    }   
}