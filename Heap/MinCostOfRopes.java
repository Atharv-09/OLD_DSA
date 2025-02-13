// 4 3 2 6 
// 2 3 4 6 
// 2+3 4 6 (cost = 5)
// 5+4 6 (cost = 5+9)
// 9+6 (cost = 14+15);
// cost = 29
 

// TIME : nlogn
// SPACE : n
/* long minCost(long arr[], int n) {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
       Long totalCost = 0l;
        
        while(pq.size()>1){
            Long  f = pq.poll();
            Long s = pq.poll();
            
            pq.add(f+s);
            
            totalCost+= (f+s);
        }
        
        return totalCost;
    }*/

class Main{

    int heapSize;
    int capacity;
    int[] harr;
    Main(int arr[],int k){
        heapSize = k;
        capacity = k;
        harr = arr;
        int ind = (heapSize-1)/2;
        while(ind>=0){
            heapifydown(ind);
            ind--;
        }
    }
    void swap(int i1,int i2){
       int temp = harr[i1];
       harr[i1] = harr[i2];
       harr[i2] = temp;
    }
    void heapifydown(int pos){

        int mini = pos;
        int li = pos*2+1;
        int ri = pos*2+2;

        if(li<heapSize && harr[mini]>harr[li]){
            mini = li;
        }
        if(ri<heapSize && harr[mini]>harr[ri]){
            mini = ri;
        }

        if(mini!=pos){
            swap(mini,pos);
            heapifydown(mini);
        }

    }
    void add(int ele){

        heapSize++;
        int curr = heapSize-1;
        harr[curr] = ele;
        // int curr = size;

        int pi = (curr-1)/2;
        while(harr[curr]<harr[pi]){
            swap(curr,pi);
            curr = pi;
        }
    }
    int extractMin(){

        if(heapSize<=0) return Integer.MAX_VALUE;
        if(heapSize == 1){
            heapSize--;
            return harr[0];
        }
        int temp = harr[0];
        harr[0] = harr[heapSize-1];
        heapSize--;

        heapifydown(0);
        return temp;
    }
    boolean isSizeOne(){
        return(heapSize == 1);
    }
    static int minCost(int arr[],int k){

        int totalCost = 0;
        Main m = new Main(arr,k);

        while(!m.isSizeOne()){

            int val1 = m.extractMin();
            int val2 = m.extractMin();

            totalCost += (val1+val2);

            m.add(val1+val2);
        }

        return totalCost;
    }

    public static void main(String[] args) {


        int arr[] = {4,3,2,6};
        int k=4;
        int ans = minCost(arr,k);
            System.out.println(ans);
        // m.print();
    }
}

/*There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output: 
29
Explanation:
For example if we are given 4
ropes of lengths 4, 3, 2 and 6. We can
connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Now we have three ropes of lengths 4, 6
and 5.
2) Now connect ropes of lengths 4 and 5.
Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all
ropes have connected.
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. Other ways of
connecting ropes would always have same
or more cost. For example, if we connect
4 and 6 first (we get three strings of 3,
2 and 10), then connect 10 and 3 (we get
two strings of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.
Example 2:

Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output: 
62 
Explanation:
First, connect ropes 4 and 2, which makes the 
array {6,7,6,9}. Next, add ropes 6 and 6, which 
results in {12,7,9}. Then, add 7 and 9, which 
makes the array {12,16}. And finally add these 
two which gives {28}. Hence, the total cost is 
6 + 12 + 16 + 28 = 62. */