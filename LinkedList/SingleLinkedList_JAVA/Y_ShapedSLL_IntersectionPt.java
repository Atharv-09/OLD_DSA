

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}
// App 1 : nested loop through it and check for each ele in ll1 with each elemen in ll2
 // if same then return that  TIME : O(n*m) 

 // App 2 : mark each ele as vis (with modifying in node struct adding flag) and check for ll2 that
 // theere is visited flag already so that is the intersection pt 
// TIME : O(n+m) space : takes addntional info with each node  i.e : (visited);

 // App 3 :  
// Time : O(m+n) sp : O(1) 
class LinkedList{

    static Node first,second;

    void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    static int getIntNode(int d,Node n1,Node n2){
        
        Node curr1 = n1;
        Node curr2 = n2;
        
        for(int i=0;i<d;i++){
            if(curr1==null){
                return -1;
            }
            curr1 = curr1.next;
        }
        
        while(curr1!=null && curr2!=null){
            if(curr1 == curr2){
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return -1;
        
    }
	static void intersectPoint(Node head1, Node head2)
	{   
	    Node temp1 = head1;
	    Node temp2 = head2;
	    
	    int head1C=0,head2C=0;
	    int ans;
	    while(temp1!=null){
	        head1C++;
	        temp1 = temp1.next;
	    }
	    while(temp2!=null){
	        head2C++;
	        temp2 = temp2.next;
	    }
	    
	    int diff=0;
	    if(head1C>head2C){
	        diff = head1C - head2C;
	        
	        ans = getIntNode(diff,head1,head2);
	    }else{
	        diff = head2C - head1C;
	        
	        ans =  getIntNode(diff,head2,head1);
	    }

        System.out.println(ans);
	    
	}
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();

        ll.first = new Node(4);
        ll.first.next = new Node(1);
        ll.first.next.next = new Node(8);
        ll.first.next.next.next = new Node(4);
        ll.first.next.next.next.next = new Node(5);

        int firstC=0,secC = 0;
        Node temp1 = first;
        while(temp1!=null){
            firstC++;
            temp1 = temp1.next;
        }

        ll.second = new Node(5);
        ll.second.next = new Node(6);
        ll.second.next.next = new Node(1);
        ll.second.next.next.next = new Node(8);
        ll.second.next.next.next.next = new Node(4);
        ll.second.next.next.next.next.next = new Node(5);
        
        intersectPoint(first,second);
        
        // System.out.println(ans1);
        //     Node temp2 = second;
    //     while(temp2!=null){
    //         secC++;
    //         temp2 = temp2.next;
    //     }
    //     // ll.printList(first);
    //     // ll.printList(second);
        
    //     int diff = Math.abs(secC-firstC);
        
    //     int count=0;
    //     if(secC>firstC){
    //         while(second!=null){
    //             if(count==diff){
    //                 break;
    //             }
    //             count++;
    //             second= second.next;
    //         }
    //     }else{
    //         while(first!=null){
    //             if(count==diff){
    //                 break;
    //             }
    //             count++;
    //             first = first.next;
    //         }
    //     }
    //     // while(first!=null){
    //     //     System.out.println(first.data+" ");
    //     //     first=first.next;
    //     // }

    //     int ans =-1;

    //     while(first!=null && second!=null){
    //         if(first==second){
    //             ans = second.data;
    //             break;
    //         }
    //         first=first.next;
    //         second = second.next;
    //     }

    //     System.out.println(ans);
        
    }
}

// class LinkedList {
 
//     static Node head1, head2;
 
//     static class Node {
 
//         int data;
//         Node next;
 
//         Node(int d)
//         {
//             data = d;
//             next = null;
//         }
//     }
 
//     /*function to get the intersection point of two linked
//     lists head1 and head2 */
//     int getNode()
//     {
//         int c1 = getCount(head1);
//         int c2 = getCount(head2);
//         int d;
 
//         if (c1 > c2) {
//             d = c1 - c2;
//             return _getIntesectionNode(d, head1, head2);
//         }
//         else {
//             d = c2 - c1;
//             return _getIntesectionNode(d, head2, head1);
//         }
//     }
 
//     /* function to get the intersection point of two linked
//      lists head1 and head2 where head1 has d more nodes than
//      head2 */
//     int _getIntesectionNode(int d, Node node1, Node node2)
//     {
//         int i;
//         Node current1 = node1;
//         Node current2 = node2;
//         for (i = 0; i < d; i++) {
//             if (current1 == null) {
//                 return -1;
//             }
//             current1 = current1.next;
//         }
//         while (current1 != null && current2 != null) {
//             if (current1.data == current2.data) {
//                 return current1.data;
//             }
//             current1 = current1.next;
//             current2 = current2.next;
//         }
 
//         return -1;
//     }
 
//     /*Takes head pointer of the linked list and
//     returns the count of nodes in the list */
//     int getCount(Node node)
//     {
//         Node current = node;
//         int count = 0;
 
//         while (current != null) {
//             count++;
//             current = current.next;
//         }
 
//         return count;
//     }
 
//     public static void main(String[] args)
//     {
//         LinkedList ll = new LinkedList();
 
//         // creating first linked list
//         ll.head1 = new Node(4);
//         ll.head1.next = new Node(1);
//         ll.head1.next.next = new Node(8);
//         ll.head1.next.next.next = new Node(4);
//         ll.head1.next.next.next.next = new Node(5);
        
//         // creating second linked list
//         ll.head2 = new Node(5);
//         ll.head2.next = new Node(6);
//         ll.head2.next.next = new Node(1);
//         ll.head2.next.next.next = new Node(8);
//         ll.head2.next.next.next.next = new Node(4);
//         ll.head2.next.next.next.next.next = new Node(5);
 
//         System.out.println("The node of intersection is " + ll.getNode());
//     }
// }
