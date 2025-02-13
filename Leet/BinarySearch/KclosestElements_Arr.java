import java.util.*;

class KClosest{

	// class Pair implements Comparable<Pair>{

	// 	int absDiff; // array[i] - element 
	// 	int number;

	// 	Pair(int ad,int n){
	// 		absDiff = ad;
	// 		number = n;
	// 	}

	// 	public int compareTo(Pair p){
	// 		return this.absDiff-p.absDiff;
	// 	}
	// }


	// void KClosestElements(int[] arr,int k,int x){

	// 	PriorityQueue<Pair> pq = new PriorityQueue<>();

	// 	for(int i=0;i<arr.length;i++){
	// 		if(i<k)
	// 			pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));
	// 	}

	// 	while(pq.size()>0){

	// 		Pair p = pq.poll();
	// 		System.out.println(p.number);

	// 	}



	// }
	@SuppressWarnings("unchecked")
	void KClosestElements(int[] arr,int k,int x){

		HashMap<Integer,PriorityQueue<Integer>> hm = new HashMap<>();

		for(int i=0;i<arr.length;i++){

			int diff = Math.abs(arr[i]-x);
			if(hm.containsKey(diff)){
				PriorityQueue<Integer> pq = hm.get(diff);
				pq.add(arr[i]);
				hm.put(diff,pq);
			}else{
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				pq.add(arr[i]);
				hm.put(diff,pq);
			}
		}

		System.out.println(hm);

        PriorityQueue<Integer> key = new PriorityQueue();
        for(int p:hm.keySet()){
            key.add(p);
        }
        System.out.println(key);
        

        ArrayList<Integer> ans = new ArrayList();
        int cnt=0;
        while(cnt != k)
        {
           int a= key.poll();
            PriorityQueue<Integer> list = hm.get(a);
            while(cnt != k && list.size() >0){
                ans.add(list.poll());
                cnt++;
            }
        }
		Collections.sort(ans);
       	
       	for(int i=0;i<ans.size();i++){
       		System.out.print(ans.get(i));
       	} 
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter array size : ");
		int s = sc.nextInt();

		System.out.print("Enter array : ");
		int[] arr = new int[s];

		for(int i=0;i<s;i++){
			arr[i] = sc.nextInt();
		}

		System.out.print("Enter k : ");
		int k = sc.nextInt();

		System.out.print("Enter element : ");
		int ele = sc.nextInt();

		new KClosest().KClosestElements(arr,k,ele);
	}
}


/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/BinarySearch
$ javac KclosestElements_Arr.java

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/BinarySearch
$ java KClosest
Enter array size : 5
Enter array : 1 2 3 4 5
Enter k : 4
Enter element : 3
{0=[3], 1=[2, 4], 2=[1, 5]}
[0, 1, 2]
1234
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/BinarySearch
$ java KClosest
Enter array size : 6
Enter array : 1 1 1 10 10 10
Enter k : 1
Enter element : 10
{0=[10, 10, 10], 9=[1, 1, 1]}
[0, 9]
10
*/