#include<bits/stdc++.h>
using namespace std;

int maxLen(int A[], int n);

int main()
{
    int T;
    cin >> T;
    while (T--)
    {
        int N;
        cin >> N;
        int A[N];
        for (int i = 0; i < N; i++)
            cin >> A[i];
        cout << maxLen(A, N) << endl;
    }
}

int maxLen(int A[],int n){

    int max_len = 0;
    int sum = 0;

    unordered_map<int,int> m1; // unorderd map stores elemets in random rder not like in sorted order 
    //stored as key value and mapped value 

    for(int i=0;i<n;i++){

        sum+=A[i];

        if(sum==0 && max_len==0){
            max_len = 1;
        }

        if(sum==0){
            max_len = i+1;
        }

        if(m1.find(sum) != m1.end()){
            max_len = max(max_len,i-m1[sum]);
        }else{
            m1[sum] = i;
        }

    }

    return max_len;
}
/*$ ./a.exe
1

7
15
-2
2
-8
1
7
10
5

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
1
1
0
1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
1
2
1 2
0

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
1
2
1 -
1
*/