class PermutationOfString{

	void findPermutation(String s){

		permute(s,0,s.length()-1);
	}

	String swap(String s,int i,int j){
		char ch[] = s.toCharArray();

		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;

		return s;
	}
	//backtracking 
	void permute(String str,int s,int e){

		if(s==e){
			System.out.print(str+" ");
		}
		for(int i=s;i<=e;i++){
			str = swap(str,s,i);
			permute(str,s+1,e);
			str = swap(str,s,i);
		}
	}

	//recursion
	void permutationString(String s,String ansSoFar){

		if(s.length()==0){
			System.out.println(ansSoFar);
			ansSoFar = " ";
		}
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);

			String leftAprt = s.substring(0,i);
			String rightAprt = s.substring(i+1);

			String restOfQue = leftAprt+rightAprt;

			permutationString(restOfQue,ansSoFar+ch);
		}
	}
	public static void main(String[] args) {
			
		PermutationOfString obj = new PermutationOfString();
		// obj.findPermutation("ABC");
		obj.permutationString("ABC"," ");
	}
}