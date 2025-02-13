
class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}

class TwoSLLInput{

    static Node head;
    static Node first;
    // head = first
    static Node second=null;

    Node new_node;
    void push(int new_data,Node n){

        // first = n;
        
        new_node = new Node(new_data);

        new_node.next = n;
        n = new_node;

        // System.out.println(new_node.next);
    }

    void show(){
        while(first!=null){
            System.out.print(first.data+ " ");
            first = first.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TwoSLLInput t = new TwoSLLInput();

        t.push(10,first);
        t.push(21,first);
        t.push(2,first);

        t.show();
    
    }
}