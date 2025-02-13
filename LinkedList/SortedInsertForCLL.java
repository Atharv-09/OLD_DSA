
//TINE : O(n) -- > as in inorder n is no of nodes 
// SPace : O(h)
import java.util.*;

class Node{
	Node next;
	int data;
}

class CLL{

	static Node last;

	static Node insertAtFirst(int data){

		if(last!=null) return last;

		Node newNode = new Node();
		newNode.data = data;
		last = newNode;
		newNode.next = newNode;

		return last;

	}
	static Node insertAtEnd(int data){

		if(last==null){
			return insertAtFirst(data);	
		}

		Node newNode = new Node();
		newNode.data = data;
		newNode.next = last.next;
		last.next = newNode;
		last = newNode;

		return last;

	}

	static void print(Node node){

		if(node==null) System.out.println("CLL is empty");
		else{
			Node first = node;
			
			while(first!=last){
				System.out.print(first.data +" ");
				first = first.next;
				
			}
		}

	}

	static Node insertDataAtProperPos(int data){

		 	Node head = last.next;
		 	Node node = head;
            
            if(node==null){
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = newNode;
                head = newNode;
            }else if(node.data>=data){ // it it is first node 
                Node newNode = new Node();
                newNode.data = data;
                while(node.next!=head)
                    node = node.next;
                node.next = newNode;
                newNode.next = head;
                head = newNode;
                // break;
            }else{
                    // if the node is greapter then last node 
                    //or any middle node if 
                while(node.next.data<data && node.next!=head){
                    node = node.next;
                }
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = node.next;
                node.next = newNode;
            }

            return head;

	}
	public static void main(String[] args) {
			
			CLL obj = new CLL();
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter node count : ");
			int c = sc.nextInt();
			System.out.print("Enter data : ");

			for(int i=0;i<c;i++){
				last = insertAtEnd(sc.nextInt());
			}


			System.out.print("Enter nodedata to be inserted : ");
			int da = sc.nextInt();

			Node ans = insertDataAtProperPos(da);
			print(ans);
	}
}

