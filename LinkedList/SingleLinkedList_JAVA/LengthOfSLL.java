class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class LinkedList{

    Node head;

    void push(int new_data){

        Node new_Node = new Node(new_data);

        new_Node.next = head;
        head = new_Node;
    }

    void printList(){
        Node n = head;
        int count=0;
        while(n!=null){
            count++;
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println("\nThe total element count in LL is : "+count);
    }
    public static void main(String[] args){
        LinkedList ll = new LinkedList();

        ll.push(1);
        ll.push(12);    
        ll.push(12);
        ll.push(12);
        ll.push(12);
        ll.push(12);
        ll.push(112);
        ll.push(11);
        
        ll.printList();
    }

}