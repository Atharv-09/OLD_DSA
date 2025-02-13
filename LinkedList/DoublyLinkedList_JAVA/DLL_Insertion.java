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

    static void insertAtBeg(int new_data){

        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;

        if(head!=null)
            head.prev = new_node;
        head = new_node;
    }
    
    static void insertAtMid(int new_data,int prevNodeData){

        Node temp = head;
        Node prevNode = null;
        while(temp!=null){
            if(temp.data==prevNodeData){
                prevNode = temp;
                break;
            }
            temp = temp.next;
        }

        if(prevNode==null){
            System.out.println("Prevnode cannot ve null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prevNode.next;
        new_node.prev = prevNode;
        prevNode.next = new_node;

        if(new_node.next!=null){ // for getting next node and newnode prev conncetion
            new_node.next.prev = new_node;
        }

    }

    static void insertAtEnd(int new_data){

        Node new_node = new Node(new_data);

        Node temp = head;

        new_node.next = null;
        if(temp==null){
            new_node.prev = null;
            head = new_node;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }

        // new_node.next = temp.next;
        new_node.prev = temp;
        temp.next = new_node;

    }
    static void print(){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        insertAtBeg(10);
        insertAtBeg(90);
        insertAtBeg(20);
        insertAtBeg(40);
        print();
        
        System.out.print("enter node data to insert after : ");
        int d = sc.nextInt();
        insertAtMid(100,d);    
        print();

        insertAtEnd(999);
        print();
    }
}