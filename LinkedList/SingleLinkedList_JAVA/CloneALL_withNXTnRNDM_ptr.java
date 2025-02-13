class Node{
    int data;
    Node next;
    Node rnd;

    Node(int d){
        data = d;
        next = null;
        rnd = null;        
    }
}

class LinkedList{

    static Node head;

    // Node dum = new Node(-1);

    void pushAtBack(int new_data){
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
        
    }   

    static void printList(Node n){
        Node t = n;
        while(t!=null){
            System.out.print(t.data+" ");
            t =t.next;
        }
        System.out.println();
    }

    void copyList(){

        
        Node curr = head;
        Node nex = null;

        // insert copy node right next to the original node 
        // and make next poiniter in correct way
        while(curr!=null){  
            nex = curr.next;
            Node newNode = new Node(curr.data);
            curr.next = newNode;
            newNode.next = nex;
            
            curr = nex;
        }

        // now for random pointer

        curr = head;
        while(curr!=null){

            if(curr.next!=null){
                if(curr.rnd!=null){
                    curr.next.rnd = curr.rnd.next;
                }else{
                    curr.next.rnd = curr.rnd;
                }

                // to incremenet the curr

                // if(curr.next!=null){
                    curr = curr.next.next;
                // }else{
                    // curr = curr.next;
                // }

            }else{
                curr = curr.next;
            }
        }

        Node dum = new Node(-1);
        Node copy = dum;

        curr = head;

        while(curr!=null){
            nex = curr.next.next;

            copy.next = curr.next;
            curr.next = nex;

            copy = copy.next;
            curr = curr.next;            
            
        }

        printList(dum.next);
    }



    public static void main(String[] args){

        LinkedList ll = new LinkedList();

        ll.pushAtBack(10);
        ll.pushAtBack(20);
        ll.pushAtBack(30);
        ll.pushAtBack(40);
        ll.pushAtBack(50);
        
        printList(head);
    
        ll.copyList();
    }
}