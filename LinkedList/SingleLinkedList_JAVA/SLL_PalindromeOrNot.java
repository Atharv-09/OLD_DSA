class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class LinkedList{

    static Node head;
    static int size =0;
    static Node reverseLinked(Node n){
        
        Node prevNode = null;
        Node nextNode = null;
        Node currNode = n;
        
        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            
            prevNode = currNode;
            currNode = nextNode;
            
            size++;
        }
        // System.out.println(size);
        return prevNode;
    }
    // Function to check if linked list is palindrome
    static boolean isPalindrome() 
    {
        Node temp = head;
        // Node temp1 = head;
        Node revList = reverseLinked(temp);
        int c = 0;
        temp = head;
        while(temp!=null && revList!=null){
            System.out.println(temp.data+" "+revList.data);
            if(temp.data == revList.data){
                c++;
            }
            // c++;
            temp = temp.next;
            revList = revList.next;
        }
        // System.out.println(c);
        if(c==size){
            return true;
        }else{
            return false;
        }
    }    
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();

        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(1);

        boolean ans = isPalindrome();

        System.out.println(ans);
    }
}