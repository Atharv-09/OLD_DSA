
import java.util.*;

class SubsetSum{
	static int nodeCount;

	static void printSubset(int tuple[],int size){
		for(int i=0;i<size;i++){
			System.out.print(tuplet [i]+" ");
		}
		System.out.println();
	}
	static void subsetSum(int wei[],int tuplet[],int size,int t_size,int sum,int ite,int target_Sum){

		nodeCount++;

		if(target_Sum==sum){
			printSubset(tuplet,t_size);

			//exclude prev added element and consider next candidate 
			subsetSum(wei,tuplet,size,t_size-1,sum-wei[ite],ite+1,target_Sum);
			return;
		}else{

			for(int i=ite;i<size;i++){
				 tuplet[t_size] = wei[i];
				  // Consider next level node (along depth)
				 subsetSum(wei,tuplet,size,t_size+1,sum+wei[i],i+1,target_Sum);
			}
		}


	}

	static void generateSubSet(int wei[],int size,int target_Sum){

		int tuplet[] = new int[size];
		subsetSum(wei,tuplet,size,0,0,0,target_Sum);

		Arrays.fill(tuplet,0);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter array size : ");
		int s = sc.nextInt();

		int wei[] = new int[s];

		for(int i=0;i<s;i++){
			wei[i] = sc.nextInt();
		}

		System.out.print("Enter target weight : ");
		int tWei = sc.nextInt();

		generateSubSet(wei,s,tWei);

		System.out.println("Total nodes : " + nodeCount);
	}
}