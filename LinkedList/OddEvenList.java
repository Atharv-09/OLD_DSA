class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class OddEvenList{

    static Node head;

    void push(int new_data){

        Node new_Node = new Node(new_data);

        new_Node.next = head;
        head = new_Node;
    }

    void printList(Node node){
        Node n = node;
        int count=0;
        while(n!=null){
            count++;
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println("\nThe total element count in LL is : "+count);
    }

    void OddEven(Node head){

        // OR 
        // Tale 2 dummy node and point 1 to even list node and another to edd list node 
        //then add both accordingly 

        
        //SPACE  : (n) TINE : O(1);
        // Node temp = head;
        // int k = 0;
        // Node nextNode = null;
        // Node dummy = new Node(0);
        // Node node = dummy;

        // while(temp.next.next!=null){

        //     if(k%2==0 ){

        //         nextNode = temp.next;
        //         temp.next = temp.next.next;
        //     }else{

        //         Node new_Node = new Node(temp.data);
        //         node.next = new_Node;
        //         node = node.next;
        //         nextNode = temp.next;
        //     }   
        //     k++;
        //     temp = nextNode;
        // }
        // // printList(dummy.next);
        // temp = head;
        // while(temp.next!=null){
        //     temp = temp.next;
        // }

        // temp.next = dummy.next;

        // TINE : O(N)
        // SPACE : O(1)

        Node even = head.next;
        Node odd = head;

        Node saveEven = even;

        while(even!=null && even.next!=null){

            Node nextOdd = even.next;
            odd.next = nextOdd;

            Node nextEven = nextOdd.next;
            even.next = nextEven;

            odd = nextOdd;
            even = nextEven;

        }

        odd.next = saveEven;

        printList(head);

    }
    public static void main(String[] args){
        OddEvenList ll = new OddEvenList();

        ll.push(7);
        ll.push(4);    
        ll.push(6);
        ll.push(5);
        ll.push(3);
        ll.push(1);
        ll.push(2);
        // ll.push(11);
        
        ll.printList(head);

        ll.OddEven(head);


    }

}