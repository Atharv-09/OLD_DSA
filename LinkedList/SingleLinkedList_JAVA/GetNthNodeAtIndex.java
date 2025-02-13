import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class LinkedList{

    Node head;

    void push(int new_data){
        
        Node new_Node = new Node(new_data);

        new_Node.next = head;
        head = new_Node;
    }

    void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println();
    }

    void findElement(int ind){
        Node temp = head;
        int index = 1;

        while(temp!=null){
            
            if(index == ind){
                System.out.println(temp.data);
                break;
            }
            temp = temp.next;
            index++;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        ll.push(14);
        ll.push(30);
        ll.push(10);
        ll.push(1);
        
        ll.printList();
        
        System.out.println("Enter element count from 1 to get the element : ");
        int eleInd = sc.nextInt();

        ll.findElement(eleInd);
    }
}

/*
$ java LinkedList
1 10 30 14
Enter element count from 1 to get the element :
3
30

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
1 10 30 14
Enter element count from 1 to get the element :
1
1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
1 10 30 14
Enter element count from 1 to get the element :
2
10

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
1 10 30 14
Enter element count from 1 to get the element :
4
14
*/