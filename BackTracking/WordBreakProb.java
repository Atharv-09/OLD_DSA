
import java.util.*;

class WordBreakProb{

	static void wordBreak(String s){

		wordBreakUtil(s,s.length()," ");
	}

	static boolean containsInDict(String word){


		String[] dist = {"mobile","samsung","sam","sung","man","mango", "icecream","and","go","i","love","ice","cream"};
		
		// for(int i=0;i<dist.length;i++){
			// if(dist[i].equals(word))
		if(Arrays.asList(dist).contains(word))
				return true;
		// }
		return false;


	}
	static void wordBreakUtil(String str,int size,String ans){

		for(int i=1;i<=size;i++){

			String prefix = str.substring(0,i);

			if(containsInDict(prefix)){
				//if we reached at end of string 
				if(i==size){

					ans+=prefix;
					System.out.println(ans);
					return;

				}else{
					wordBreakUtil(str.substring(i,size-i),size-i,ans+prefix+" ");
				}

			}
		}

	}
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter string : ");
			String s = sc.next();

			wordBreak(s);
	}
}