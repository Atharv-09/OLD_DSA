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

    void insertAtEnd(int new_data){

        Node new_node = new Node(new_data);
        new_node.next = null;


        if(head==null){
            new_node.prev = null;
            head = new_node;
            return;
        }

        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        new_node.prev = temp;
        temp.next = new_node;
    }

    static void reverseDLLInSize(int size){

        // Node temp = head;
        Node curr = head;
        Node nex = null;
        Node newHead = null;

        int c = 0;

        while(curr!=null && c<size){

            nex = curr.next;
            newHead = 
        }
        // while(temp!=null){
        //     int count = 1;
        //     first = temp;
        //     Node curr = temp;
        //     while(curr!=null && count<size){
        //         curr=curr.next;
        //     }

        //     if(first==head){
        //         curr=head;
        //     }


        // }

    }


    void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args){

        DLL l = new DLL();
        l.insertAtEnd(1);
        l.insertAtEnd(2);
        l.insertAtEnd(3);
        l.insertAtEnd(4);
        l.insertAtEnd(5);
        l.insertAtEnd(6);
        l.insertAtEnd(7);

        l.print();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size to be rotate the DLL : ");
        int size = sc.nextInt();

        reverseDLLInSize(size);
    }
}