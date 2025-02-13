/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given an integer n representing the total number of bits in the code, return any sequence of gray code.

A gray code sequence must begin with 0.

 

Example 1:

Input: n = 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2
[0,2,3,1] is also a valid gray code sequence.
00 - 0
10 - 2
11 - 3
01 - 1
    */


#include<bits/stdc++.h>
using namespace std;
vector<int> find(int n){

    vector<int> ans;

    ans.push_back(0);
    if(n == 0){
        return ans;
    }
    ans.push_back(1);
    if(n == 1){ 
        return ans;
    }   

    int x = 1;
    while(x<n){

            int y = pow(2,x);

            for(int i = ans.size()-1;i>=0;i--){
                ans.push_back(ans[i]+y);
            }
        x++;
    }

    return ans;
}
int main(){ 

    int n;

    cout<<"Enter bit count : ";
    cin >> n;

    vector<int> a = find(n);

    for(int i=0;i<a.size();i++){
        cout<<a[i]<<" ";
    }
    cout<<"\n";
    return 0;
}

/*
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet
$ ./a.exe
Enter bit count : 2
0 1 3 2

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet
$ ./a.exe
Enter bit count : 3
0 1 3 2 6 7 5 4

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet
$ ./a.exe
Enter bit count : 1
0 1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet
$ ./a.exe
Enter bit count : 4
0 1 3 2 6 7 5 4 12 13 15 14 10 11 9 8
*/