class Main{


	public static void main(String[] args) {
		
		String s = "I love myself because selflove is important";

		// String[] str = s.split(" ");

		String ans = "";

		String str = "";

		// reversing the string words
		for(int i=0;i<s.length();i++){

			if(s.charAt(i)==' '){
				ans = str + " " +ans;
				str = "";
			}else
				str = str + s.charAt(i);
		}

		ans = str+" " +ans;
				System.out.println(ans);


		// whole word and also the string reversal 
		char arr[] = s.toCharArray();

		int lastInd = arr.length-1;
		for(int i=0;i<arr.length/2;i++){

			

			char temp = arr[i];
			arr[i] = arr[lastInd];
			arr[lastInd] = temp;

			lastInd--;

		}
		for(char c:arr){
			System.out.print(c);
		}
		// System.out.println(s);

	}
}