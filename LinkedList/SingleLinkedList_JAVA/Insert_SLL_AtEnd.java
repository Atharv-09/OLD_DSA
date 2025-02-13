class LinkedList{

    Node head;

    static class Node{
        Node next;
        int data;
        Node(int d){
            data = d;
            next = null;
        }
    }

    void printList(){
        Node n = head;

        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    void pushAtEnd(int new_data){

        Node new_node = new Node(new_data);

        if(head == null){
            head = new_node;
            return;
        }

        new_node.next = null;
    
        Node last = head;

        while(last.next!=null){
            last = last.next;
        }

        last.next = new_node;
        return;

    }
    public static void main(String[] args){
        
        LinkedList ll = new LinkedList();
        ll.head = new Node(11);
        Node s = new Node(22);
        Node t = new Node(33);


        ll.head.next = s;
        s.next = t;

        ll.printList();

        ll.pushAtEnd(44);

        ll.printList();
    }
}