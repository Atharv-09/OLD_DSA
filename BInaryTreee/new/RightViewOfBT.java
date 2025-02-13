
// TIME :O(n^2) 
// SPACE : O(n)
// using recursion 
// LEVEL ORDER TRSVERSAL is BREADTH FIRST TRAVERSAL of tree

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
    public static void main(String[] args) {
        Node root = createTree();

        System.out.print("Entered tree : ");
        printTree(root);

        System.out.print("\nRight View : ");
        rightView(root);
    }

    static void rightView(Node root){

        Queue<Node> qu = new LinkedList<Node>();

        qu.add(root);

        while(!qu.isEmpty()){

            int nodeCount = qu.size();
            Node newNode = null;
            while(nodeCount>0){
                newNode = qu.peek();
                qu.remove();

                if(newNode.left!=null){
                    qu.add(newNode.left);
                }
                if(newNode.right!=null){
                    qu.add(newNode.right);
                }
                nodeCount--;
            }

            System.out.print(newNode.data+" ");

        }

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

/*

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ javac RightViewOfBT.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ java BinaryTree
Enter data : 10
Enter left for 10 : Enter data : 20
Enter left for 20 : Enter data : 40
Enter left for 40 : Enter data : -1
Enter right for 40 : Enter data : -1
Enter right for 20 : Enter data : 50
Enter left for 50 : Enter data : -1
Enter right for 50 : Enter data : -1
Enter right for 10 : Enter data : 30
Enter left for 30 : Enter data : 60
Enter left for 60 : Enter data : 80
Enter left for 80 : Enter data : -1
Enter right for 80 : Enter data : -1
Enter right for 60 : Enter data : -1
Enter right for 30 : Enter data : 70
Enter left for 70 : Enter data : -1
Enter right for 70 : Enter data : -1
Entered tree : 40 20 50 10 80 60 30 70
Right View : 10 30 70 80
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BInaryTreee
$ java BinaryTree
Enter data : 10
Enter left for 10 : Enter data : 20
Enter left for 20 : Enter data : -1
Enter right for 20 : Enter data : 30
Enter left for 30 : Enter data : 40
Enter left for 40 : Enter data : -1
Enter right for 40 : Enter data : -1
Enter right for 30 : Enter data : 50
Enter left for 50 : Enter data : -1
Enter right for 50 : Enter data : -1
Enter right for 10 : Enter data : -1
Entered tree : 20 40 30 50 10
Right View : 10 20 30 50
*/