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

    void deleteNode(Node del){

        if(head==null || del==null) return;
        
        
        if(del==head){
            head = del.next;
            return;
        }
        if(del.next!=null){
            del.next.prev = del.prev;
        }

        if(del.prev!=null){
            del.prev.next = del.next;
        }
        return;
        // OR 
        // Node prevNode = null;
        // Node nexNode = null;
 
        // if(del.next==null){

        //     prevNode = del.prev;
        //     prevNode.next = null;
        //     return;

        // }
        
        // nexNode = del.next;
        // prevNode = del.prev;
        // nexNode.prev = prevNode;
        // prevNode.next = del.next;


    }
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            DLL d = new DLL();
            d.push(2);
            d.push(4);
            d.push(6);
            d.push(8);

            d.printList();

            System.out.println("Enter node data to be deleted : ");
            int n = sc.nextInt();

            Node t = head;
            Node nodeToDel = null;
            while(t!=null){
                if(t.data==n){
                    nodeToDel = t;
                    break;
                }
                t = t.next;
            }
            d.deleteNode(nodeToDel);

            d.printList();
    }
}