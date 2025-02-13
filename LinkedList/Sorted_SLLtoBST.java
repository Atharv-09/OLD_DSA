import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class Tree{

    Tree left,right;
    int data;

    Tree(int data){
        this.data = data;
        left=right=null;
    }
}
class SplitLLInParts{

    static Node head;

    void push(int new_data){

        Node new_Node = new Node(new_data);

        new_Node.next = head;
        head = new_Node;
    }

    void printList(Node node){
        Node n = node;
        int count=0;
        while(n!=null){
            count++;
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
    /*USING BINARY SEARCH 
        
        TIME : O(n) -> for traversing 
        SPACE : O(n) -> for array 

    int findLen(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    int[] toArray(ListNode head){
        
        int len = findLen(head);
        int ans[] = new int[len];
        int index = 0;
        while(head!=null){
            ans[index++] = head.val;
            head = head.next;
        }
        
        return ans;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        int arr[] = toArray(head);
        
        int mid = arr.length/2;
        
        TreeNode root = new TreeNode(arr[mid]);
        root.left = findBST(arr,0,mid-1);
        root.right = findBST(arr,mid+1,arr.length-1);
        
        return root;
    }
    
    TreeNode findBST(int arr[],int l,int r){
        
        if(l<=r){
            int mid = (l+r)/2;
            
            TreeNode node = new TreeNode(arr[mid]);
            
            node.left = findBST(arr,l,mid-1);
            node.right = findBST(arr,mid+1,r);
            return node;
        }
        else{
            return null;
        }
    }
    */
    

    //TIME : Ologn
    //SPACE : o(1)
    Node findMiddlenode(Node temp){

        if(temp==null) return null;
        if(temp.next==null) return temp; // if there is no element or only single element  

        Node fast = temp;
        Node slow = temp;
        Node prev = null;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    Tree sortedSLLtoBST(Node head){

        if(head==null) return null;
        if(head.next==null) // if ther is single element 
            return new Tree(head.data);

        Node middleNode = findMiddlenode(head); // we get the midlle node 
        Node rightHalf = middleNode.next; // we get the right half root node 
        //INSTEAD OF HERE WE DO IN MIDDLE 
        // middleNode.next = null;//to brk the list from midddle
        Tree root = new Tree(middleNode.data); // create node  of tree 

        root.left = sortedSLLtoBST(head);
        root.right = sortedSLLtoBST(rightHalf);
        return root;

    }

    static void printTree(Tree ans){

       // Queue<Tree> qu = new LinkedList<>();
        List<Tree> qu = new ArrayList<>();
        qu.add(ans);

        while(!qu.isEmpty()){
            ans = qu.get(0);
            qu.remove(0);

            System.out.print(ans.data + " ");


            if(ans.left!=null)
                qu.add(ans.left);
            if(ans.right!=null)
                qu.add(ans.right);
             // if(ans.left==null) System.out.print(" null ");
            // if(ans.right==null) System.out.print(" null ");
        }

    }
    public static void main(String[] args){
        SplitLLInParts ll = new SplitLLInParts();

        // ll.push(10);
        ll.push(9);    
        // ll.push(8);
        // ll.push(7);
        // ll.push(6);
        ll.push(5);
        ll.push(0);
        ll.push(-3);
        // ll.push(2);
        ll.push(-10);
        // ll.push(11);
        
        // ll.printList(head);

        Tree ans = ll.sortedSLLtoBST(head);

        printTree(ans);
      
    }

}

/*

TINE : O(n)
SPACE : O(1)

ListNode headOrig = null;
    public TreeNode sortedUtil(int n) {
        
        if(n <= 0) return null;
        
        TreeNode left = sortedUtil(n/2);
        TreeNode root = new TreeNode(headOrig.val, null, null);
        root.left = left;
        headOrig = headOrig.next;
        root.right = sortedUtil(n - (n/2) -1);
        return root;
        
        
    }
    
    public TreeNode sortedOpti(ListNode head) {
        
        int n =0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }
       // System.out.println("  length is " + n);
        headOrig = head;
        return sortedUtil( n);
        
    }
*/