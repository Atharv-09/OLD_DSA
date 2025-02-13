
class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class LinkedList{

    static Node first,sec;

    void printList(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    Node AddReversedList(Node f,Node s){

        Node dummy = new Node(0);
        Node temp  =dummy;

        int carry =0;

        while(f!=null || s!=null){

            int sum = 0;

            if(f!=null){
                sum = sum+f.data;
                f = f.next;
            }

            if(s!=null){
                sum = sum + s.data;
                s = s.next;
            }

            sum = sum+carry;

            carry = sum/10;
            int rem = sum%10;

            Node new_node = new Node(rem);
            temp.next = new_node;
            temp = temp.next;

        }

        if(carry>0){
            Node new_node = new Node(carry);
            temp.next = new_node;
            temp = temp.next;
        }

        return dummy.next;
    }
    static Node reverseList(Node node){

        Node prevNode = null;
        Node nextNode = null;
        Node currNode = node;

        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            
            prevNode = currNode;
            currNode = nextNode;
        }

        node = prevNode;
        return node;
    }
    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        
        first = new Node(4);
        first.next = new Node(5);

        // ll.printList(first);

        sec = new Node(3);
        sec.next = new Node(4);
        sec.next.next = new Node(5);

        // ll.printList(sec);

        Node reversedF = reverseList(first);
        Node reversedL = reverseList(sec);

        // ll.printList(reversedF);
        // ll.printList(reversedL);

        Node ans = ll.AddReversedList(reversedF,reversedL); // here we get the 0 9 3 
        // ll.printList(ans);

        //reveres the ans ;

        ll.printList(reverseList(ans));
    }
}