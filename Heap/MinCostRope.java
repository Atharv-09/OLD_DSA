import java.util.Scanner;

class Main{
    int maxSize;
    int cap;
    int heap[];

    Main(int arr[],int n){

        maxSize = n;
        cap = n;
        heap = arr;

        int size = (n-1)/2;
        while(size>=0){
            minHeapify(size);
            size--;
        }
    }

    void minHeapify(int index){

        int currMin = index;
        int li = 2*index+1;
        int ri = 2*index+2;

        if(li<maxSize && heap[li]<heap[ri]){
            if(heap[li] < heap[currMin]){
                swap(li,currMin);
                minHeapify(li);
            }
        }
        else if(ri<maxSize){
            if(heap[ri] < heap[currMin]){
                swap(ri,currMin);
                minHeapify(ri);
            }
        }
    }

    int extractMin(){

        if(maxSize<=0){
            return Integer.MAX_VALUE;
        }
        if(maxSize == 1){
            maxSize--;
            return heap[0];
        }

        int temp = heap[0];
        heap[0] = heap[maxSize-1];
        maxSize--;
        minHeapify(0);

        return temp;
    }
    void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    void add(int ele){
        maxSize++;
        int curr = maxSize-1;
        
        heap[curr] = ele;
        int par = (curr-1)/2;
        while(heap[par] > heap[curr]){
            swap(par,curr);
            curr = par;
        }
    }
    boolean isSizeOne(){
        return(maxSize == 1);
    }
    static int minCost(int arr[],int n){

        Main m = new Main(arr,n);

        int totalCost = 0;

        while(!m.isSizeOne()){

            int val1 = m.extractMin();
            int val2 = m.extractMin();
        
            totalCost+= (val1+val2);
            m.add(val1+val2);

        }
        return totalCost;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter arr : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        int ans = minCost(arr,size);
        System.out.println("MIN COST OF ROPES : " + ans);
    }
}