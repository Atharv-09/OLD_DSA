import java.util.HashSet;

class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class LinkedList{
    static Node head;

    static void findDuplicate(){
        
        //time = O(n) 
        // spac = 1

        if(head==null) head = null;
        // if(head.next == null) return head;

        Node curr = head;
        Node prev = null;

        HashSet<Integer> hs = new HashSet<>();

        while(curr!=null){
            
            int val = curr.data;

            if(hs.contains(val)){
                prev.next = curr.next;
            }else{
                hs.add(val);
                prev = curr;
            }

            curr = curr.next;
        }

        // time = O(n^2) 
        // space = O(1);
        // Node p1 = head;
        // Node p2 = null;
        // Node dup = null;
        
        // while(p1!=null && p1.next!=null){

        //     p2 = p1;

        //         while(p2.next!=null){

        //             if(p1.data == p2.next.data){
        //                 dup = p2.next;
        //                 p2.next = p2.next.next;
        //                 System.gc();
        //             }else{
        //                 p2 = p2.next;
        //             }
        //         }

        //     p1 = p1.next;
     }
  

    static void printList(){

        Node t = head;
        while(t!=null){
            System.out.print(t.data+ " " );
            t = t.next;
        }
        System.out.println();
    }
 
    public static void main(String[] args){
        LinkedList ll = new LinkedList();


        ll.head = new Node(3);
        ll.head.next  =  new Node(4);
        ll.head.next.next = new Node(5);
        ll.head.next.next.next = new Node(5);
        ll.head.next.next.next.next = new Node(3);
        ll.head.next.next.next.next.next = new Node(6); 

        findDuplicate();

        printList();
    }
}