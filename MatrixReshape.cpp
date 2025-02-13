#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
                
            vector<vector<int>> out;
            vector<int> in;
        
        
        cout<<size<<"\n";
        
        if(r*c != 2*size ){
            for(int i=0;i<r;i++){ 
                for(int j=0;j<c;j++){
                    in.push_back(nums[i][j]);
                }
                out.push_back(in);
            }
        }else{
            return nums;
        }
        
        return out;
    }
int main(){

    vector<vector<int>> i = {{1,2},{3,4}};

    vector<vector<int>> ans;


    ans = matrixReshape(i,1,4);

    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans.size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }

}