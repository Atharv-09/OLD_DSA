public class 15FreqOfArrayItems {

    /*Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all elements from 1 to N.
    Note: The elements greater than N in the array can be ignored for counting.
    */
    // time  :O(n) space : O(1) space
    public static void frequencyCount(int arr[], int N, int P)
    {
        
        int temp[] = new int[P];
        
        Arrays.fill(temp,0);
        
        for(int i=0;i<N;i++){
            
            temp[arr[i]-1]++;
        }
        int i;
        for(i=0;i<N ||i<P;i++){
            
            if(i>=P){
                while(i>=P && i<N){
                    arr[i++] = 0;
                }
            }else if(i<N){
                arr[i] = temp[i];
            }
        }
        
        
    }
    
}
