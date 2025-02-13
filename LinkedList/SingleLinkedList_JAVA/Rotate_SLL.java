import java.util.*;

class Node{

    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}

class RotateSLL{

    Node head;

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
    
    
    void rotate(int k){
        // Node prev = head;
        // temp = head;
        Node temp = head;
        int index = 1;

        while(temp!=null){

            if(index==k){
                break;
            }
            index++;
            temp =  temp.next;
        }

        Node kthNode = temp;

        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = head;
        head = kthNode.next;

        kthNode.next = null;

    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        RotateSLL rs = new RotateSLL();
        rs.push(8);
        rs.push(7);
        rs.push(6);
        rs.push(5);
        rs.push(4);
        rs.push(3);
        rs.push(2);
        rs.push(1);
        rs.printList();
        System.out.print("Enter Number of times u want to rotate : ");
        int k = sc.nextInt();
        
        rs.rotate(k);
        rs.printList();
        
    }

}