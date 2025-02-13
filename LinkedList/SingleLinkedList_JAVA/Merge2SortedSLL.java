
class Node{
    int data;
    Node next;

    Node(int d){
        data =d;
        next =null;
    }
}

class LinkedList{

    static Node first,second;
    void printList(Node h){

        Node temp = h;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
        System.out.println();
    }
    static Node sortedMerge(Node headA,Node headB){

        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }       
        
        if(headA.data>headB.data){
            Node temp1 = headA;
            headA = headB;
            headB = temp1;
        }
        
        Node result = headA;

        while(headA!=null && headB!=null){
            Node temp = null;

            while(headA!=null && headA.data<=headB.data ){
                temp = headA;
                headA = headA.next;
            }

            temp.next = headB;

            Node temp1 = headA;
            headA = headB;
            headB = temp1;

            
            
        }

        return result;


        //Using extra space;

        // Node dummy = new Node(0);
        // Node temp = dummy;

        // // space 0(n+m) time O(n+m);
        // while(true){

        //     if(headA==null){
        //         temp.next = headB;
        //         break;
        //     }
        //     if(headB==null){
        //         temp.next = headA;
        //         break;
        //     }
        //     if(headA.data>headB.data){
        //         temp.next = headB;
        //         headB = headB.next;
        //     }else{
        //         temp.next = headA;
        //         headA = headA.next;
        //     }

        //     temp = temp.next;
        // }
        // return dummy.next;

        // O(n) time O(n) space 
        // while(true){
        //     Node new_node=null;
        //     // System.out.println(A.data+" "+B.data);
        //     // is one of list is null then append next list to that
        //     if(headA==null){
        //         temp.next = headB;
        //         break;
        //     }
            
        //     if(headB==null){
        //         temp.next = headA;
        //         break; 
        //     }


        //     if(headA.data>headB.data){
        //         new_node = new Node(headB.data);
        //         headB = headB.next;
        //     }else{
        //         new_node = new Node(headA.data);
        //         headA = headA.next;     
        //     }
        //         temp.next = new_node;
        //         temp = new_node;   
        // }
        // return dummy.next;

        

    }


    public static void main(String[] args){

        LinkedList ll = new LinkedList();

        ll.first = new Node(5);
        ll.first.next = new Node(110);
        ll.first.next.next = new Node(15);
        ll.first.next.next.next = new Node(40);
        // ll.first.next.next.next.next = new Node(410);
        ll.printList(first);

        ll.second = new Node(2);
        ll.second.next = new Node(3);
        ll.second.next.next = new Node(20);

        ll.printList(second);

        Node sortedMergeList = sortedMerge(first,second);
        
        ll.printList(sortedMergeList);
    }
}