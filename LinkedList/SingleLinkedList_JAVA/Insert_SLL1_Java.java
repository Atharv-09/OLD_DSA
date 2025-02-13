
class LinkedList{
    
    Node head;

    static class Node{
        int data;
        Node next;
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

    void pushAtFront(int new_data){
        
        Node new_node = new Node(new_data);
        
        new_node.next = head;

        head = new_node;
    }

    Node pushAtMiddle(int new_data,Node prev_node){
        Node new_node;

        if(prev_node.next == null){
            System.out.println("The given previous node cannot be null");
            return prev_node;
        }else{
        
            new_node = new Node(new_data);
            new_node.next = prev_node.next;
            prev_node.next = new_node;
        }
        return new_node;

    }
    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        ll.head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        ll.head.next = second;
        second.next = third;

        ll.printList();
        
        ll.pushAtFront(40);
        ll.printList();

        Node ans = ll.pushAtMiddle(90,second);
        //if next is not null i.e
        if(ans.next!=null){
            ll.printList();
        }
        
    }
}
