    class Node{
    int data;
    Node next;
}
class CLL{

    static Node addToEmpty(Node last,int new_data){

        if(last!=null)  return last; // cox this func is only for empty list 

        Node node = new Node();
        node.data = new_data;
        last = node;

        last.next = last; // circular link 

        return last;
    }

    static Node addAtBegin(Node last,int new_data){

        if(last==null){
            return addToEmpty(last, new_data);
        }

         Node temp = new Node();

         temp.data=new_data;
         temp.next = last.next;
         last.next = temp;

        return last;
    }

    static Node addAtEnd(Node last,int new_data){

        if(last==null) return addToEmpty(last, new_data);

        Node new_node = new Node();
        new_node.data =  new_data;

        new_node.next = last.next;
        last.next = new_node;
        last = new_node;

        return last;

    }

    static Node addAfterNode(Node last,int new_data,int prevNode_data){

        if(last==null) return null;

        Node prev;
        prev = last.next;

        do{ 
            if(prev.data==prevNode_data){
                break;
            }
            prev = prev.next;

        }while(prev!=last.next);

        Node temp = new Node();
        temp.data =new_data;
        temp.next = prev.next;
        prev.next = temp; 

        return last;
    }


    static void transverse(Node last){
        if(last==null){
            System.out.println("List is empty");
            return;
        }

        Node first;
        first = last.next;
        do{
            System.out.print(first.data+" ");
            first = first.next;
        }while(first!=last.next);
        System.out.println();
    }
    public static void main(String[] args){
        Node last = null;

        last = addToEmpty(last,4);
        transverse(last);

        last = addAtBegin(last,10);
        last = addAtBegin(last,29);
        transverse(last);

        last = addAtEnd(last,90);
        last = addAtEnd(last,219);
        transverse(last);

        last = addAfterNode(last,1100,10);
        transverse(last);
    }
}