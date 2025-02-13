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


    static void printList(Node temp){

        Node t = temp;
        while(t!=null){
            System.out.print(t.data+ " " );
            t = t.next;
        }
        System.out.println();
    }
    
    static Node intersection(Node f1,Node s1){

        Node dummy = new Node(-1);
        Node temp = dummy;

        Node n1 = f1;
        Node n2 = s1;   

        printList(n1);
        
        // as the list is not sorted we traverse in O(n*m);
        // if list is sorted then time is (O(m+n)) 
        // using hashing for both time : O(n) spae : O(m)
        
        if(f1==null || s1 ==null) return null;
        while(n1!=null){

            while(n2!=null){

                // System.out.println(n1.data+" "+n2.data);
                if(n1.data == n2.data){
                    temp.next = n1;
                    temp = temp.next;
                    break;
                }
                n2 = n2.next;
            }
            n2 = s1;
            n1 = n1.next;
        }

        // System.out.println(dummy.next);
        return dummy.next;
    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();


        ll.first = new Node(20);
        ll.first.next  =  new Node(15);
        ll.first.next.next = new Node(4);
        ll.first.next.next.next = new Node(10);
        // ll.first.next.next.next.next = new Node(3);
        // ll.first.next.next.next.next.next = new Node(8); 

        ll.sec = new Node(10);
        ll.sec.next  =  new Node(2);
        ll.sec.next.next = new Node(8);
        ll.sec.next.next.next = new Node(4);
        
        Node ans = intersection(first,sec);
        ll.printList(ans);
    }
}