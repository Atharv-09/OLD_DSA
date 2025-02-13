// Recursion by Brute-Force algorithm OR Exhaustive Search.


// we have given items of weight and value(profit) and 1 bag of capacity W 
// we have to add the items in sucaha a way that we have the max profit 
//make sure the weight we added not exceded the bag capacity
 // we cannot add the item fractionally either add item or dont addd item
import java.util.*;

class KnapSack{

	static int KnapSackProfit(int[] val,int wei[],int n,int capacity){

		if(capacity == 0  || n == 0 ) // if there were no items or bag capacity is 0
			return 0;

		if(capacity >= wei[n-1]){
			// by including the weight or by not includng the weight the max is returned 
			return (Math.max(
					val[n-1]+KnapSackProfit(val,wei,n-1,capacity-wei[n-1]),
					KnapSackProfit(val,wei,n-1,capacity)));


		}
		// or if the item weight is greater the capacity of kanpsack then we wil not include that item 
		else{ //capacity < wei[n-1]
			return KnapSackProfit(val,wei,n-1,capacity);
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter total items count : ");
		int  n = sc.nextInt();

		int[] wei = new int[n];
		int[] val = new int[n];

		System.out.print("Enter items value : ");
		for(int i=0;i<n;i++){
			val[i] = sc.nextInt();
		}

		System.out.print("Enter items weight : ");
		for(int i=0;i<n;i++){
			wei[i] = sc.nextInt();
		}

		System.out.print("Enter KnapSack capacity : ");
		int cap = sc.nextInt();

		int maxProfit = KnapSackProfit(val,wei,n,cap);

		System.out.println("Maximum profit is  : " + maxProfit);
	}
}