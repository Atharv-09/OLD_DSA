import java.util.*;

class LinkedList{
    
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    void push(int new_data){
        
        Node new_node = new Node(new_data);

        new_node.next =head;
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

    void deleteNodeAtPos(int pos){

        if(head==null){
            return;
        }

        Node temp = head;

        if(pos==0){
            head = temp.next;
            return;
        }
        int index = 0;
        //Node prev=null;
        while(temp!=null && index<pos-1){
        
            temp = temp.next;
            index++;
        }

        if(temp==null && temp.next==null){
            return;
        }

        Node n = temp.next.next;

        temp.next = n;
   //     index++;
    
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        
        ll.push(7);
        ll.push(1);
        ll.push(8);
        ll.push(5);
        ll.push(2);
 
        ll.printList(); // 2 5 8 1 7

        System.out.println("Enter position index no. to delete : ");
        int pos = sc.nextInt();

        ll.deleteNodeAtPos(pos);
 
        System.out.println("After deleting at position "+pos);
        ll.printList();
    }
}