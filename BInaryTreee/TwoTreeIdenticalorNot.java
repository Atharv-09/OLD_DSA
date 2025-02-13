import java.util.*;
boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    Queue<Node> q1 = new LinkedList<>();
	    Queue<Node> q2 = new LinkedList<>();
	    q1.add(root1);
	    q2.add(root2);
	    boolean found=true;
	    
	    
	    while(!q1.isEmpty() && !q2.isEmpty()){
	        
	        Node curr1 = q1.peek();
            Node curr2 = q2.peek();
            q1.remove();
            q2.remove();
            if(curr1.data!=curr2.data){
                found=false;
                break;
            }
            
	        if(curr1.left!=null) q1.add(curr1.left);
	        if(curr1.right!=null) q1.add(curr1.right);
	        if(curr2.left!=null) q2.add(curr2.left);
	        if(curr2.right!=null) q2.add(curr2.right);
	        if( (q1.isEmpty() && !q2.isEmpty()) || (!q1.isEmpty() && q2.isEmpty())) found = false;
	        
	    }
	    
	    if(found==false) return false;
	    else return true;
	}

    // RECURSIVE 
    boolean identicalTrees(Node a, Node b) 
    {
        /*1. both empty */
        if (a == null && b == null)
            return true;
            
        /* 2. both non-empty -> compare them */
        if (a != null && b != null) 
            return (a.data == b.data
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right));
 
        /* 3. one empty, one not -> false */
        return false;
    }