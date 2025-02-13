// import java.util.Queue;
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
    // static ArrayList<ArrayList<Integer>> levelOrder(Node node) 
    static void levelOrder(Node node)
    {
        // Your code here
        if(node==null) return;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(node);
    
        while(!qu.isEmpty()){
            
            int currSize = qu.size(); 
            
            arr.clear();
            

            while(currSize>0){
                
                Node currNode =qu.peek();
                // if(currNode==null) qu.remove();
                arr.add(currNode.data);
                System.out.print(currNode.data+" ");
                qu.remove();    
                
                if(currNode.left!=null) qu.add(currNode.left);
                if(currNode.right!=null) qu.add(currNode.right);
                
                currSize--;
             } 
            //  ans.add(arr);  
            System.out.println();
        }
        // for(int i=0;i<ans.size();i++){
        //     for(int j=0;j<ans.get(i).size();j++){
        //         System.out.print(ans.get(i).get(j) +" ");
        //     }
        //     System.out.println();
        // }
        
      
    }
    public static void main(String[] args) {
        
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(7); 
        root.left.right = new Node(6); 
        root.right.left = new Node(5); 
        root.right.right = new Node(4);

        levelOrder(root);
        
    }
}

/*vector<vector<int>> levelOrder(Node* node)
{
  //Your code here
        vector<vector<int>> ans;
        vector<int> vec;
        
        queue<Node*> qu;
        qu.push(node);
        
        while(!qu.empty()){
            vec.clear();
            int size = qu.size();
            while(size>0){
                Node *curr = qu.front(); 
                qu.pop();
                
                vec.push_back(curr->data);
                if(curr->left) qu.push(curr->left);
                if(curr->right) qu.push(curr->right);
                size--;
                
            }
            
            ans.push_back(vec);
        }
        
        return ans;
} */