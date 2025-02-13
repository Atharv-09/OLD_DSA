#include<bits/stdc++.h>
using namespace std;

int main(){ 

    int n,num;

    cout<<"Enter array size :";
    cin >> n;

    int arr[n];
    cout<<"Enter array : ";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"Enter number :";
    cin>>num;
    int indexI,indexJ,indexK;
    bool ans=false;

    for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            for(int k=j+1;k<n;k++){

                if(arr[i]+arr[j]+arr[k] == num){
                    indexI = i;
                    indexJ = j;
                    indexK = k;
                    ans = true;
                    break;
                }

                if(ans == true)
                    break;
            }
        }

        if(ans==true)
            break;
    }

    if(ans==true){
        cout<<"FOUND"<<"\n";
        cout<<indexI<<" "<<indexJ<<" "<<indexK<<"\n";
    }


    return 0;
}