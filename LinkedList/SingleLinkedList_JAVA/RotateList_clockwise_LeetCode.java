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
            temp=temp.next;
        }
        System.out.println();
    }
    
    static void rotateList(int k){

        Node temp = head;
        Node temp1 = head;

        int count = 1;
        //take 1 ptr to last of the list 
        while(temp.next!=null){  
            count++;
            temp = temp.next;
        }

        // if k is greater then len then take mod beacuse after roating len time it is of original kist

        k = k%count;

        for(int i=1;i<count-k;i++){
            temp1 = temp1.next;
        }

        if(k==0)
            return;
        else{
            temp.next = head;
            head = temp1.next;
            temp1.next = null;
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


        rotateList(3);

        ll.printList();
    }
}