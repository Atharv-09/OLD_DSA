import java.util.Scanner;

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

    void insertAtBegining(int new_data){

        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;

        if(head!=null)  
            head.prev = new_node;

        head = new_node;
    }

    void insertAfter(Node prev_node,int new_data){

            if(prev_node==null){
                System.out.println("Previous node cannnot be null"); 
                return;
            }

            Node new_node = new Node(new_data);
            
            new_node.next = prev_node.next;
            prev_node.next = new_node;
            new_node.prev = prev_node;

            if(new_node.next!=null){
                new_node.next.prev = new_node;
            }
    }

    void insertAtEnd(int new_data){

            Node new_node = new Node(new_data);

            Node temp = head;
            new_node.next = null;

            // if the node is null
            if(temp==null){
                new_node.prev = null;
                head = new_node;
                return;
            }

        
            while(temp.next!=null){
                temp = temp.next;
            }

            temp.next = new_node;
            new_node.prev = temp;

    }

    void print(){
        Node n = head;
        Node last = null;

        System.out.println("Linked list in forward direction : ");
        while(n!=null){
            System.out.print(n.data+" ");
            last = n;
            n = n.next;
        }
        System.out.println("\nLinked list in reversed direction : ");
        while(last!=null){
            System.out.print(last.data+" ");
            last = last.prev;
        }
        System.out.println();
    }
    public static void main(String[] args){
        DLL d = new DLL();
        Scanner sc = new Scanner(System.in);

        d.insertAtBegining(20);
        d.insertAtBegining(30);
        d.insertAtBegining(40);

        d.print();
        
        System.out.print("Enter the prevNode to insert after : ");
        int pre = sc.nextInt();

        Node t = head;
        Node toFind = null;
        while(t!=null){
            if(t.data == pre){
                toFind = t;
                break;
            }
            t = t.next;
        }
        d.insertAfter(toFind,15);
        d.print();

        d.insertAtEnd(90);
        d.print();
    }
}