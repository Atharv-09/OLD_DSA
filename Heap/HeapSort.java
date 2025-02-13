

class HeapSort{

    void heapSort(int arr[]){
        int n = arr.length-1;

        // build heap
        for(int i=n/2;i>=0;i--){
            maxHeapify(arr,n,i);
        }

        //  // One by one extract an element from heap
        for(int i=n;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, i, 0);
        }
    }
    /*ARRAY index from 0
    void heapify(int arr[], int n, int i)
    {
        
      int l = i*2+1;
      int r = i*2+2;
      int lar = i;
      
      if(l<n && arr[l]>arr[lar]){
          lar = l;
      }
      if(r<n && arr[r]>arr[lar]){
          lar = r;
      }
      
      if(lar!=i){
          
          int temp = arr[lar];
          arr[lar] = arr[i];
          arr[i] = temp;
          
          heapify(arr,n,lar);
      }
        // Your code here
    }
    */


    void maxHeapify(int arr[],int n,int pos){

        int lef = 2*pos+1;
        int rig = 2*pos+2;
        // int largest = pos;

        int lar = pos;

        if(lef<n && arr[lef]>arr[lar]){
            lar = lef;
        }

        if(rig<n && arr[rig]>arr[lar]){
            lar = rig;
        }
          
        if(lar!=pos){

          int temp = arr[lar];
          arr[lar] = arr[pos];
          arr[pos] = temp;

          maxHeapify(arr,n,lar);
        }
        // if(left<n && arr[left]>arr[largest]){
        //     largest = left;
        // }
        // if(right<n && arr[right]>arr[largest]){
        //     largest = right;
        // }
        // if(largest!=pos){
        //     // swap(arr,largest,pos);
        //     int swap = arr[pos];
        //     arr[pos] = arr[largest];
        //     arr[largest] = swap;
        //     maxHeapify(arr, n, largest);
        // }
                

    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        
        int arr[] = {12,11,13,5,7,6};
        int n = arr.length;

        HeapSort hs = new HeapSort();
        hs.heapSort(arr);

        printArray(arr);
    }
}