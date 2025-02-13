

Node insert(Node root, int key)
{
    // Node curr = root;        
    // your code here
    if(root==null){
        return null;
    }
    if(root.right==null && key>root.data) 
            root.right = new Node(key);
    else if(root.left==null && key<root.data) 
            root.left = new Node(key);
    
    if(root.left!=null && key<root.data){
        root.left = insert(root.left,key);
    }else if(root.right!=null && key>root.data){
        root.right= insert(root.right,key);
    }
    
    
    return root;
    
}