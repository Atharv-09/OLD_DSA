class Node{
    int data;
    Node next = null;

    Node(int d){
        data = d;
        next = null;
    }
}

class LinkedList{
    static Node head;

    static void printList(Node node){
        Node t = node;
        while(t!=null){
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }

    // time = O(n) space = O(n);
    static Node removeDuplicates(){
        Node dummy = new Node(-1);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;
        boolean foundD= false;
        while(curr!=null && curr.next!=null){

            foundD = false;

            while(curr!=null && curr.next!=null && curr.data == curr.next.data){
                curr = curr.next;
                foundD = true;
            }

            if(foundD==false){
                prev = prev.next;
            }else{
                prev.next = curr.next;
            }

            curr=curr.next;
        }
        return dummy.next;
        // not runnung
        // Node temp = head;
        // Node prevNode = null;
        // while(temp.next!=null){

        //     // Node prevNode = null;
        //     Node currNode = temp.next;
        //     prevNode = temp;

        //     // System.out.println(prevNode.data);
        //     while(currNode!=null && currNode.data==temp.data){
                
        //         currNode = currNode.next;
            
        //     }

        //     prevNode.next = currNode;
            
        //     temp =temp.next;
        // }

    }
    public static void main (String[] args){

        head = new Node(1);
        head.next  =  new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4); 
        head.next.next.next.next.next.next = new Node(5);
    
        Node ans = removeDuplicates();

        printList(ans);
    }
}