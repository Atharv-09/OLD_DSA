class Main{

	boolean find(String s1, String s2,int swap,int s,int e){

		if(swap==s1.length()-1) return false;

		String swapStr = s1.substring(s,e);
		StringBuilder sb = new StringBuffer(swapStr);
		sb.reverse();

		String newStr = sb.toString()+s1;
		
		if(newStr.equals(s2)) return true;


		find(newStr,s2,swap++,s,e+1);
		


	}

	public static void main(String[] args) {
		
		String s1 = "1010";
		String s2 = "0011";

		//HERE LOOP TO CHECK IF number of 1 in 1st string is same as count number of 1 in 2nd string 
		
		find(s1,s2,0,2);
	}
}