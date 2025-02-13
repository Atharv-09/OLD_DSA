import java.util.*;

class MinHeap{

    private int[] Heap;
    int maxSize;
    int size;
    private static final int FRONT = 1; 


    MinHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[maxSize];
        // as we store the elemnt in heap from index 1 
        // coz if we take i=0 then for left child = 2*i = 2 * 0 = 0 but the left child is at index 1 
        // 10 30 20 35 40 32 25 
        // 1  2  3  4  5  6  7 
        // left child of 10 = 2*i = 2*1 = at posi 2 
        // right child of 10 = 2*i+1 = 2*1 + 1 = at posi 3 
        Heap[0] = Integer.MIN_VALUE;
    }
    int leftChild(int pos){
        return(2*pos);  
    }
    int rightChild(int pos){
        return(2*pos + 1);
    }
    int parent(int pos){
        return(pos/2);
    }

    void swap(int ind1,int ind2){
        int temp = Heap[ind1];
        Heap[ind1] = Heap[ind2];
        Heap[ind2] = temp;
    }

    // INSERTION LOG N 
    void insert(int ele){

        if(size>=maxSize) return;

        // insert at level wise 
        Heap[++size] = ele;
        int current = size; // fet the current element index 

        // if current element is less then its parent then swap as we are doing minHEAP 
        while(Heap[current]<Heap[parent(current)]){ 
            swap(current,parent(current));
            current = parent(current);
        }

    }
    boolean isLeaf(int pos){
        if(pos>(size/2) && pos<=size) return true;
        else return false;
    }

    void minHeapify(int pos){

        // if the node is non leaf node we chk the left and right child 
        if(!isLeaf(pos)){
            // is leafchild > rightchild and rightchild is less then parent then swap otherwiase as it is
            if(Heap[leftChild(pos)]>Heap[rightChild(pos)]){
                // Swap with the right child and heapify 
                // the left child 
                if(Heap[rightChild(pos)] < Heap[pos]){
                    swap(pos,rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }else if(Heap[leftChild(pos)]<Heap[rightChild(pos)]){
                // Swap with the left child and heapify 
                // the left child 
                if(Heap[leftChild(pos)] < Heap[pos]){
                    swap(pos,leftChild(pos));
                    minHeapify(leftChild(pos));
                }
            }
        }
    }

   /* void minHeap(){
        // as we have to take only the element which has child
        // as the child node is already in heap 
        for(int pos = (size/2);pos>=1;pos--){
            minHeapify(pos);
        }
    }
*/
    void printMinHeap(){

        for(int i=1;i<=size/2;i++){
            System.out.print("Parent : " + Heap[i] + " Left Child : " + Heap[2*i] + " Right Child : " + Heap[2*i+1]);
            System.out.println();
        }
    }

    int remove(){

        int pop = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        // as the heapify does the work as the deletion deos
        // deletion is done from top to bottom from root to leaf
        // heapify is done from leaf to root 
        minHeapify(FRONT);
        return pop;
    }

  
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MinHeap mh = new MinHeap(15);
        
        mh.insert(10);
        mh.insert(30);
        mh.insert(20);
        mh.insert(15);
        mh.insert(32);
        mh.insert(40);
        mh.insert(35);

        // to bild the minHeap using minHeapify
        // mh.minHeap();
        
        mh.printMinHeap();
        System.out.println("Min value is : " + mh.remove());

        mh.printMinHeap();
        System.out.println("Min value is : " + mh.remove());
    }
}