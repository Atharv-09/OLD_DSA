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

    static void inorder(Node root){
        Stack<Node> st = new Stack<Node>();
        
        Node curr = root;
        while(curr!=null || st.size()>0)
        {
            // curr = st.pop();

            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            System.out.print(curr.data+" ");
            curr=  curr.right;
        }
    }
    public static void main(String[] args) {
        
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        inorder(root);
    }
}