import java.util.*;


class q{

	public static void main(String[] args){

		HashMap<Integer,Integer> map = new HashMap<>();
			
		int arr[] = {1,2,1,3,2,1,1,4,3};

		for(int i=0;i<arr.length;i++){
	
			if(map.containsKey(arr[i])){
				
				map.put(arr[i],map.get(arr[i])+1);
			}else{
			
				map.put(arr[i],1);

			}

		}

		for(Map.Entry<Integer,Integer> ent : map.entrySet()){

			System.out.println(ent.getKey()+" " + ent.getValue());
		}
	}
}
