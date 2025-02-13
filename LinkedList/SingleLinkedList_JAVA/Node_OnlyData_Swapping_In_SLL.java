
class LinkedList{
    
    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }   

    void printList(Node n){

        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    // Node fromFirst(Node l,int k){
        
    //     int count = 1;
    //     Node ans = null;
    //     while(count<k){
    //         ans = l.next;   
    //         l = l.next;         
    //         count++;
    //     }
        
    //     return ans;
    // }
    
    // Node fromLast(Node l,int k){
    //     int count = 1;
    //     Node temp = l;
    //     int itemC=0;
    //     while(temp!=null){
    //         itemC++;
    //         temp = temp.next;
    //     }
        
    //     int diff = (itemC-k)+1;

    //     Node ans1 = null;
    //     while(count<diff){
    //         ans1 = l.next;
    //         l = l.next;            
    //         count++;
    //     }
    //     return ans1;
    // }
    
    // void swap(Node n1,Node n2){
    //     int temp = n1.data;
    //     n1.data = n2.data;
    //     n2.data = temp;
    // }
    
    Node swapNodes(Node head, int k) {
        
        // Node temp1 = head;
        // Node temp2 = head;
        // Node n1 = fromFirst(temp1,k);
        // Node n2 = fromLast(temp2,k);
        
        // printList(n1);
        // printList(n2);
        // swap(n1,n2);

        Node temp1 = head;
        int len=0;
        while(temp1!=null){
            len++;
            temp1 = temp1.next;
        }

        Node left = head;
        Node right = head;

        int l = k;
        int r = (len-k)+1;

        while(l>1){
            left = left.next;    
            l--;
        }

        while(r>1){
            right = right.next;
            r--;
        }

        // System.out.println(left.data+" "+right.data);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        return head;
    }
    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        ll.head = new Node(10);
        ll.head.next = new Node(20);
        ll.head.next.next= new Node(30);
        ll.head.next.next.next = new Node(40);
        ll.head.next.next.next.next = new Node(50);

        ll.printList(head);

        Node ans = ll.swapNodes(head,5);

        ll.printList(ans);
    }
}
