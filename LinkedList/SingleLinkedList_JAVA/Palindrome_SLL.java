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

    static Node dum = new Node(-1);
    static Node temp = dum;

    static void push_At_Back(int new_data){
        
        temp.next = new Node(new_data);
        temp = temp.next;

        head = dum.next;
    }
    static void printList(Node temp){
        Node t = temp;
        while(t!=null){
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }

    static Node reverseList(Node h){

        Node prev = null;
        Node nex = null;

        while(h!=null){
            nex = h.next;
            h.next = prev;
            prev = h;
            h = nex;
        }

        return prev;
    }
    static boolean palindromeOrNot(){

        if(head == null || head.next==null) return true;

        Node dum  = head;

        // To find the mdiddle of list
        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // now to reverse the right haft after the slow poine 

        slow.next = reverseList(slow.next);
        // moving slow to right first
        slow = slow.next;

        // printList(head);
        // printList(slow);
        while(slow!=null){
            if(head.data != slow.data){
                return false;
            }

            head = head.next;
            slow = slow.next;
        }  

        System.out.println("Node after reversing next half : ");
        printList(dum);

        // for getting as it is node
        head.next = reverseList(head.next);
        System.out.println("Node becomes as it was : ");
        printList(dum);
        return true;


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        int len;

        System.out.print("Enter linked list length: ");
        len = sc.nextInt();

        for(int i=0;i<len;i++){
            push_At_Back(sc.nextInt());
        }

        // printList(head);

        boolean ans = palindromeOrNot();

        if(ans==true)
            System.out.println("Linked list is Palindrome");
        else 
            System.out.println("Linked list is not a Palindrome");
    }
}