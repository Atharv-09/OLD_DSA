import java.util.*;

class Node{
    int data;
    Node next;
}

class CLL{

    static Node push(Node last,int new_data){


        if(last==null){
            Node new_node = new Node();
            new_node.data= new_data;
            last = new_node;

            last.next = last;
            return last;
        }else{

            Node new_node = new Node();
            new_node.data = new_data;
            new_node.next = last.next;
            last.next = new_node;
            last = new_node;
            return last;
        }
    }

    static Node delete(Node last,int del_data){

        if(last==null) return null;

        // if the deleted node is first node ;

        Node first = last.next;

        do{
            if(first.next.data==del_data){
                break;
            }
            first = first.next;
        }while(first!=last.next);

        if(first.next==last){ //if the node to be deleted is last node // point the new last second node as last node
            first.next = first.next.next;
            last = first;
        }else{
            first.next = first.next.next;
        }
        return last;

    }
    static void print(Node last){

        Node first = last.next;

        do{
            System.out.print(first.data+" ");
            first = first.next;
        }while(first!=last.next);


        System.out.println();
    }
    public static void main(String[] args) {
        Node last = null;
        Scanner sc = new Scanner(System.in);
        last = push(last,2);
        last = push(last,3);
        last = push(last,5);
        last = push(last,66);
        last = push(last,21);
        print(last);

        System.out.print("Enter the data/node to deleted : ");
        int data_del =sc.nextInt();

        last = delete(last,data_del);
        print(last);

        System.out.println(last.data);
        Node f = last.next;
        System.out.println(f.data);
    }

}