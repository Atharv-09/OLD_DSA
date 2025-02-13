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

    void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }

        System.out.println();
    }

    void deleteNode(int key){
        Node h = head;
        Node prev = null;
        
        if(h!=null && h.data==key){
            head = h.next;
            return;
        }
        while(h!=null && h.data!=key){
                
                prev = h;
                h = h.next;
         
        }

        if(h==null){
            return;
        }
        prev.next = h.next;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        LinkedList ll = new LinkedList();
        ll.push(20);
        ll.push(21);
        ll.push(22);

        ll.printList();

        System.out.println("Enter the element you want to delete : ");
        int key = sc.nextInt();

        ll.deleteNode(key);
        ll.printList();
    }


}