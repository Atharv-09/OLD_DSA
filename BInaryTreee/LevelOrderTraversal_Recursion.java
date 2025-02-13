// TIME :O(n^2) 
// SPACE : O(n)
// using recursion 

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

    static int findHeight(Node temp){

        int h;

        if(temp==null) return 0;
        else{
            int lHei = findHeight(temp.left);
            int rHei = findHeight(temp.right);

            if(lHei>rHei){
                h = 1 + lHei;
            }else{
                h = 1 + rHei;
            }
        }

        return h;

    }
    static void levelOrderTravese(Node root){

        int hei = findHeight(root);
        for(int i=1;i<=hei;i++){
            printGivenLevel(root,i);
        }
    }

    static void printGivenLevel(Node root,int level){

        if(root==null) return;

        if(level==1)
            System.out.print(root.data+" ");
        else if(level>1){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right,level-1);
        }

    }


    public static void main(String[] args) {
        Node root = createTree();

        printTree(root);
      
      
        System.out.println();


        levelOrderTravese(root);
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

/*$ java BinaryTree
Enter data : 10
Enter left for 10 : Enter data : 20
Enter left for 20 : Enter data : 40
Enter left for 40 : Enter data : -1
Enter right for 40 : Enter data : -1
Enter right for 20 : Enter data : 60
Enter left for 60 : Enter data : -1
Enter right for 60 : Enter data : -1
Enter right for 10 : Enter data : 30
Enter left for 30 : Enter data : -1
Enter right for 30 : Enter data : -1
40 20 60 10 30
10 20 30 40 60*/