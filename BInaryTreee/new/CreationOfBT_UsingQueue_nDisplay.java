import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

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

        if(root==null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    static void insert(Node temp,int key){

        if(temp==null){
            root = new Node(key);
            return;
        }

        Queue<Node> qu = new LinkedList<Node>();
        qu.add(temp);


        // do level order transcersal unctil we find the empty space 

        while(!qu.isEmpty()){

            temp = qu.peek();
            qu.remove();

            if(temp.left==null){
                temp.left = new Node(key);
                break;
            }else{
                qu.add(temp.left);
            }

            if(temp.right==null){
                temp.right= new Node(key);
                break;
            }else{
                qu.add(temp.right);
            }
        }

    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.println("Before insrtion Inorder travesal : ");
        inorder(root);

        System.out.print("\nEnter data : ");
        int data = sc.nextInt();

        insert(root,data);

        System.out.println("\nAfter insertion of "+ data + " Inorder traversal : ");
        inorder(root);

    }
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ java BinaryTree
Before insrtion Inorder travesal :
7 11 10 15 9 8
Enter data : 12

After insertion of 12 Inorder traversal :
7 11 12 10 15 9 8
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$*/