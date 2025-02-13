    #include<bits/stdc++.h>
using namespace std;

vector<vector<int>> pascalT(int size){

    if(size==0) return {};

    vector<vector<int>> ans;
    vector<int> temp;

    ans.push_back({1});

    int m = 2;
    int k = 1;
    while(k<size){
        temp.clear();
        temp.push_back(1);


        for(int i=1;i<m-1;i++){
            temp.push_back(ans[k-1][i]+ans[k-1][i-1]);
        }

        temp.push_back(1);
        
        m++;
        k++;

        ans.push_back(temp);
    }
    return ans;
}


int main(){

    int count;
    cout<<"Enter row count : ";
    cin>>count;
    vector<vector<int>> ans = pascalT(count);

    for(int i=0;i<ans.size();i++){

        for(int sp=ans.size();sp>i;sp--){
            cout<<" ";
        }
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }

    return 0;
}
/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
Enter row count : 5
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA
$ ./a.exe
Enter row count : 8
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1
   1 5 10 10 5 1
  1 6 15 20 15 6 1
 1 7 21 35 35 21 7 1*/