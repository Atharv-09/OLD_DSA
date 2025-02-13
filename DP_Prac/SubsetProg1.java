class Subset{

	static void findSubSets(String s,String ans,int i){

		int n = s.length();
		if(n == i){
			System.out.println("\"" + ans + "\"");
			return;
		}
		findSubSets(s,ans+s.charAt(i),i+1);
		findSubSets(s,ans,i+1);

	}	
	public static void main(String[] args) {
			
		findSubSets("abc","",0);

	}
}