#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> setZeroes(vector<vector<int>> v1){

    vector<vector<int>> ans;
    vector<int> v;

    int n = v1.size();
    // int row=-1,col=-1;

    queue<pair<int,int>> q;

    int arr[100][100];

    for(int i=0;i<n;i++){
        for(int j=0;j<v1[i].size();j++){
            if(v1[i][j] == 0){
                q.push({i,j});
            }
        }
    }
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<v1[i].size();j++){
    
    while(!q.empty()){

            int s = q.front().first;
            int e = q.front().second;
            q.pop();

            for(int i=0;i<n;i++){
                v1[i][e] = 0;
            }
            for(int i=0;i<v1[0].size();i++){
                v1[s][i] = 0;
            }
            // if( i == row){
            //     v1[i][j] = 0;
            // }

            // if(j==col){
            //     v1[i][j] =0;
            // }
        }
    
    return v1;
}
int main(){

    vector<vector<int>> v1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

    vector<vector<int>> ans = setZeroes(v1);

    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }
    return 0;
}