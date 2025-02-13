class Trie{

	class TrieNode{
		Map<Character,TrieNode> child;
		boolean endOfNode;

		TrieNode(){
			child = new HashMap<>();
			endOfNode = false;	
		}
	}

	TrieNode root;
	Trie(){
		root = new TrieNode();
	}

	// ITERATIVE 
	void insert(String word){

		TrieNode curr = root;
		for(int i=0;i<word.length();i++){

			char ch = word.charAt(i);

			TrieNode node = curr.child.get(ch);

			if(node==null){ // not there 
				node = new TrieNode();
				curr.child.put(ch,node);
			}	
			curr = node;
		}
		curr.endOfNode = true;
	}

	//RECURSIVE 

	void insertrecursive(String word){
		insertrecursive(root,word,0);
	}

	void insertrecursive(TrieNode curr,String word,int ind){

		if(ind == word.length()){
			curr.endOfNode = true;
			return;
		}

		char ch = word.charAt(ind);

		TrieNode node = curr.child.get(ch);

		if(node==null){
			node = new TrieNode();
			curr.child.put(ch.node);
		}
		insertrecursive(node,word,ind++);
	}

	// ITERSTIVE 
	boolean searchIterative(String word){

		TrieNode curr = root;

		for(int i=0;i<word.length();i++){

			char ch = word.charAt(i);

			TrieNode node = curr.child.get(ch);
			if(node==null) return false; // node is null at mid so that the word is not found 
			
			curr= node;
		}

		return curr.endOfNode;

	}

	// RECURSIVE 

	boolean searchRecursive(String word){
		return searchRecursive(word,root,0);
	}
	boolean searchRecursive(String word,TrieNode curr,int ind){

		if(ind==word.length()) return curr.endOfNode;

		char ch = word.charAt(ind);
		TrieNode node = curr.child.get(ch);

		if(node==null) 
			return false;
		else
			return searchRecursive(word,node,ind++);
	}

	// RECURSIVE 

	boolean delete(String word){
		return delete(word,root,0);
	}

	boolean delete(String word,TrieNode cur,int ind){

		if(ind==word.length()){

			// when end of word is reacjed only edelete if curr.endOfNode is true

			if(!cur.endOfNode){
				return false;
			}
			cur.endOfNode = false;
			// if curr hasa no other mapping return true
			return cur.child.size()==0;
		}

		char ch = word.charAt(ind);
		TrieNode node= cur.child.get(ch);
		if(node==null) return false;

		boolean shouldDelCurrNode = delete(word,node,ind++);

		//if true is returne then delete the mapping of char and treinode refernce from map 
		if(shouldDelCurrNode){
			cur.child.remove(ch);

			//return true if no mapping is left in map 
			return cur.child.size()==0;
		}
		return false;

	}
}