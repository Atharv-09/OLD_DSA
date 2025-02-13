import java.util.*;

class Main{


	void merge(int s,int e,int mid,int[] arr){

		int n1 = mid-s+1;
		int n2 = e-mid;

		int lef[] = new int[n1];
		int rig[] = new int[n2];

		for(int i=0;i<n1;i++)
			lef[i] = arr[s+i];

		for(int j=0;j<n2;j++)
			rig[j] = arr[mid+1+j];

		int i=0,j=0,k=s;

		while(i<n1 && j<n2){

			if(lef[i]>=rig[j]){
				arr[k] = rig[j];
				j++;
				// k++;
			}else{
				arr[k] = lef[i];
				i++;
				// k++;
			}

			k++;
		}

		while(i<n1){
			arr[k]=lef[i];
			i++;
			k++;
		}

		while(j<n2){
			arr[k] = rig[j];
			j++;
			k++;
		}

	}
	void sortArr(int arr[],int s,int e){

		if(s<e){

			int mid = s+(e-s)/2;
			sortArr(arr,s,mid);
			sortArr(arr,mid+1,e);

			merge(s,e,mid,arr);
		}
	}
	public static void main(String[] args) {
		


		int a[] = new int[]{3,2,2,4,5,6,1,3,2,4,2,3,1,3,4,5};
		Integer arr[] = new Integer[a.length];

		for(int i=0;i<a.length;i++){
			arr[i] = Integer.valueOf(a[i]);
		}


		//new Main().sortArr(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();

		List<Integer> list = Arrays.asList(arr);

		HashMap<Integer,Integer> hm = 	new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> hmInd = new HashMap<Integer,Integer>();


		for(int i=0;i<arr.length;i++){

			if(!hm.containsKey(arr[i])){
				hm.put(arr[i],1);
				hmInd.put(arr[i],i);
			}else{
				hm.put(arr[i],hm.get(arr[i])+1);
			}

		}	

		// sort the value on basis of their values


		Collections.sort(list,new Comparator<Integer>(){

			public int compare(Integer n1,Integer n2){
				int f1 = hm.get(n1);
				int f2 = hm.get(n2);


				if(f1!=f2){
					return f1-f2;
				}else{
					return hmInd.get(n1)-hmInd.get(n2);
				}
			}
		});

		// Collections.sort(list,sorByVal);


		for(int i:list){
			System.out.print(i+" ");
		}
	}
}