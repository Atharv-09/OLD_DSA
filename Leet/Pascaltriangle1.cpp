#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> generate(int row){

    if(row==0){
        return {};
    }

    vector<vector<int>> ans;
    vector<int> v1;

    ans.push_back({1});

    int i = 1;
    int totalC = 2;
    while(i<row){
        v1.clear();
        v1.push_back(1);
        for(int j=1;j<totalC-1;j++){
            
            v1.push_back(ans[i-1][j]+ans[i-1][j-1]);
        }

        totalC++;
        i++;
        v1.push_back(1);
        ans.push_back(v1);
    }

    return ans;
}
int main(){

    int rowC;

    cout<<"Enter row count : ";
    cin>>rowC;
    
    vector<vector<int>> ans = generate(rowC);

    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }
    return 0;
}