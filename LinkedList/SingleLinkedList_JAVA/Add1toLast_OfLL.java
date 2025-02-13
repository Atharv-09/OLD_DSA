
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Sol obj = new Sol();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
class Sol
{
    static Node reverseList(Node h){
        Node temp = h;
        Node prev = null;
        Node nex = null;
        while(temp!=null){
            nex = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nex;
        }
        
        return prev;
    }
    public static Node addOne(Node head) 
    { 
        Node reversed = reverseList(head);
        Node n = reversed;
        
        while(n!=null){
            n.data = n.data+1;
            System.out.println(n.data);
            if(n.data>=10){
                int currData = n.data;
                // System.out.println("In ")
                n.data = n.data%10;
                // System.out.println(n.data);
                n.next.data = n.next.data+(currData/10);
                // System.out.println(n.next.data);
                // break;
            }
            break;
        }

        Node ans = reverseList(reversed);        
        // return reversed;
        return ans;
    }
}
