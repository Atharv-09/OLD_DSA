/*USING QUEUE
static void mirror(Node root) 
{ 
    if (root == null) 
        return; 
  
    Queue<Node> q = new LinkedList<>(); 
    q.add(root); 
  
    // Do BFS. While doing BFS, keep swapping 
    // left and right children 
    while (q.size() > 0) 
    { 
        // pop top node from queue 
        Node curr = q.peek(); 
        q.remove(); 
  
        // swap left child with right child 
        Node temp = curr.left; 
        curr.left = curr.right; 
        curr.right = temp;; 
  
        // push left and right children 
        if (curr.left != null) 
            q.add(curr.left); 
        if (curr.right != null) 
            q.add(curr.right); 
    } 
} */

class Node{
    int data;   
    Node left,right;

    Node(int d){
        data = d;
    }
}

class BinaryTree{
    static Node root;
    static void showTree(Node temp){
        
            if(temp==null) return;

            showTree(temp.left);
            System.out.print(temp.data+" ");
            showTree(temp.right);

    }

    static Node mirrorTree(Node node){

        if(node==null) return null;

        Node leftSubT = mirrorTree(node.left);
        Node rightSubT = mirrorTree(node.right);

        node.left = rightSubT;
        node.right = leftSubT;

        return node;
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(3);
        root.right= new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.print("Binary tree : ");
        showTree(root);

        System.out.print("\nIts mirror tree : ");
        Node ans = mirrorTree(root);    
        showTree(ans);
    }
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ javac MirrorTree.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ java BinaryTree
Binary tree : 3 1 4 2 5
Its mirror tree : 5 2 4 1 3*/




/*Given a Binary Tree, convert it into its mirror.
MirrorTree1            

Example 1:

Input:
      1
    /  \
   2    3
Output: 2 1 3
Explanation: The tree is
   1    (mirror)  1
 /  \    =>      /  \
3    2          2    3
The inorder of mirror is 2 1 3
Example 2:

Input:
      10
     /  \
    20   30
   /  \
  40  60
Output: 30 10 60 20 40
Explanation: The tree is
      10               10
    /    \  (mirror) /    \
   20    30    =>   30    20
  /  \                   /   \
 40  60                 60   40
The inroder traversal of mirror is
30 10 60 20 40. */