class Node{

	int data;
	Node next;

		Node(int data){

			this.data = data;
			next = null;
		}
}

class SLL{
	
	Node root=null;

	void printList(){
		Node temp = root;
		if(temp==null) return;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}

	}

	void insertAtBegin(int num){

			Node newNode= new Node(num);
			newNode.next = root;
			root=newNode;

	}

	void insertAtMid(int prevNum,int newNum){

			Node temp = root;
			while(temp!=null){

				if(temp.data==prevNum){
					break;
				}
				temp = temp.next;
			}

			Node newNode = new Node(newNum);
			newNode.next = temp.next;
			temp.next = newNode;

	}
	void insertAtEnd(int num){

		Node temp = root;

		while(temp.next!=null){

			temp = temp.next;
		}

		Node newNode = new Node(num);
		temp.next=newNode;
		newNode.next=null;

	}

	void deleteWithHeadPointer(Node nodeToDel){

			Node temp = root;
			Node prev=null;
			if(temp!=null && temp==nodeToDel){
				root = temp.next;
				return;	
			}

			while(temp!=null && temp!=nodeToDel){

				prev = temp;
				temp = temp.next;
				
			}

			// temp.next = temp.next.next;
			//2 way 
			if(temp==null) return;
			prev.next = temp.next;


	}

	void deleteWithoutHeadPointer(Node nodeToDel){

		if(nodeToDel.next==null){
			System.out.print("tail node");
			return;
		}

		Node nextNode = nodeToDel.next;
		nodeToDel.data = nextNode.data;
		nodeToDel.next = nextNode.next;

		nextNode= null;
	
	}
	public static void main(String[] args) {
			
		SLL sl = new SLL();
		sl.root = new Node(10);
		sl.root.next  = new Node(13);
		sl.root.next.next = new Node(91);
		sl.root.next.next.next = new Node(12);


		sl.printList();

		sl.insertAtBegin(3223);
		System.out.println();

		sl.printList();

		sl.insertAtMid(13,76);
		System.out.println();

		sl.printList();

		sl.insertAtEnd(1);
		System.out.println();
		
		sl.printList();

		
		Node temp = sl.root;

		while(temp!=null){

			if(temp.data==3223){
				break;
			}
			temp = temp.next;
		}

		// sl.deleteWithHeadPointer(temp);
		// System.out.println();
		
		// sl.printList();

		sl.deleteWithoutHeadPointer(temp);
		System.out.println();
		
		sl.printList();

	}
}