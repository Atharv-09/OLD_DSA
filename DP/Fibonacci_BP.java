// BOTTOM UP 
// Tabulation 

// we will calculate for 0 1 then from this subproblem we go to n 

// FIBONACCI MEANS CURR NUM = sum of last 2 nums 

import java.util.*;

class Fibonacci{
	/*
	//RECURSION (Time: exponential) (space: O(n))

	static int fib(int n){

		if(n==1 || n==2) return 1;

		return fib(n-1)+fib(n-2);
	}

	*/


	//TIME : Exponential  SPACE : O(n) 
	static int fib(int n){

		int f[] = new int[n+2];
		int f[0] = 0;
		int f[1] = 1;

		for(int i=2;i<=n;i++){
			f[i] = fib[i-1]+fib[i-2];
		}

		return f[n];

	}

	// OPTIMSED SPACE 
	// TINE : O(n) SPACE : O(1)


	static int fib(int n){

		int a = 0,b=1,c;
		if(n==0) return a;

		for(int i=2;i<=n;i++){
			c = a+b;
			a = b;
			b = c;
		}
		return b;
	}

	
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);

		System.out.print("Enter number : " );
		int num = sc.nextInt();


		int ans = fib(num); 
	
		System.out.println("FIBONACCI F"+num+" = " + ans);


	}
}