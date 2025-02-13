
class ListNode{
    int val;
    ListNode next;

    ListNode(int d){
        val = d;
        next = null;
    }
}

class PartitioList{

    static ListNode head;

    void push(int new_data){

        ListNode new_Node = new ListNode(new_data);

        new_Node.next = head;
        head = new_Node;
    }

    void printList(ListNode node){
        ListNode n = node;
        int count=0;
        while(n!=null){
            count++;
            System.out.print(n.val+" ");
            n = n.next;
        }
    }

    //TIME : O(N) SPACE : O(1)
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        //we take dummy node and point to temp 
        ListNode newHead = new ListNode(0);
        newHead.next = head; // dummy node to find the new head
        ListNode divider = newHead; // divider will be updated to the last smaller node before any greater or equal
                                    // to nodes
        ListNode n = head;
        while (n.next != null) {
            // if the curr and next node is less or grater then the x then simply skp the node 
            if (n.val >= x && n.next.val >= x || n.val < x && n.next.val < x) {
                n = n.next; // move on because no need to update divider
            } else if (n.val < x && n.next.val >= x) {// is curr is less the and next is greater then then 
                divider = n; // update divider
                n = n.next; 
            } else {
                // when (n.val>=x && n.next.val<x), move smaller value after divider, update divider
                // and reorder, note that we don't update n in this case
                ListNode temp = n.next;// we make the next divider node as temp 
                ListNode tempDividerNext = divider.next; // then we simply aattah to next of dummy nmode 
                n.next = n.next.next;
                divider.next = temp;
                divider.next.next = tempDividerNext;
                divider = divider.next;
            }
        }
        return newHead.next;
    }
    // TINE : O(N) SPACE : O(N)
    // public ListNode partition(ListNode head, int x) {
        
    //     if(head==null) return null;
    //     if(head.next==null) return head;
        
    //     ListNode dummy = new ListNode(0);
    //     ListNode dum = dummy;
    //     ListNode dummy1 = new ListNode(0);
    //     ListNode dum1 = dummy1;
        
    //     ListNode temp = head;
       
    //     while(temp!=null){
            
    //         if(temp.val<x){
                    
    //             dum.next = new ListNode(temp.val);
    //             dum = dum.next;
    //         }else{
    //             dum1.next = new ListNode(temp.val);
    //             dum1 = dum1.next;
    //         }
            
    //         temp = temp.next;
            
    //     }
        
    //     dum.next = dummy1.next;
    //     return dummy.next;
        
    // }
    public static void main(String[] args){
        PartitioList ll = new PartitioList();
        ll.push(2);
        ll.push(5);
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(1);

        ListNode ans = ll.partition(head,3);
        ll.printList(ans);
    }

}

/*Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.*/


/*Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]*/


/*
TIEM": O(n)
SPACR  : O(1)

public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0, head); // dummy node to find the new head
        ListNode divider = newHead; // divider will be updated to the last smaller node before any greater or equal
                                    // to nodes
        ListNode n = head;
        while (n.next != null) {
            if (n.val >= x && n.next.val >= x || n.val < x && n.next.val < x) {
                n = n.next; // move on because no need to update divider
            } else if (n.val < x && n.next.val >= x) {
                divider = n; // update divider
                n = n.next; 
            } else {
                // when (n.val>=x && n.next.val<x), move smaller value after divider, update divider
                // and reorder, note that we don't update n in this case
                ListNode temp = n.next;
                ListNode tempDividerNext = divider.next;
                n.next = n.next.next;
                divider.next = temp;
                divider.next.next = tempDividerNext;
                divider = divider.next;
            }
        }
        return newHead.next;
    }
*/