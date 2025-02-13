// three way partioning/dutch ational flag algo 
// time = O(n) space = O(1);

class Main{

    static void sort012(int[] arr,int n){

        int lo = 0;
        int hi = n-1;
        int mid = 0;
        int temp=0;
        while(mid<=hi){

            switch(arr[mid]){

                case 0: {
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                    lo++;
                    break;
                }

                case 1: {
                    mid++;
                    break;
                }

                case 2 : {
                    temp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = temp;
                    hi--;
                    break;
                }
            }
        }


    }
    public static void main(String[] args) {

        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 }; 

        int size = arr.length;

        sort012(arr,size);

        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

// second approach is  time O(n) space O(1) 
//
 /* 1 Count the number of zeros ones and twos in the array using  swicth casr and taking 
    case 0 : count0++;
    case 1 : count1++; etc
    2 After taking count using while loop put the values according to 0 1 2 
    first all 0 gies 

    int i=0;
    while(count0>i){
        arr[i] = 0;
        i++;
        count0--;
    }
    while(count0>i){
        arr[i] = 1;
        i++;
        count1--;
    }
    for 2 same 
 */
/*class Solution {
public:
    void sortColors(vector<int>& nums) {
        // sort(nums.begin(),nums.end());
        
        int cur = 0;
        int p1 = 0;
        int p2 = nums.size()-1;
        
        while(cur<=p2){
            
            if(nums[cur]==0){
                swap(nums[p1],nums[cur]);
                p1++;
                cur++;
            }else if(nums[cur]==1){
                cur++;
            }else if(nums[cur]==2){
                swap(nums[p2],nums[cur]);
                p2--;
            }
        }
    }
};*/