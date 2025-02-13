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
    static Scanner sc = new Scanner(System.in);

    void push(int new_data){
        
        Node new_node = new Node(new_data);

        new_node.next = head;
        head = new_node;

    }

    void printNthfromLast(int ind){
        Node temp = head;

        int totalElementCount = 0;
        
        while(temp!=null){
            totalElementCount++;
            temp = temp.next;
        }


        int toFindIndex = (totalElementCount-ind)+1;
        int count=1;

        // System.out.println(toFindIndex);//3 
        // System.out.println(totalElementCount); //4 
        Node temp1 = head;
        while(temp1!=null){
            if(count == toFindIndex){
                System.out.println(temp1.data);
                break;
            }
            count++;
            temp1 = temp1.next;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.push(20); 
        ll.push(4); 
        ll.push(15); 
        ll.push(35); 

        System.out.println("Enter element count from end to get the requreed element : ");
        int ind = sc.nextInt();
        ll.printNthfromLast(ind);
        
    }
}

// 35 15 4 20 

/*$ java LinkedList
Enter element count from end to get the requreed element :
2
4

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
Enter element count from end to get the requreed element :
3
15

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
Enter element count from end to get the requreed element :
4
35

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList/SingleLinkedList_JAVA     
$ java LinkedList
Enter element count from end to get the requreed element :
1
20*/