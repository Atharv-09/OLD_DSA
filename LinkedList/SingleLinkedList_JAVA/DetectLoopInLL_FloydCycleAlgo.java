import java.util.*;

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
    
    static boolean detectLoop(){

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;

    }   

    // TO GET THE NODE NUMBER OF intersection of loop 
    // 
    /*
        static Node detectLoop(){

        Node slow = head;
        Node fast = head;
            boolean found = false;

        while(fast!=null && fast.next.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                found = true;
                break;
            }
        }

        if(found==false)    return null;

        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    */
    public static void main(String[] args){
        LinkedList ll = new LinkedList();


        ll.head = new Node(1);
        ll.head.next  =  new Node(3);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = new Node(7);
        ll.head.next.next.next.next.next = new Node(5);

        ll.printList();

        //creating loop for test
        ll.head.next.next.next.next.next.next = head.next.next;



        boolean ans = detectLoop();

        if(ans)
            System.out.println("Loop detected in linked list");
        else 
            System.out.println("Loop is not there in Linked List");
    }
}