#include<bits/stdc++.h>
using namespace std;
int findPositive(vector<int> arr,int l,int h){
        int ans = 1;
        int maxN;
        for(int i=l;i<h;i++){

            maxN = arr[i];
            ans = ans*arr[i];
            ans = max(ans,maxN);
        }
        return ans;
}

int maxProduct(vector<int> arr){
    //348 ms 11.4mb

    int ans=0;

    int n = arr.size();
    if(n==1){
        return arr[0];
    } // for one element 
    int minusC =0 ;
    int smallestMinus = 0;
    int minusIndex = 0,leftSum=1,rightSum=1;
    for(int i=0;i<n;i++){
        if(arr[i]<0){
            minusC++;
            if(smallestMinus>arr[i]){
                smallestMinus = arr[i];
                minusIndex = i;
            }
        }
    }
    int maxPro = 1;
    if(minusC==0){

        int a = findPositive(arr,0,n);
        return a;
        
    }else if(minusC == 1){

            if(minusIndex == 0){
                ans = findPositive(arr,1,n);
                return ans;
            }else if(minusIndex==n-1){
                ans = findPositive(arr,0,n-1);
                return ans;
            }else {
                for(int i=0;i<minusIndex;i++){
                maxPro = maxPro*arr[i];
                }
                leftSum = maxPro;

                maxPro = 1;

                for(int i=minusIndex+1;i<n;i++){
                    maxPro = maxPro*arr[i];
                }

                rightSum = maxPro;
                return max(leftSum,rightSum);
            }
            
    }else if(minusC%2 == 0 && minusC!=0){ // count even whole matrix
            ans = 1;
            
            for(int i=0;i<n;i++){
                ans= ans*arr[i];
            }

            return ans;
    }else if(minusC%2 != 0){ // count odd then min element to his next mnus element
            int c = 0;
            ans = 1;
            // cout<<minusC<<"\n"; // 3 
            if(minusIndex == n-1){
                for(int j=minusIndex;j>=0;j--){
                    if(arr[j]<0) c++;
                    if(c==minusC){break;}
                    ans = ans*arr[j];
                }
            }else if(minusIndex == 0){
                for(int i=0;i<n;i++){
                    if(arr[i]<0) c++;
                    if(c==minusC){break;}
                    ans = ans*arr[i];
                }
            }else{

                int leftMinusC = 0,rightMinusC=0;
                for(int i=0;i<minusIndex;i++){
                    leftSum = leftSum*arr[i];
                    if(arr[i]<0)leftMinusC++;
                }
                for(int i=minusIndex;i<n;i++){
                    rightSum = rightSum*arr[i];
                    if(arr[i]<0)rightMinusC++;
                }
        
                int finalLeftMul=1,finalRightMul=1;

                for(int i=minusIndex-1;i>=0;i--){
                    if(arr[i]<0) rightMinusC++;
                    if(rightMinusC == minusC) break;
                    finalRightMul = finalRightMul*arr[i];
                }

                finalRightMul = finalRightMul*rightSum;

                for(int i=minusIndex;i<n;i++){
                    if(arr[i]<0) leftMinusC++;
                    if(leftMinusC == minusC) break;
                    finalLeftMul = finalLeftMul*arr[i];
                }
                //cout<<leftSum<<" "<<rightSum<<" "<<finalLeftMul<<" "<<finalRightMul<<"\n";
                finalLeftMul = finalLeftMul*leftSum;

                ans = max(finalLeftMul,finalRightMul);
            }
            return ans;
    }

    return 0;

    // int ans=0;
    // int maxPro = 0;

    // for(int i=0;i<n-1;i++){
        
    //     maxPro = arr[i]; //-2 
    //     ans = max(maxPro,ans); // for -ve ans 0
    //     // -2 0 = 0
    //     for(int j=i+1;j<n;j++){

    //         maxPro = maxPro*arr[j]; // 
    //         ans = max(maxPro,ans);
    //     }

    // }
    // return ans;

}
int main(){

    int size;
    cout<<"Enter size : ";
    cin>>size;

    //int arr[size];
    vector<int> arr;
    int in;
    cout<<"Enter array : ";
    for(int i=0;i<size;i++){
        cin>>in;
        arr.push_back(in);
    }
    int maxproduct = maxProduct(arr);

    cout<<maxproduct;
    return 0;
}