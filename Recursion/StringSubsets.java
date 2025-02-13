class StringSubsets{


	static void helper(String s,String op){

		if(s.length() == 0){
			System.out.print(" \" "+op+" \" ");
			return;
		}

		String op1 = op;
		String op2 = op;

		op2 = op2+s.charAt(0); 
		s = s.substring(1);

		helper(s,op1); 
		helper(s,op2);


	}
	static void stringSubset(String s){

		helper(s,"");
	}
	static void print(int n){
		if(n==1) {
		System.out.print(n+" ");			
			return;
		}

		print(n-1);
		System.out.print(n+" ");
	
	}
	public static void main(String[] args) {

		String s = "abc";
		stringSubset(s);
		// print(7);
	}
}