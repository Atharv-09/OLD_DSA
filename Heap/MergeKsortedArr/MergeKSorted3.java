import java.util.*;

class Main{
    static ArrayList<Integer> ans = new ArrayList<Integer>();
    
    static class Pair implements Comparable<Pair>{
        int ai;
        int di;
        int val;
        
        Pair(int ai,int di,int val){
            
            this.ai = ai;
            this.di = di;
            this.val = val;
               
        }
        
        public int compareTo(Pair obj){
            return this.val-obj.val;
        }
    }
    
    static class MainWork{
        
        void merge(int arr[][],int k){
            
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int i=0;i<arr.length;i++){
                Pair p = new Pair(i,0,arr[i][0]);
                pq.add(p);
            }
            
            while(pq.size()>0){
                Pair min = pq.remove();
                ans.add(min.val);
                min.di++;
                
                if(min.di<arr[min.ai].length){
                    min.val = arr[min.ai][min.di];
                    pq.add(min);
                }
            }
            
        }
        
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        if(k==1){
            ans.add(arrays[0][0]);
            return ans;
        }
        MainWork mw = new MainWork();
        mw.merge(arrays,k);
        return ans;
    }

    public static void main(String[] args) {
        
        int arr[][] = {{1,3,5},{2,4,6},{5,7,11}};
        ArrayList<Integer> ans = mergeKArrays(arr, 3);

        for(int i=0;i<3*3;i++){
            System.out.print(ans.get(i)+ " ");
        }
        System.out.println();
    }
}