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


    void printList(){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " " );
            temp = temp.next;
        }
        System.out.println();
    }
    
    void swapNodes(int m,int n){

        if(m==n){
            return;
        }   

        Node prevX = null;
        Node currX = head;

        while(currX.data!=m && currX!=null){
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;

        while(currY.data!=n && currY!=null){
            prevY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null){
            return;
        }

        if(prevX!=null){
            prevX.next = currY;
        }else{
            head = currY;
        }

        if(prevY!=null){
            prevY.next = currX;
        }else{
            head = currX;
        }

        Node t = currY.next;
        currY.next = currX.next;
        currX.next = t; 


    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();


        ll.head = new Node(1);
        ll.head.next  =  new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next= new Node(5);
        ll.head.next.next.next.next.next = new Node(6);
        ll.head.next.next.next.next.next.next = new Node(7);
        ll.printList();

        ll.swapNodes(4,6);
        
        System.out.println("After swapping ");
        ll.printList();
    }
}