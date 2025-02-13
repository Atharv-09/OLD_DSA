#include<bits/stdc++.h>
using namespace std;


/*Using extra space 

    1) first merge all the both array 
    2) sort both array (O(nlogn)
    3) after sorting put from 0 one by one elenent in orginal array 
*/
int nextGap(int g){

    if(g<=1) return 0;
    else  return (g/2)+(g%2);
}

// void swap(int *p1,int *p2){

//     int *temp = p1;
//     p1 = p2;
//     p2 = temp;

// }
void merge(int a1[],int a2[],int n,int m){

    // time comp = O(n*m) 
    //space = O(1)
    // for(int i=0;i<n;i++){

    //     if(a1[i]>a2[0]){

    //         swap(a1[i],a2[0]);

    //         int first=a2[0];
    //         int j;
    //         for(j=1;j<m&&a2[j]<first;j++){
    //             a2[j-1] = a2[j];
    //         }
    //         a2[j-1] = first;


    //     }

    // }

    // GAP ALGO 
    // time comp = O(N(log2N));
    // space : O(1)

    // int gap = ceil((m+n)/2)
    
    int gap=n+m,i,j;

    
    for(gap=nextGap(gap);gap>0;gap=nextGap(gap)){

        // if the both pointerexists in the left array 

        for(i=0;i+gap<n;i++){

            if(a1[i]>a1[i+gap]){
                swap(a1[i],a1[i+gap]);
            }

        }

        // if the one pointer is on left array and other on right array 

        // alot first pointer first n for second  
        // check if the gap size is greater then the first array size so if true then the pointer p2 lies on second array
        for(j=gap>n?gap-n:0;i<n&&j<m;i++,j++){


            if(a1[i]>a2[j]){
                swap(a1[i],a2[j]);
            }
        }

        // not if the both the pointer is on the second array 

        if(j<m){
            for(j=0;j+gap<m;j++){
                if(a2[j]>a2[j+gap]){
                    swap(a2[j],a2[j+gap]);
                }
            }
        }

    }

    
    cout<<"Array 1 : ";
    for(int i=0;i<n;i++){
        cout<<a1[i]<<" ";
    }

    cout<<"\nArray 2 : ";
    for(int i=0;i<m;i++){
        cout<<a2[i]<<" ";
    }

}

int main(){

    int n,m;
    cout<<"Enter array1 size : ";
    cin>>n;
    int arr1[n];
    cout<<"Enter arr1: ";
    for(int i=0;i<n;i++){
        cin>>arr1[i];
    }
    ////
    cout<<"Enter array2 size : ";
    cin>>m;
    int arr2[m];
    cout<<"Enter arr2: ";
    for(int i=0;i<m;i++){
        cin>>arr2[i];
    }

    merge(arr1,arr2,n,m);


    return 0;
}   



/*$ ./a.exe
Enter array1 size : 6
Enter arr1: 1 5 7 9 15 20
Enter array2 size : 4
Enter arr2: 2 3 8 13
Array 1 : 1 2 3 5 7 8
Array 2 : 9 13 15 20*/