import java.util.*;

class LinkedList{

    static Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    void push(int new_data){

        Node new_node = new Node(new_data);
        new_node.next = head;

        head = new_node;
    }

    void printList(){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
    void deleteNode(Node toDel){
        if(toDel.next == null){
            System.out.println("Node is tail node");
            return;
        }
        Node temp1 = toDel.next;
        toDel.data = temp1.data;
        toDel.next = temp1.next;
        temp1 = null;

        printList();
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        LinkedList ll = new LinkedList();

        ll.push(12);
        ll.push(1);
        ll.push(4);
        ll.push(12);
        ll.push(121);
        ll.push(11);

        ll.printList();

        System.out.println("Enter data to delete(fully delete node) : ");
        int d = sc.nextInt();

        Node toDel=null;
        Node temp = head;

        while(temp!=null){
            if(temp.data == d){
                toDel = temp;
            }
            temp = temp.next;
        }
        
        ll.deleteNode(toDel);
    }
}

/*$ java LinkedList
11 121 12 4 1 12
Enter data to delete(fully delete node) :
121
11 12 4 1 12

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
11 121 12 4 1 12
Enter data to delete(fully delete node) :
12
Node is tail node

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
11 121 12 4 1 12
Enter data to delete(fully delete node) :
4
11 121 12 1 12*/