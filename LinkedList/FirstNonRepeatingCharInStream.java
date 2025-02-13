import java.util.*;

class FirstNonRepeatingCharInStream{
	//USING QUEUE 

	static void findFirstNonRepeating(String A){

		Queue<Character> qu = new LinkedList<>();
        int charCount[] = new int[26];
        
        for(int i=0;i<A.length();i++){
            
            char ch = A.charAt(i);

            qu.add(ch);
            charCount[ch-'a']++;

            while(!qu.isEmpty()){

            	if(charCount[qu.peek()-'a'] > 1){
            		qu.remove();
            	}else{
            		System.out.print(qu.peek()+ " ");
            		break;
            	}
            }

            if(qu.isEmpty()){
            	System.out.print("# ");
            }

        }
	}

	// SUING LINKEDLIST 
	/*static void findFirstNonRepeating(String str){

		List<Character> inDLL = new ArrayList<Character>();

		boolean vis[] = new boolean[26];

		for(int i=0;i<str.length();i++){

			char ch = str.charAt(i);
			// System.out.print()

			if(!vis[ch-'a']){

				if(!(inDLL.contains(ch))){ // if in linked list it dos not contaisn so add directly 
					inDLL.add(ch);
				}else{ // if in linked list it is contains so remove the same char from tbe list 
					inDLL.remove((Character)ch);
					vis[ch-'a'] = true;
				}
			}
			if(inDLL.size()!=0){
				
				System.out.print(inDLL.get(0)+" ");
			}else{
				System.out.print('#' + " ");
			}
		}




	}
*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter string : ");
		String s = sc.next();

		findFirstNonRepeating(s);
	}
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ java FirstNonRepeatingCharInStream
Enter string : aabc
a # b b
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ java FirstNonRepeatingCharInStream
Enter string : abcbbac
a a a a a c #
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ java FirstNonRepeatingCharInStream
Enter string : zz
z #
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ java FirstNonRepeatingCharInStream
Enter string : absbadbsaa
a a a a s s s d d d
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ javac FirstNonRepeatingCharInStream.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/LinkedList
$ java FirstNonRepeatingCharInStream
Enter string : aabbcc
a # b # c #*/