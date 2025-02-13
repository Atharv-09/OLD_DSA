
import java.util.*;
class InvalidParenthesisRemoval{

	// how many minimum bracket we have to remove to get balanced 
	//is expression is valid or not 

	// 
	static int getMin(String s){

		Stack<Character> st = new Stack<>();

		for(int i=0;i<s.length();i++){
			//if it is ( then push always into stack
			if(s.charAt(i) == '('){
				st.push('(');
			}else if(s.charAt(i) == ')'){ // if paren is )
				//if stack size if 0 then pus
				//if in stack top there is ( then pop (
				//if in stack top there is ) then push ) 
				if(st.size()==0)
					st.push(')');
				else if(st.peek() == '(')
					st.pop();
				else if(st.peek() == ')')
					st.push(')');
			}
		}

		return st.size();

	}
	static void invalidParenthesis(String str,int minRemovalAllow,HashSet<String> ans){

		if(minRemovalAllow==0){ // check the string we get is valid or not by pushign into stack
			int isValid = getMin(str);
			//if stack size is 0 then the string is valid 
			if(isValid==0){
				//check is the str we get is not in ans already if not then push it into ans
				if(!ans.contains(str)){
					System.out.println(str);
					ans.add(str);
				}
			}
			return;
		}
		 for(int i=0;i<str.length();i++){

		 	String lef = str.substring(0,i);
		 	String rig = str.substring(i+1);

		 	String newStr = lef+rig;
		 	invalidParenthesis(newStr,minRemovalAllow--,ans);
		 }

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter parenthesis string : ");
		String s = sc.next();

		int minRemoval = getMin(s);
		invalidParenthesis(s,minRemoval,new HashSet<>()); 	

	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/BackTracking
$ java InvalidParenthesisRemoval
Enter parenthesis string : ()())()
()()
(())()

*/