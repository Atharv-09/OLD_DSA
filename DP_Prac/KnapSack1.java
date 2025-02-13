import java.util.*;

class Knapsack{

	// TIME : O(2^n)
	static int knapSack(int[] wt,int[] val,int cap,int n){

		if(cap==0 || n==0) return 0;

		// if weight of curr item is less then bag capacity 

		if(wt[n-1] > cap){
			int ansN = knapSack(wt,val,cap,n-1);
			return ansN;
		}else{
			int ansI = Math.max(knapSack(wt,val,cap,n-1),val[n-1]+knapSack(wt,val,cap-wt[n-1],n-1));
			return ansI;
		}
	}
	public static void main(String[] args) {
		
		int[] wt = {1,3,4,6};
		int[] val = {20,30,10,50};
		int w = 10;

		System.out.println(knapSack(wt,val,w,4));
	}
}