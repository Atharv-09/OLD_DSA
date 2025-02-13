import java.util.*;
class Pair implements Comparable<Pair>{

		int num;
		String binForm;
		int totalOne;

		Pair(int num,String binForm,int totalOne){
			this.num = num;
			this.binForm = binForm;
			this.totalOne = totalOne;
		}
		public int compareTo(Pair p){

			if(p.totalOne==this.totalOne){
				return p.num-this.num;
			}
			return p.totalOne-this.totalOne;
		}
}
class Main{

	static List<Integer> find(int n,int arr[],int m){

		String[] str = new String[n];

		for(int i=0;i<n;i++){
			str[i] = Integer.toBinaryString(arr[i]);
		}

		// for(int i=0;i<n;i++){
		// 	System.out.println(str[i]);
		// }
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

		for(int i=0;i<n;i++){

			String s = str[i];
			int count = 0;
			for(int j=0;j<s.length();j++){

				char ch = s.charAt(j);

				if(ch=='1'){
					count++;
				}
			}
			pq.add(new Pair(arr[i],s,count));
		}

		List<Integer> ans = new ArrayList<>();

		while(!pq.isEmpty()){

			Pair p = pq.poll();

			if(m>0){
				ans.add(p.num);
				m--;
			}
			// System.out.println(p.num +" = " + p.binForm + " = " + p.totalOne);	

			pq.remove(p);
		}

		return ans;
	}
	public static void main(String[] args) {
		
		int n = 5;
		// {5,9,8,7,16}
		int arr[] = {6,7,12,18,17};
		int m=3;

		List<Integer> ans = find(n,arr,m);

		for(int i=0;i<ans.size();i++){
			System.out.print(ans.get(i)+" ");
		}
	}
}