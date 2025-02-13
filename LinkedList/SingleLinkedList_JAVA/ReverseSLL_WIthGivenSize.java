
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
    static Scanner sc = new Scanner(System.in);
    static Node head;

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

    static Node reverse(Node node,int k){
                    
        Node prevNode = null;
        Node nextNode = null;
        Node currNode = node;
        int c = 0;

        while(currNode!=null && c<k){

            nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;

            c++;
        }
        
        if(nextNode!=null){
            node.next=reverse(nextNode,k);
        }
        return prevNode;
    }

    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        System.out.println("Entet element count : ");
        int n = sc.nextInt();
        
        for(int i=0;i<n;i++){
            ll.push(sc.nextInt());
        }
        ll.showList(head);

        System.out.print("Enter no of nodes to reverse in ine group : ");
        int k = sc.nextInt();

        Node revList = reverse(head,k);

        ll.showList(revList);
    }
}