/*Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

Example 1:

Input:
T:      1          S:   3
      /   \            /
     2     3          4
   /  \    /
  N    N  4
Output: 1 
Explanation: S is present in T

Example 2:

Input:
T:      26         S:   26
       /   \           /  \
     10     N        10    N
   /    \           /  \
   20    30        20  30
  /  \            /  \
 40   60         40  60
Output: 1 
Explanation: 
S and T are both same. Hence, 
it can be said that S is a subtree 
of T. */


// time : O(n);
// first find the inorder of given tree
// then inorder of subtree given
// and storre them into array 
// if the inorder of subtree is an subarray of given tree
// then check for preorder of subtree is an subarray of given tree return true if both satiesfies
// if inorder of sub id not subrarrya of main tree then return false don't go for preorder 
// if sub inorder is subarray of main then go for preorder check  

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
    static int count = 0;    
    static int nodesCount(Node temp){

        if(temp==null) return 0;
        count++;
        if(temp.left!=null)
             nodesCount(temp.left);
        if(temp.right!=null)
            nodesCount(temp.right);
        return count;

    }
    public static void main(String[] args) {
        
        Node root1  = createTree();
        Node root2 = createTree() ;
        System.out.print("Entered tree : ");
        printTree(root1);
    
        int mainTNodes = nodesCount(root1); // 
        count=0;
         int subTNodes = nodesCount(root2); // 
        System.out.println("\n" + mainTNodes + " " + subTNodes);

        BinaryTree bt = new BinaryTree();
        boolean ans = bt.SubtreeOrNot(root1,mainTNodes,root2,subTNodes);
        // print();
        if(ans) System.out.println("It is subtree");
        else System.out.println("It is not subtree");
    }

    String arrayToString(int arr[]){
        String s = "";

        for(int i=0;i<arr.length;i++){
            s = s + arr[i];
        }
        return s;
    }

     boolean SubtreeOrNot(Node t1,int mainNodeCount,Node t2,int subNodeCount){

        
        if(t1==null) return false;
        if(t2==null) return true;

        int mainArrIn[] = new int[mainNodeCount];
        InOrderFillArr(t1,mainArrIn,0);
        
        int subArrIn[] = new int[subNodeCount];
        InOrderFillArr(t2,subArrIn,0);


        String mainInorderStr = arrayToString(mainArrIn);
        System.out.println(mainInorderStr);
        String subInorderStr  = arrayToString(subArrIn);
        System.out.println(subInorderStr);
        if(!mainInorderStr.contains(subInorderStr)){
            return false; // inorder string not matching
        }

        // preorder
        int mainArrPre[] = new int[mainNodeCount];
        PreOrderFillArr(t1,mainArrIn,0);

        int subArrPre[] = new int[subNodeCount];
        PreOrderFillArr(t2,subArrIn,0);  

        String mainPreorderStr = arrayToString(mainArrPre);
        String subPreorderStr  = arrayToString(subArrPre);

        return mainPreorderStr.contains(subPreorderStr);
            // return false; // inorder string not matching
        // }   

        // return true;
        
    }
     void InOrderFillArr(Node temp,int arr[],int k){

        if(temp==null){
            return;
        }

        InOrderFillArr(temp.left,arr,k);
        arr[k] = temp.data;
        k++;
        InOrderFillArr(temp.right, arr,k);

    }
     void PreOrderFillArr(Node temp,int arr[],int k){

        if(temp==null){
            return;
        }

        arr[k] = temp.data;
        k++;    
        PreOrderFillArr(temp.left, arr,k);
        PreOrderFillArr(temp.right, arr,k);

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


/* static void print(){

        for(int i=0;i<fullIN.length;i++){
            if(fullIN[i]!=101)
                System.out.print(fullIN[i]+" ");
           
        }
        System.out.println();
        for(int i=0;i<subIN.length;i++){
            if(subIN[i]!=101)
                System.out.print(subIN[i]+" ");   
        }
    } */