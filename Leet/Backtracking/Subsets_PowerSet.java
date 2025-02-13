
import java.util.*;

class Subsets{
		
	static void find(List<List<Integer>> ans,int[] arr,List<Integer> sub,int index){

		ans.add(new ArrayList<>(sub));
		for(int i=index;i<arr.length;i++){
			sub.add(arr[i]);
			find(ans,arr,sub,i+1);
			sub.remove(sub.size()-1);
		}

	}
	static void findSubSets(int[] arr){

		List<List<Integer>> ans = new ArrayList<>();
		find(ans,arr,new ArrayList<>(),0);

		for(int i=0;i<ans.size();i++){
			// for(int j=0;j<ans(i).size().j++){
			System.out.print(ans.get(i)+" ");
			// }
		}
	}
	public static void main(String[] args) {
		
		int[] arr = { 1,2,3};

		findSubSets(arr);
	}
}