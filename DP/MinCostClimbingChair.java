import java.util.*;

class MinCosrClimbingChair{

	static int minCostClimbingStair(int[] cost,int len){

		for(int i=2;i<len;i++){
			cost[i] += Math.min(cost[i-1],cost[i-2]);
		}

		return Math.min(cost[cost.length-1],cost[cost.length-2]);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter length : ");
		int len = sc.nextInt();

		System.out.println("Enter cost : ");
		int[] cost = new int[len];
		for(int i=0;i<len;i++){
			cost[i] = sc.nextInt();
		}

		minCostClimbingStair(cost,len);
	}
}
