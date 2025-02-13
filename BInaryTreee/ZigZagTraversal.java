import java.util.*;
class Node{
    Node left,right;
    int data;
    Node(int d){
        data = d;

    }
}
/*
public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

          
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(A);
        Stack<Integer> st = new Stack<>();
        // boolean l2r = true;
        int k = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        while(!qu.isEmpty()){

                int size = qu.size();
                
                while(size>0){
                        
                        TreeNode cur = qu.poll();
                        
                        if(k%2!=0){ // rev 
                                st.push(cur.val);
                        }else{
                            ar.add(cur.val);
                        }

                        if(cur.left!=null) qu.add(cur.left);
                        if(cur.right!=null) qu.add(cur.right);

                    size--;
                }

                if(k%2!=0){
                    while(!st.isEmpty()){
                        int ele = st.pop();
                        ar.add(ele);
                    }
                }
                ans.add(ar);
                ar = new ArrayList<>();
                k++;
                         
        }
        return ans;
    }
*/


class BinaryTree{
    static Node root;
    static void zigZagTraversal(Node root){
        Stack<Node> currL = new Stack<>();
        Stack<Node> nextL = new Stack<>();

        currL.push(root);
        boolean leftTOright = true;

        while(!currL.isEmpty()){

            Node temp = currL.peek();
            currL.pop();
            System.out.print(temp.data+" ");
            
            if(leftTOright){
                if(temp.left!=null) nextL.push(temp.left);
                if(temp.right!=null) nextL.push(temp.right); 
            }else{
                if(temp.right!=null) nextL.push(temp.right);
                if(temp.left!=null) nextL.push(temp.left);
            }

            if(currL.isEmpty()){
                leftTOright = !leftTOright;
                Stack<Node> aisehe = currL;
                currL = nextL;
                nextL = aisehe;
            }
        }
    }
    public static void main(String[] args) {

        root = new Node(2);
        root.left=  new Node(1);
        root.right = new Node(3);

        zigZagTraversal(root);
    }
}



// ArrayList<Integer> zigZagTraversal(Node root)
// 	{
// 	    ArrayList<Integer> ans = new ArrayList<Integer>();
// 	    //Add your code here.
// 	   // Queue<Node> qu = new LinkedList<Node>();
// 	    Stack<Node> st = new Stack<Node>();
	    
// 	   // st.push(root);
	    // int currLevel=0;
	//    while(!qu.isEmpty() || !st.empty()){
	        
	   //     int currSize = 0;
	   //     if(st.empty())
	   //         currSize = qu.size();
	   //     else 
	   //         currSize = st.size();
	            
	   //     while(currSize>0){
	           
	           
	   //        Node temp = null;
	   //        if(qu.isEmpty()){
	   //            temp = st.peek();
	   //            st.pop();
	                
	   //        }else{
	   //            temp = qu.peek();
	   //             qu.remove();
	   //        }
	           
	   
	   //        ans.add(temp.data);
	           
	   //        if(temp.left!=null){
	   //            if(currLevel%2 == 0)
	   //             qu.add(temp.left);
	   //            else
	   //             st.push(temp.left);
	   //        }
	   //        if(temp.right!=null){
	   //            if(currLevel%2==0)
	   //             qu.add(temp.right);
	   //            else
	   //             st.push(temp.right);
	   //        }
	            
	   //         currSize--;   
	   //     }
	        

	   //     currLevel++;
	   // }
	//    return ans;    
	// }


    /*ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	   
	    Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        
        st1.push(root);
        
        while(!st1.empty() || !st2.empty()){
            
            int curSize = 0;
            if(!st1.empty()) curSize = st1.size();
            else curSize = st2.size();
            
            while(curSize>0){
                Node temp = null;
                if(!st1.empty()){
                    temp = st1.peek();
                    st1.pop();
                }else{
                    temp = st2.peek();
                    st2.pop();
                }
                
                ans.add(temp.data);
                
                if(st2.empty()){
                    if(temp.left!=null){
                        st2.push(temp.left);
                    }
                    
                    if(temp.right!=null){
                        st2.push(temp.right);
                    }
                }else{
                    if(temp.left!=null){
                        st1.push(temp.left);
                    }
                    
                    if(temp.right!=null){
                        st1.push(temp.right);
                    }
                }
                curSize--;
            }
            
            
            
        }
	  
	   return ans;    
	} */