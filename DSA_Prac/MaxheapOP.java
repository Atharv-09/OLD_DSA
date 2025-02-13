
import java.util.*;

class MaxHeap{

	int heapSize;
	private int size;
	static int arr[];

	MaxHeap(int hs){

		heapSize = hs;
		size =0;
		arr = new int[heapSize+1];
		arr[0] = Integer.MAX_VALUE;

	}
	static void swap(int a,int b){

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;	
	}

	 void insertMaxHeap(int value){

	 	if(size>heapSize){
	 		System.out.println("heap is full");
	 		return;
	 	}

		arr[++size] = value;

		int curIdex = size;

		
		while(arr[curIdex]>arr[curIdex/2]){

			swap(curIdex,curIdex/2);
			
			curIdex = curIdex/2;
		}

	}

	 void printMaxHeap(){

		for(int i=1;i<=size/2;i++){
			System.out.println("Parent : " +arr[i] + " Left child : " + arr[2*i] + " Right child : " + arr[2*i+1]);
		}
	}

	boolean leaf(int pos){

		if(pos>size/2 && pos<= size){
			return true;
		}

		return false;
	}
	void maxHeapify(int pos){


		if(!leaf(pos)){

			if(arr[pos*2]>arr[pos] || arr[pos*2+1]>arr[pos]){ //go for left 

				if(arr[pos*2]>arr[pos*2+1]){
					
					swap(pos,pos*2);
					maxHeapify(pos*2);
				}else if(arr[pos*2]<arr[pos*2+1]){

					swap(pos,pos*2+1);
					maxHeapify(pos*2+1);
				}
			}
		}

	}
	int extractMax(){

		int pop = arr[1];
		arr[1] = arr[size--];

		maxHeapify(1);
		return pop;

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);


		System.out.println("Enter heapSIze : ");
		int heapsize = sc.nextInt();

		System.out.println("Enter arrSize : ");
		int size = sc.nextInt();

		if(heapsize<size) {

			System.out.println("full");
			return;

		}
		MaxHeap mh= new MaxHeap(heapsize);

		for(int i=0;i<size;i++){

			System.out.print("Enter ele : ");
			mh.insertMaxHeap(sc.nextInt());
		}



		mh.printMaxHeap();

		System.out.println("Maximum element  : " + mh.extractMax());
		// insert(12);
		// maxheapify();
				mh.printMaxHeap();

	}
}