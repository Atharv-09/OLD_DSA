

/*Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL*/
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
    static Scanner sc = new Scanner(System.in);
    void push(int new_data){

        Node new_node = new Node(new_data);
        
        new_node.next = head;
        head = new_node;
    }

    void showList(Node h){
        Node temp = h;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node reverse(Node head,int m,int n){

        if(head==null) return null;
        if(head.next == null) return head;

        Node dum = new Node(-1);
        dum.next = head;
        // Node temp = head;

        Node nodeBeforeSublist = dum;

        int pos = 2;
        while(pos<m){
            nodeBeforeSublist = nodeBeforeSublist.next;
            pos++;
        }

        Node workingNode = nodeBeforeSublist.next;
        while(m<n){

            Node toBeExtracted = workingNode.next;
            workingNode.next = toBeExtracted.next;

            toBeExtracted.next = nodeBeforeSublist.next;

            nodeBeforeSublist.next = toBeExtracted;

            m++;
    
        }

        return dum.next;




    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println("Entet element count : ");
        int x = sc.nextInt();
        
        for(int i=0;i<x;i++){
            ll.push(sc.nextInt());
        }
        ll.showList(head);

        System.out.print("Enter node no1  to reverse LL : ");
        int m = sc.nextInt();

        System.out.print("Enter node no2  to reverse LL : ");
        int n = sc.nextInt();

        Node revList = reverse(head,m,n);

        ll.showList(revList);
    }
}