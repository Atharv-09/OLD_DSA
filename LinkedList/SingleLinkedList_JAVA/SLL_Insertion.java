import java.util.*;

class LinkedList{

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    void pushAtFront(int new_data){

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void pushAtMiddle(int new_data,Node prev_node){

        // System.out.println(prev_node.next);
        if(prev_node.next == null){
            System.out.println("Previous node cannot be null..So we can't add");
            return;
        }

        Node new_node = new Node(new_data);

        new_node.next = prev_node.next;
        prev_node.next = new_node;

    }

    void pushAtBack(int new_data){
        Node temp = head;

        while(temp.next!=null){
            temp = temp.next;
        }
        
        Node new_node = new Node(new_data);
        new_node.next = temp.next;
        temp.next = new_node; 
    }

    void printList(){
        Node n = head;

        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        LinkedList ll = new LinkedList();
        ll.pushAtFront(19); // 19 
        ll.pushAtFront(29); // 29 
        ll.pushAtFront(30);
        ll.pushAtFront(35);

        ll.printList();
        System.out.println("Enter prev_node after which you hav to insert : ");
        int d = sc.nextInt();
        Node prev_node=null;
        Node n = ll.head;
        while(n!=null){
            if(d==n.data){
                prev_node = n;
                break;
            }else{
                n = n.next;
            }
        }
    
        ll.pushAtMiddle(25,prev_node);
        ll.pushAtBack(324);
        ll.printList();

    
    }
}