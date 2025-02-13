
class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

class SplitLLInParts{

    static Node head;

    void push(int new_data){

        Node new_Node = new Node(new_data);

        new_Node.next = head;
        head = new_Node;
    }

    void printList(Node node){
        Node n = node;
        int count=0;
        while(n!=null){
            count++;
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println("\nThe total element count in LL is : "+count);
    }

    Node[] splitLLinParts(Node root,int k){

    	Node temp =root;
    	int len = 0;
    	while(temp!=null){
    		len++;
    		temp = temp.next;
    	}

    	int eachBucketLength = len/k;
    	int extraBucketLength = len%k;

    	temp = head;
    	Node[] ans = new Node[k];
    	int index = 0;

    	while(temp!=null){

    		// every 
    		Node head = temp;
    		int diff = extraBucketLength<=0 ? 0 : 1;//if no element is extra i mean all the length is dividing b the partition then simply addd
  

    		for(int i=0;i<eachBucketLength+diff-1;i++){
    			temp = temp.next;
    		}

    		Node node = temp.next;
    		temp.next = null;
    		temp = node;

    		ans[index++] = head;
    		extraBucketLength--;

    	}	
    	return ans;

    }
    public static void main(String[] args){
        SplitLLInParts ll = new SplitLLInParts();

        ll.push(10);
        ll.push(9);    
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);
        // ll.push(11);
        
        ll.printList(head);

        Node[] ans = ll.splitLLinParts(head,5);

        for(int i=0;i<ans.length;i++){
        	ll.printList(ans[i]);
        }

    }

}

/*Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input:
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and eachBucketLength element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
Example 2:
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.*/