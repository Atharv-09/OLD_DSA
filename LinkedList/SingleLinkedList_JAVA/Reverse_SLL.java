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

    void printList(Node temp){
        // Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node reverse_SLL(Node h){
        
        Node prevNode = null;
        Node currNode = h;
        Node nextNode = null;

        while(currNode!=null){
            
            nextNode = currNode.next;
            currNode.next = prevNode;
            
            prevNode = currNode;
            currNode = nextNode;
        }

            head = prevNode;
            return head;
    }
    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        ll.head = new Node(2);
        ll.head.next = new Node(7);
        ll.head.next.next = new Node(8);
        ll.head.next.next.next = new Node(9);
        ll.head.next.next.next.next = new Node(10);

        ll.printList(head);
        
        head = ll.reverse_SLL(head);

        ll.printList(head);
    }
}


