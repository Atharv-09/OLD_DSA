import java.util.*;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
*/
class DecodeString{

	static String decode(String s){

		Stack<Integer> counts = new Stack<>();
		Stack<String> result = new Stack<>();
		String ans = "";
		int index = 0;

		while(s.length() > index){

			// if the char is digit 

			if(Character.isDigit(s.charAt(index))){
				
				int count = 0;	
				// if we have given more then 1 digit so 
				while(Character.isDigit(s.charAt(index))){
					count = count*10 + (s.charAt(index)-'0'); /// strung: 30[a] -- > for 30 to get we have done this if it was single digit so dorec thappen
					index++; // till we get coreect num 
				}
				counts.push(count);
			}else if(s.charAt(index) == '['){

				result.push(ans);
				ans = ""; // as [ char is get then we added to result so to remove this 
				index++;
			} else if(s.charAt(index) == ']') {

				StringBuilder sb = new StringBuilder(result.pop()); // take the string 
				int count =counts.pop(); // take the count 

				for(int i=0;i<count;i++){
					sb.append(ans);
				}
				ans = sb.toString();
				index++;
			} else{
				ans += s.charAt(index);
				index++;
			}
			
		}
		return ans;
}
	/*static void decode(StringBuilder sb){
		Stack<Character> st = new Stack<>();
		// st.push(sb.charAt(0));
		StringBuilder ans = new StringBuilder();
		boolean pushIt = false;
		for(int i=0;i<sb.length();i++){
			char ch = sb.charAt(i);
			
			if(ch=='[') pushIt =false;


			if(ch==']' || pushIt==true){
				st.push(ch);
				pushIt = true;

			}else if(ch=='['){
				pushIt = false;
				int howMuch = (int)sb.charAt(i+1);
				// System.out.println(howMuch);
				// int times = 0;
				StringBuilder newStr = new StringBuilder();
				while(st.size()>0){
					char top = st.pop();
					if(top!=']'){
						newStr.append(top);
					}
				}

				for(int j=0;j<howMuch;j++){
					ans.append(newStr);
				}
				i++;
				
			}else{
				ans.append(ch);
				pushIt = false;
			}
		}

		System.out.println("Encoded string : "+ ans);

	}*/
	public static void main(String[] args) {
		
		String s = "2[abc]3[cd]ef";

		// StringBuilder sb = new StringBuilder(s);
		// System.out.println("Decoded string :  "+sb );
		// sb.reverse();
		// System.out.println("Reverse decoded string :  "  +sb);

		// decode(sb);
		
		String ans = decode(s);
		System.out.println(ans);
	}
}


/*class Solution {
    public String decodeString(String s) {
        char[] str=s.toCharArray();
        int n=str.length;
        
        int[] index=new int[n];
        setIndex(index,str);
        
        return decodeString(index,str,0,n);
    }
    
    private String decodeString(int[] index,char[] str,int start,int end){
        StringBuilder res=new StringBuilder();
        for(int i=start;i<end;i++){
            if(str[i]>='a' && str[i]<='z'){
                res.append(str[i]);
            }else{
                int times=0;
                while(str[i]>='0' && str[i]<='9'){
                    times=times*10+(str[i]-'0');
                    i++;
                }
                //System.out.println(str[i]);
                String val=decodeString(index,str,i+1,index[i]);
                while(times-->0){
                    res.append(val);
                }
                i=index[i];
            }
        }
        return new String(res);
    }
    
    private void setIndex(int[] index,char[] str){
        int[] stack=new int[str.length];
        int top=-1;
        
        for(int i=0;i<str.length;i++){
            if(str[i]=='['){
                stack[++top]=i;
            }else if(str[i]==']'){
                index[stack[top--]]=i;   
            }
        }
    }
}*/