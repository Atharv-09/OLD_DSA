import java.util.*;

class GenerateParenthesis{

	 static public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        
        backtrack(n,ans,0,0,"");
        
        return ans;
    }
    
    static void backtrack(int n,List<String> out_arr,int open,int close,String ans){
        
        if(n*2 == ans.length()){
            out_arr.add(ans);
            return;
        }
        
        if(open<n)
            backtrack(n,out_arr,open+1,close,ans+"(");
        if(close<open)
            backtrack(n,out_arr,open,close+1,ans+")");
    }
	public static void main(String[] args) {
			
		int n = 4;
		List<String> ans = generateParenthesis(n);

		for(int i=0;i<ans.size();i++){
			System.out.print(ans.get(i)+"  ");
		}
	}
}