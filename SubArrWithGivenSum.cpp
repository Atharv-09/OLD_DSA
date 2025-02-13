/*Given an unsorted array A of size N that contains only non-negative integers, 
find a continuous sub-array which adds to a given number S.*/

#include<bits/stdc++.h>
using namespace std;

vector<int> subArraySum(int arr[],int n,int num){

    vector<int> v1;
    bool found=false;

    int sum=0;

    for(int i=0;i<n;i++){

        sum = arr[i];

        for(int j=i+1;j<=n;j++){

            if(sum == num){
                v1.push_back(i+1);
                v1.push_back(j);
                found=true;
                return v1;

            }
            if(sum>num || j==n){
                break;
            }
            sum+=arr[j];
        }
        sum=0;
        
    }

    if(found == false){
        v1.push_back(-1);
        return v1;

    }

}

int main(){

    int t,n,num;

    cout<<"Enter case count : " ;
    cin>>t;

    while(t--){

        cout<<"Enter arrray length : ";
        cin>>n;

        cout<<"Enter number to find :";
        cin>>num;

        int arr[n];

        cout<<"Enter array : ";
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }

        vector<int> ans;
        ans = subArraySum(arr,n,num);

        for(auto i=ans.begin();i!=ans.end();i++){
            cout<<*i<<" ";
        }
        cout<<"\n";
    }

    return 0;
}

/*N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
 

Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.
*/