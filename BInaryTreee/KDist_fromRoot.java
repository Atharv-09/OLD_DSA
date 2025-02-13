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
    static void Kdistance(Node root, int k)
     {
          // Your code her
        //   ArrayList<Integer> arr = new ArrayList<Integer>();
          
          Queue<Node> qu = new LinkedList<>();
          qu.add(root);
          
        //   if(k==0){
        //       arr.add(qu.peek());
        //       return arr;
        //   }
          int index = 0;
          while(!qu.isEmpty()){
              
              int size1 = qu.size();
              
              while(size1>0){
                  Node curr = qu.peek();
                  qu.remove();
                  
                  if(index==k){
                      System.out.print(curr.data+" ");
                  }
                  if(curr.left!=null) qu.add(curr.left);
                  if(curr.right!=null) qu.add(curr.right);
                  
                  size1--;
              }
              index++;
          }          
     }
    public static void main(String[] args) {
        root = new Node(3);
        root.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(3);
        // root.right.right = new Node(2);
        Kdistance(root,3);
    }
}