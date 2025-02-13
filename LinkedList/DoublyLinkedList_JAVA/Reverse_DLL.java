import java.util.*;

class Node{
    int data;
    Node prev;
    Node next;

    Node(int d){
        data = d;
        prev=next=null;
    }
}

class DLL{

    static Node head;
    void push(int new_data){
        
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
  
        if(head!=null)  
            head.prev = new_node;
        head = new_node;

    }

    void printList(){

        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    void reverse(){
        Node temp = null;
        Node curr = head;

        while(curr!=null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr =  curr.prev;
        }

        if(temp!=null){
            head = temp.prev;
        }
    }
    
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            DLL d = new DLL();

            System.out.print("Enter list length : ");
            int len = sc.nextInt();

            for(int i=0;i<len;i++){
                d.push(sc.nextInt());
            }

        d.printList();

            d.reverse();

            d.printList();
    }
}