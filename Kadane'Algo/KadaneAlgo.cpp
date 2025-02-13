//Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
/*Simple idea of the Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this)
 And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
 Each time we get a positive sum compare it with max_so_far and 
 update max_so_far if it is greater than max_so_far*/

#include<bits/stdc++.h>
using namespace std;

int MaxSumContinousSubarray(int arr[],int len){

    int max_sum_upto=INT_MIN,max_ends_here=0;

    for(int i=0;i<len;i++){

        max_ends_here += arr[i];


        if(max_sum_upto<max_ends_here ){ // for saving 
            max_sum_upto = max_ends_here;
        }

        if(max_ends_here < 0){ // for -ve number 
            max_ends_here = 0; 
        }
    }

    return max_sum_upto;
}

int main(){

    int len;

    cout<<"Enter array length : ";
    cin>>len;

    int arr[len];
    for(int i=0;i<len;i++){
        cin>>arr[i];
    }

    int ans = MaxSumContinousSubarray1(arr,len);

    printf("%d \n",ans);


    return 0;
}


// TIME : O(n^3) 
int MaxSumContinousSubarray1(int arr[],int len){


    int currMaxSum = INT_MIN;
    for(int lef = 0;lef<len;lef++){
        for(int rig = lef;rig<=len;rig++){

            int sumUpto = 0;
            for(int k=lef;k<=rig;k++){

                sumUpto += arr[k];
            }

             currMaxSum =  max(sumUpto,currMaxSum);
        }
    }

    return currMaxSum;
}

// TIME=  O(n^2)


int MaxSumContinousSubarray1(int arr[],int len){

    int n = nums.Length;
    int maximumSubArraySum = INT_MIN;

    for (int left = 0; left < n; left++) 
    {
      int runningWindowSum = 0;

      for (int right = left; right < n; right++) 
      {
        runningWindowSum += arr[right];

        // Does this window beat the best sum we have seen so far?
        maximumSubArraySum = Math.Max(maximumSubArraySum, runningWindowSum);
      }
    }


}