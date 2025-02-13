class Node{
	int d;
	Node left,right;

	Node(int data){
		d = data;
		left = null;
		right = null;
	}
}

class BT{

	static int preInd = 0;

	int search(char[] in,int d,int s,int e){

		int i;
		for(i=s;i<=e;i++){

			if(in[i] == d){
				return i;
			}
		}
		return i;

	}

	void inorder(Node root){

		if(root==null) return;

		inorder(root.left);
		System.out.print((char)root.d+" ");
		inorder(root.right);

	}
	Node buildTree(char[] in,char[] pre,int s,int e){

		if(s>e) return null;


		Node node = new Node(pre[preInd++]);

		if(s==e) return node;

		int inInd = search(in,node.d,s,e);

		node.left = buildTree(in,pre,s,inInd-1);
		node.right = buildTree(in,pre,inInd+1,e);

		return node;
	}

	public static void main(String[] args) {
		
		BT obj = new BT();

		char[] in = {'D','B','E','A','F','C'};
		char[] pre = {'A','B','D','E','C','F'};

		int len = in.length;

		Node root = obj.buildTree(in,pre,0,len-1);

		System.out.println("INORDER TRAVERSAL : ");
		obj.inorder(root);
	}
}

// BT from INORDER and POSTORDER 

    /**
    * Definition for binary tree
    * class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) {
    *      val = x;
    *      left=null;
    *      right=null;
    *     }
    * }
    */
    public class Solution {

        
        int search(ArrayList<Integer> A,int ele,int s,int e){

            int i;
            for(i=s;i<=e;i++){
                if(ele == A.get(i)){
                    return i;
                }
            }
            return i;
        }

        
        
        TreeNode find(ArrayList<Integer> A, ArrayList<Integer> B,int s,int e,int postS,int postE){


                if(s>e) return null;

                TreeNode root = new TreeNode(B.get(postE));

                if(s==e) return root;
                int inInd = search(A,root.val,s,e);

                root.left = find(A,B,s,inInd-1,postS,postS-s+inInd-1);
                root.right = find(A,B,inInd+1,e,postE-e+inInd,postE-1);

                return root;
            
        }
        public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

                TreeNode ans = find(A,B,0,B.size()-1,0,B.size()-1);

                return ans;
        }
    }
