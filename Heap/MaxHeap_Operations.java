
class MaxHeap{

    private int size;
    private int maxSize ;
    private int Heap[];

    MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize+1];
        Heap[0] = Integer.MAX_VALUE;
    }

    int leftC(int pos){
        return pos*2;
    }
    int rightC(int pos){
        return (pos*2) + 1;
    }
    int parent(int pos){
        return pos/2;
    }
    void swap(int i1,int i2){
        int temp = Heap[i1];
        Heap[i1] = Heap[i2];
        Heap[i2] =temp;
    }
    void insert(int ele){
        Heap[++size] = ele;
        int currIndex = size;

        while(Heap[currIndex]>Heap[parent(currIndex)]){
            swap(currIndex,parent(currIndex));
            currIndex = parent(currIndex);
        }
    }

    void printMaxheap(){

        for(int i=1;i<size/2;i++){
            System.out.println("Parent : " + Heap[i] + " Left Child : " + Heap[i*2] + " Right Child : " + Heap[2*i+1]);
        }
        System.out.println();
    }

    boolean leaf(int pos){
        if(pos>size/2 && pos<=size) return true;
        return false;
    }
    void maxHeapify(int pos){

        if(!leaf(pos)){

            if( Heap[leftC(pos)] > Heap[pos] || Heap[rightC(pos)] > Heap[pos]){
                if(Heap[leftC(pos)] > Heap[rightC(pos)]){
                    
                        swap(pos,leftC(pos));
                        maxHeapify(leftC(pos));
                }else if(Heap[leftC(pos)] < Heap[rightC(pos)]){
                
                        swap(pos,rightC(pos));
                        maxHeapify(rightC(pos));
                }
            }
        }

    }
    int extractMax(){

        int pop = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return pop;
    }
    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9);

        maxHeap.printMaxheap();

        System.out.println("Max element is : " + maxHeap.extractMax());
    }
}