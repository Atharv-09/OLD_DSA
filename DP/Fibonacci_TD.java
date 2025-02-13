import java.util.*;

class Fibonacci{

	int MAX = 100;
	static int dp[] = new int[MAX];

	// In fibonacci memorisation not work
	//because every time we getting new solution for evry subprolem so it only folow bottom up approach 
	static int fib(int n){

		if(n==0) return 0;
		if(n==1) return 1;	


	}
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);

		System.out.print("Enter number : " );
		int num = sc.nextInt();


		int ans = fib(num); 
	
		System.out.println("FIBONACCI F"+num+" = " + ans);

		Arrays.fill(dp,-1);
	}
}