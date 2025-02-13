import java.util.*;

ArrayList<Integer> noSibling(Node node)
    {
        // code here
        Queue<Node> q = new LinkedList<Node>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        
        q.add(node);
        // int count=1;
        
        while(!q.isEmpty()){
            
            Node curr = q.peek();
            q.remove();
    
            if(curr.left!=null && curr.right==null){
                ar.add(curr.left.data);
            }else if(curr.left==null && curr.right!=null){
                ar.add(curr.right.data);
            }
            if(curr.left!=null)    q.add(curr.left);
            if(curr.right!=null)   q.add(curr.right);
        }
        Collections.sort(ar);
        if(ar.isEmpty()){
            ar.add(-1);
        }
        return ar;
    }