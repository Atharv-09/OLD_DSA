#include<bits/stdc++.h>
using namespace std;

int main(){

    vector<int> arr = {3,3,2,2,3};
    int val = 3;

    // int removeElement(vector<int>& nums, int val) {
        
        int size = arr.size();
        int i = 0;
        int j = size-1;

        while(i<=j){

            if(arr[i] != val){
                i++;
            }else{

                if(arr[j]!=val){
                    swap(arr[i],arr[j]);
                }
                j--;
                size--;
            }
        }

        cout<<size<<"\n";

        for(int i=0;i<size;i++){
            cout<<arr[i]<<" " ;
        }
        
    
}