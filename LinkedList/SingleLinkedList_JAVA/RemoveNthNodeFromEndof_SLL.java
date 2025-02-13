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

    static Node deleteNode(Node head,int n){

        Node temp = head;
        int count=0;

        while(temp!=null){
            count++;
            temp = temp.next;
        }

        if(n>count){
            return head;
        }else if(n==count){
            return head.next;
        }else{
            int diff = (count-n) +1;
            Node prevNode = null;
            Node currNode = head;
            for(int i=1;i<diff;i++){
                prevNode = currNode;
                currNode = currNode.next;
            }

            prevNode.next = currNode.next;
            return head;
        }
        
    }
    void printList(Node ans){
        while(ans!=null){
            System.out.print(ans.data+" ");
            ans = ans.next;
        }
        System.out.println();
    }
    public static void main(String[] args){

        LinkedList ll = new LinkedList();

        head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(13);
        head.next.next.next = new Node(131);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        ll.printList(head);
        Node ans = deleteNode(head,4);
        
        ll.printList(ans);
   }
}