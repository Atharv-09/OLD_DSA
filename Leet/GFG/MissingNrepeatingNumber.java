import java.util.*;

class Solve {
    static int buck1,buck2;
    void findTwoElement(int arr[], int n) {

        int xor1;
        buck1 =0;
        buck2 =0;
        xor1 = arr[0];
        // xor of all array element 
        for(int i=1;i<n;i++){
            xor1 = xor1^arr[i];
        }

        // xor of all array element with the 1 to n         
        for(int i=1;i<=n;i++){
            xor1 = xor1 ^ i;
        }

        int setBitNo;

        //for thr rightmost set bit(1) 
        setBitNo = xor1 & ~(xor1-1);
          // fir 4 =  1 0 0  == at 2 index from last

        // now divide the element in 2 bucket such that 
        // 1 st bucket has the element which has at the same index number of set bit from rightmost 
        // 2 nd bucket which has not the set bit at the same index which has set bit 
        // 3 = 0 1 1 == goes in 2 bucket
        // 5 = 1 0 1 == goes in 1 bucket 


        for(int i=0;i<n;i++){

            if((arr[i]&setBitNo) !=0 ){
                    buck1 = buck1^arr[i];
            }else{
                    buck2 = buck2^arr[i];
            }
        }

        // for 1 to n
        for(int i=1;i<=n;i++){

            if((i&setBitNo)!=0){
                buck1 = buck1^i;
            }else{
                buck2 = buck2^i;
            }

        }





    }
}

/* time = O(n) space = O(n) 
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],0);
            }
            
            hm.put(arr[i],hm.get(arr[i])+1);
        }
        
        int count=1;
        int ans[] = new int[2];

        
        for(int i=0;i<n;i++){
            if(hm.containsKey(count)){
                count++;
            }else{
                ans[1] = count;
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            if(hm.get(arr[i])>1){
                ans[0] = arr[i];
                break;
            }else{
                ans[0] = 0;
            }
        }
        // if(found==false){
        //     ans[1] = n+1;
        // }
        return ans;
    }
}
*/
class Main{
    public static void main(String[] args) {
        Solve obj = new Solve();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){   
            arr[i] = sc.nextInt();
        }
        // int ans[] = new int[2];
        // ans =  obj.findTwoElement(arr,n);
        
        // System.out.println(ans[0]+" "+ans[1]);
        
        obj.findTwoElement(arr, n);
        System.out.println("Missing : "+Solve.buck1 +"\nRepeating : "+Solve.buck2);

        /*TO RETURN SIMPLY LINESRLY SEARCH 
         int missing=0,repeat=0;
        for(int i=0;i<n;i++){
            if(a==arr[i]){
                repeat = a;
                missing = b;
                break;
            }
            else{
                repeat = b;
                missing = a;
            }
        }
       
        ans[0]=repeat;
        ans[1]=missing;
        
        return ans;
        */
    }
}

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/GFG
$ java Main
Enter size : 6
1 2 4 4 5 6
4 3

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/GFG
$ java Main
Enter size : 3
1 3 3
3 2

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DS*/