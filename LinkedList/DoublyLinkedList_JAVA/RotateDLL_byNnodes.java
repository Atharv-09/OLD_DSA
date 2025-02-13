
import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int d){
        data = d;
        next=prev=null;
    }
}


class DLL{
    static Node head;

    static void insertAtEnd(int new_data){
        Node new_node = new Node(new_data);
    
        new_node.next = null;
        if(head==null){
            new_node.prev = null;
            head = new_node;
            return;
        }
    
        Node temp = head;
    
        while(temp.next!=null){
            temp =temp.next;
        }
        new_node.prev = temp;
        temp.next = new_node;
    }

    static void print(){
        Node t = head;
        while(t!=null){
            System.out.print(t.data+" ");
            t = t.next;
        }   
        System.out.println();
    }

    static void rotateDLL(int n){

        if(n==0) return;

        Node first = head;
        Node last = head;

        while(last.next!=null){
            last = last.next;
        }

        first.prev = last;
        last.next = first;

        Node temp =head; // temp is the nth node
        int count = 1;


        while(count<n && temp!=null){
            temp = temp.next;
            count++;
        }
        if(temp==null) return;

        head = temp.next;
        head.prev = null;

        temp.next = null;



    }

    public static void main(String[] args) {
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);
        insertAtEnd(6);
        insertAtEnd(8);
        insertAtEnd(9);

        print();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many nodes u want to rotate : ");
        int n = sc.nextInt();
        rotateDLL(n);

        print();
    }
}
/*$ java DLL
1 2 3 4 5 6 8 9
Enter how many nodes u want to rotate : 2
3 4 5 6 8 9 1 2

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/DoublyLinkedList_JAVA     
$ java DLL
1 2 3 4 5 6 8 9
Enter how many nodes u want to rotate : 5
6 8 9 1 2 3 4 5*/