import java.util.*;
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
        
        Node temp=head;
        new_node.next = null;
        if(temp==null){
            new_node.prev = null;
            head=new_node;
            return;
        }

        while(temp.next!=null){
            temp=temp.next;
        }
        new_node.prev =temp;
        temp.next=new_node;
    
    }

    static void print(){
        Node t = head;
        while(t!=null){
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }

    static void findPairs(int sum){

        Node first = head;
        Node sec = head;

        while(sec.next!=null){
            sec=sec.next;
        }

        while(first!=null && sec!=null && first!=sec && sec.next!=first){

                if(first.data+sec.data == sum){
                    
                    System.out.println(first.data+" "+sec.data);
                    first=first.next;
                    sec = sec.prev;
                }else if(first.data+sec.data<sum){
                    first = first.next;
                }else{
                    sec = sec.prev;
                }
        }

    }
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
       insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);

        print();


        System.out.print("Enter the sum u want from pairs : ");
        int sum = sc.nextInt();
        findPairs(sum);
    }
}

/*$ java DLL
1 2 3 4 5
Enter the sum u want from pairs : 5
1 4
2 3

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/DoublyLinkedList_JAVA     
$ java DLL
1 2 3 4 5
Enter the sum u want from pairs : 7
2 5
3 4*/