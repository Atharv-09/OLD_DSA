class Tree
{
    static int max_level = 0;
            ArrayList<Integer> ans = new ArrayList<Integer>();
   
    ArrayList<Integer> findLeft(Node root,int level){

        if(root==null) return null;
        
        if(level>max_level){
            ans.add(root.data);
            max_level = level;
        }
        
        findLeft(root.left,level+1);
        findLeft(root.right,level+1);
        
        return ans;
    }
   
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> arr = findLeft(root,1);
      
      return arr;
      
    }
}

//////////

class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        
        int countEle = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
    
            while(!qu.isEmpty()){
                
                int size  = qu.size();
                int i=1;
                for(;i<=size;i++){
                    Node newNode = qu.poll();

                    if(i==1)
                        ans.add(newNode.data);
                    
                    if(newNode.left!=null){
                        qu.add(newNode.left);
                    }
                    if(newNode.right!=null){
                        qu.add(newNode.right);
                    }
                }
            
                                    
            }   
    return ans;
      
    }
}


/// RUNNING 
class Tree
{
    int findHeight(Node root){
        int h;
        
        if(root==null) return 0;
        else{
            int lH = findHeight(root.left);
            int rH = findHeight(root.right);
            
            if(rH<lH){
                h = 1+lH;
            }else{
                h = 1+rH;
            }
            
        }
        
        return h;
    }
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      int height = findHeight(root);
      Queue<Node> qu = new LinkedList<>();
      ArrayList<Integer> ans = new ArrayList<Integer>();
      qu.add(root);
      qu.add(null);
      int count=0;
      int currCount=0;
      
      while(!qu.isEmpty()){
          
          if(currCount==height){
              break;
          }
          Node p = qu.peek(); // it remove and store value ni p
          qu.remove();
          if(count==0){ // as we get null so the count is 0 so next of null node is first node 
              ans.add(p.data);
              count++;
          }
          
          if(p!=null && p.left!=null)
            qu.add(p.left);
            
          if(p!=null && p.right!=null)
            qu.add(p.right);
          
          if(p==null){
                count=0;
                qu.add(null); 
                currCount++;
          }
        //   count++;
      }
      
      return ans;
    }
}