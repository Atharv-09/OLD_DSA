import java.util.*;

class Node{

	Node left,right;
	int data;

	Node(int data){
		this.data = data;
		left=right=null;
	}
}

class BT{

	static Node root;
	static Scanner sc = new Scanner(System.in);

    static Node createTree(){

        Node root = null;
        System.out.print("Enter data : ");
        int in = sc.nextInt();

        if(in==-1) return null;

        root = new Node(in);

        System.out.print("Enter left for " + in + " : ");
        root.left = createTree();

        System.out.print("Enter right for " + in + " : ");
        root.right = createTree();

        return root;

    }

    static ArrayList<Node> path ;

    boolean findNodeToRoot(Node node,int data){

    	if(node==null) return false;

    	if(node.data==data){
    		path.add(node);
    		return true;
    	}
    	boolean lef = findNodeToRoot(node.left,data);
    	if(lef){
    		path.add(node);
    		return true;
    	}

    	boolean rig = findNodeToRoot(node.right,data);
    	if(rig){
    		path.add(node);
    		return true;
    	}
    	return false;

    }

    void printKLevelsDownFromtargetNode(Node node,int kLevel,Node blocker){

    	if(node==null || kLevel<0 || node==blocker) return ;

    	if(kLevel==0)
    		System.out.print(node.data);

    	printKLevelsDownFromtargetNode(node.left,kLevel-1,blocker);
    	printKLevelsDownFromtargetNode(node.right,kLevel+1,blocker);


    }

    void printKNodesFar(Node node,int data,int k){

    	path = new ArrayList<>();
    	findNodeToRoot(node,data); // for node to root path 

    	for(int i=0;i<path.size();i++){

    		// print all the k-i dist from the target node 
    		//we pass first as the blocker 
    		// fpr first it has no one bloacker 
    		printKLevelsDownFromtargetNode(path.get(i),k-i,i==0 ? null : path.get(i-1));

    	}

    }
	public static void main(String[] args) {
		
		root = createTree();

		System.out.print("Enter target node : ");
		int target = sc.nextInt();

		System.out.print("Enter k : ");
		int k = sc.nextInt();

		BT bt = new BT();
		bt.printKNodesFar(root,target,k);
	}
}