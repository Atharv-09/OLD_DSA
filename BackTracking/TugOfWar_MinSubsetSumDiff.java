import java.util.*;
//we have given array 
//we have to make 2 subset such a that
//if arrays size is even make n/2 n/2 size subset 
//if arrays size is odd make n-1/2 n+1/2 size subset 
//add item such that element are placed in sets suchh  that SUM(subset1)-SUM(subset2) has minimum value 
/*For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10. Output for this set should be {4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}. Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).
Let us consider another example where n is odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}. The output subsets should be {45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}. The sums of elements in two subsets are 120 and 121 respectively.*/
class TugOfWar{


	//vIndex tell on zeroth longevel arr[0] solvce
	//on 1 level arr[1] solce as we see in tree 

	int minDiff = Integer.MAX_VALUE;
	String ans = " ";
	void tugOfWar(int arr[],int vIndex,ArrayList<Integer> set1,ArrayList<Integer> set2,int set1Sum,int set2Sum){


		//base case 
		if(vIndex==arr.length){

			//now we have to print that set whose diff is min
			int getdiff = Math.abs(set1Sum-set2Sum);
			if(getdiff<minDiff){
				minDiff = getdiff;
				ans = set1 + " " + set2;
			}

			return;
		}


		// for(int i=0;i<arr.length;i++){

			// first add into set 1
		//here we had done optimization
		//if one set is exceeding the limit of set given then dont go for that depth 
			if(set1.size() < (arr.length+1)/2){ // to handle both even/odd size set 
				set1.add(arr[vIndex]);
				tugOfWar(arr,vIndex+1,set1,set2,set1Sum+arr[vIndex],set2Sum);
				set1.remove(set1.size()-1); // as we backtrack to go on right side of tree it is compulosory n
				//to keep set as it was earlier 
			}
			if(set2.size() < (arr.length+1)/2){
				set2.add(arr[vIndex]);
				tugOfWar(arr,vIndex+1,set1,set2,set1Sum,set2Sum+arr[vIndex]);
				set2.remove(set2.size()-1); 
			}
		// }

	}
	void minSubsetSumDiff(int arr[],int len){

		tugOfWar(arr,0,new ArrayList<>(),new ArrayList<>(),0,0);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter array size : ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i] = sc.nextInt();
		}
		TugOfWar tow = new TugOfWar();
		tow.minSubsetSumDiff(arr,size);

		System.out.println(tow.ans);
	}
}