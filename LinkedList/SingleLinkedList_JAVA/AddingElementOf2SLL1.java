/*Given two numbers represented by two lists, write a function that returns the sum list. The sum list is list representation of the addition of two input numbers.

Example:

Input: 
List1: 5->6->3 // represents number 365 
List2: 8->4->2 // represents number 248 
Output: 
Resultant list: 3->1->6 // represents number 613 
Explanation: 365 + 248 = 613
Input: 
List1: 7->5->9->4->6 // represents number 64957 
List2: 8->4 // represents number 48 
Output: 
Resultant list: 5->0->0->5->6 // represents number 65005 
Explanation: 64957 + 48 = 65005*/

class Node{
    int data;
    Node next;

    Node(int d){
        data =d;
        next =null;
    }
}

class LinkedList{

    // Node head;
    static Node first=null;
    static Node second=null;

    // void push(int new_data,Node node){ // 5 first 

    //     Node new_node = new Node(new_data);

    //     new_node.next = node;
    //     node = new_node;
    // }
    
       static Node addTwoSLL(Node first,Node second){

        Node dummy = new Node(0);
        Node temp = dummy;


        int carry = 0;

        while(first!=null || second!=null){
            int sum = 0;
            if(first!=null){
                sum = sum+first.data;
                first = first.next;
            }

            if(second!=null){
                sum =sum+ second.data;
                second = second.next;
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
    void printList(Node head){

        // Node temp = node1;
        while(head!=null){
            System.out.print(head.data+" ");
            head= head.next;
        }
        System.out.println();
    }
    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        // ll.push(3,first);
        // ll.push(6,first);
        // ll.push(5,first);

        ll.first = new Node(7);
        ll.first.next = new Node(5);
        ll.first.next.next = new Node(9);
        ll.first.next.next.next = new Node(4);
        ll.first.next.next.next.next = new Node(6);
        // ll.
        ll.printList(first);

        ll.second = new Node(8);
        ll.second.next = new Node(4);
        // ll.second.next.next = new Node(2);
        // ll.push(2,second);
        // ll.push(4,second);
        // ll.push(8,second);

        ll.printList(second);

        Node ans = addTwoSLL(first,second);
        ll.printList(ans);
    }
}


