class Node{
    int data;
    Node next;
    Node prev;
    Node(int d){
        data = d;
        next=prev=null;
    }
}


class DLL{
    static Node head;

    static void insertAtEnd(int new_data){
        Node new_node = new Node(new_data);
    
        new_node.next = null;
        if(head==null){
            new_node.prev = null;
            head = new_node;
            return;
        }
    
        Node temp = head;
    
        while(temp.next!=null){
            temp =temp.next;
        }
        new_node.prev = temp;
        temp.next = new_node;
    }

    static void trip(Node f,Node l,int data,Node curr){

        while(f!=null && l!=null && f!=l && l.next!=f){

            if((f.data+l.data) == data){
                System.out.println(curr.data+" "+f.data+" "+l.data);
                f = f.next;
                l = l.prev;
            }else if((f.data+l.data)<data){
                f = f.next;
            }else{
                l = l.prev;
            }
        }
    } 
    static void findTriplet(int sum){

        Node curr = head,first,last;

        if(head==null) return;
        last = head;
        while(last.next!=null)
            last = last.next;

        for(;curr!=null;curr=curr.next){

            first = curr.next;

            trip(first,last,sum-curr.data,curr);
        }


    }
    static void print(){
        Node t = head;
        while(t!=null){
            System.out.print(t.data+" ");
            t = t.next;
        }   
        System.out.println();
    }
    public static void main(String[] args) {
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(4);
        insertAtEnd(5);
        insertAtEnd(6);
        insertAtEnd(8);
        insertAtEnd(9);

        print();

        findTriplet(15);
    }
}