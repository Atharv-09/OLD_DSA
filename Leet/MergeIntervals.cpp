#include<bits/stdc++.h>
using namespace std;
void merge(vector<vector<int>>& inter) {

        // for testcase 
        // [[1,4],[0,4]]
        // ans = [0,4]    
        sort(inter.begin(), inter.end(), [](const vector<int>& l, const vector<int>& r){
            return l[0] < r[0];
        });  

        int n = inter.size();
        vector<vector<int>> ans;
        vector<int> v1;
        int fStart=0,fEnd = 0;
        
        for(int i=0;i<n;i++){
            
           
                
                fStart = inter[i][0];
                fEnd = inter[i][1];
                int j = i+1;
                while(j<n && fEnd>=inter[j][0]){
                    
                    fEnd = max(fEnd,inter[j][1]);
                    j++;

                }
                j--;
                v1.push_back(fStart);
                v1.push_back(fEnd);
                i=j; // as if we are getting overlapped then we move forward upto j 
                // so for next time we not start from prev i+1 but from j
                ans.push_back(v1);

        }

        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans[i].size();j++){
                cout<<ans[i][j]<<" ";
            }
            cout<<"\n";
        }
}

int main(){

    vector<vector<int>> v = {{1,3},{2,6},{8,10},{15,18}};

    merge(v);

    

}