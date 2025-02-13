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

    static void findDuplicate(){

        Node temp = head;

        while(temp!=null){

            Node t = temp;
            while(t!=null && temp.data == t.data){
                
                t =t.next;

            }

            temp.next = t;
            temp =temp.next;
        }

  }

    static void printList(){

        Node t = head;
        while(t!=null){
            System.out.print(t.data+ " " );
            t = t.next;
        }
        System.out.println();
    }
 
    public static void main(String[] args){
        LinkedList ll = new LinkedList();


        ll.head = new Node(1);
        ll.head.next  =  new Node(1);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(3);
        ll.head.next.next.next.next = new Node(3);
        // ll.head.next.next.next.next.next = new Node(8); 

        findDuplicate();

        printList();
    }
}