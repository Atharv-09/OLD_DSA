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


    void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " " );
            temp = temp.next;
        }
        System.out.println();
    }
    //Swapping only data not whole node
    void swapNodesInPair(){

            Node temp = head;
           while(temp!=null && temp.next!=null){
            int s = temp.data;
            temp.data = temp.next.data;
            temp.next.data = s;

            temp = temp.next.next;
        }   

        
    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();


        ll.head = new Node(1);
        ll.head.next  =  new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = new Node(5);


        ll.printList();
        ll.swapNodesInPair();
        ll.printList();
    }
}