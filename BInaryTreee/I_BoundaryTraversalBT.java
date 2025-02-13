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
    ArrayList<Integer> leftBound = new ArrayList<Integer>();
    ArrayList<Integer> printLeftBoundary(Node node){
            
            if(node==null) return null;
            
            if(node.left!=null){
                leftBound.add(node.data);
                printLeftBoundary(node.left);
            }else if(node.right!=null){
                leftBound.add(node.data);
                printLeftBoundary(node.right);
            }
            
            return leftBound;
    }
    ArrayList<Integer> leave = new ArrayList<Integer>();
    ArrayList<Integer> printLeaf(Node node){
        
        
        
        if(node == null) return null;
        printLeaf(node.left);
        // printLeaf(node.right);
        if(node.left==null && node.right==null){
            leave.add(node.data);
        }
        printLeaf(node.right);
        return leave;
    }
     ArrayList<Integer> rightBound = new ArrayList<Integer>();
    ArrayList<Integer> printRightBoundary(Node node){
        
       
            if(node==null) return null;
            
            if(node.right!=null){
                printRightBoundary(node.right);
                rightBound.add(node.data);
            }else if(node.left!=null){
                leftBound.add(node.data);
                printRightBoundary(node.left);
            }
            
            return rightBound;
    }
	ArrayList <Integer> printBoundary(Node node)
	{
            ArrayList<Integer> leftA = new ArrayList<Integer>();
            leftA= printLeftBoundary(node);
            ArrayList<Integer> leafA = new ArrayList<Integer>();
            leafA = printLeaf(node);
            ArrayList<Integer> rightA = new ArrayList<Integer>();
            rightA = printRightBoundary(node);
            
            ArrayList<Integer> ans = new ArrayList<Integer>();
            for(int i=0;i<leftA.size();i++)
                ans.add(leftA.get(i));
            for(int i=0;i<leafA.size();i++)
                ans.add(leafA.get(i));
            for(int i=0;i<rightA.size();i++)
                ans.add(rightA.get(i));
                
            return ans;
	}
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(3);
        root.right= new Node(2);
        root.right.left = new Node(4);
        root.left.right = new Node(14);
        root.left.right = new Node(5);
        BinaryTree bt = new BinaryTree();       
        ArrayList<Integer> ans = bt.printBoundary(root);

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }   

}