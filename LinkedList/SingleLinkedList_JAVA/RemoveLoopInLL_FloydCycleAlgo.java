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
    

    // Complexity is high 
    // time = O(m*n) 
    // static void removeLoop(){

    //     Node slow = head;
    //     Node fast = head;
    //     boolean found = false;

    //     while(fast.next!=null && fast.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;

    //         if(slow==fast){
    //             found = true;
    //             break;
    //         }
    //     }


    //     if(found==true){

    //         Node p1 = null;
    //         Node p2 = null;

    //         p1 = head;

    //         while(true){
    //             p2 = slow;

    //             while(p2.next!=p1 && p2.next!=fast){
    //                 p2 = p2.next;
    //             }

    //             if(p2.next==p1){
    //                 break;
    //             }

    //             p1 = p1.next;
    //         }

    //         p2.next = null;

    //     }
    // }


    static void removeLoop(){

        Node slow = head;
        Node fast = head;
        boolean found = false;

        while(fast.next!=null & fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                found=true;
                break;
            }
        }

        if(found==true){
            // As there loop exists 
            // Find the pos of first loop node 

            Node p1 = head;
            Node p2 = slow;

            while(p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }

            // Now move p2 pointer until its next is not equal to pointee p1

            while(p2.next!=p1){
                p2 = p2.next;
            }

            p2.next = null;
        }
    }




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
        // ll.printList();

        removeLoop();

        ll.printList();
    }
}