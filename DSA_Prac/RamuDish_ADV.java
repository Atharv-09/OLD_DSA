import java.util.*;

class Main{


	static int find(int n,int[] arr){

		HashMap<Integer,Integer> map = new HashMap<>();

		int last = -1;
		boolean lastFound = false;
		for(int i=0;i<n;i++){

			if(map.containsKey(arr[i])){
				//check that its last is not same 

				if(last==arr[i]){
					lastFound = true;
				}else{
					map.put(arr[i],map.get(arr[i])+1);
				}
			}else{
				map.put(arr[i],1);
			}
			if(lastFound) last = -1;
			else last = arr[i];
		}

		// Iterator it = map.iterator().entrySet();
		
		int maxValueTillNow=0;
		int maxValueKey=0;

		for(Map.Entry<Integer,Integer> ent : map.entrySet()){

			int val = ent.getValue();
			int key = ent.getKey();

			if(val>maxValueTillNow){
				maxValueTillNow = val;
				maxValueKey = key;
			}
		}

		return maxValueKey;
	}

	public static void main(String[] args) {
		

		int n =8;
		int[] arr = {1,2,2,2,3,4,2,1};

		System.out.println(find(n,arr));
	}
}