//Find the contiguous sub-array with maximum sum
#include<bits/stdc++.h>
using namespace std;

int maxSubarraySum(int arr[], int n){
    
    int max =-1 ;
    for(int i=0;i<n;i++){
        int sum = arr[i];
        
        //mostly for -ve terms 
        if(sum>max){ // for checking each element singly
            max = sum;
        }
        //looping each small array 
        for(int j=i+1;j<n;j++){
            
            sum+=arr[j]; // adding prev        
            
            if(sum>max){ // 
                max = sum;
            }
        }
    }

    return max;
    
}

int main()
{
    int t,n;
    
    cin>>t; 
    while(t--) 
    {
        
        cin>>n; 
        
        int a[n];
        
        for(int i=0;i<n;i++)
            cin>>a[i]; 
        
        cout << maxSubarraySum(a, n) << endl; //function call
    }
}
/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
5
5
1 2 3 -2 5
9
4
-1 -2 -3 -4
-1
6
-99 -26 78 -50 -12 -10
78
4
-4 -3 -2 -1
-1
8
4 -1 6 2 1 1 -14 6
13

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
1
4 -4 4
0

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
1
3
4 -4 4
4

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
4

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
1
6
14 -10 8 3 -8 -1
15

*/