#include<bits/stdc++.h>
using namespace std;

// Passing 85/154 cases
vector<vector<int>> insert(vector<vector<int>> inter,vector<int> newInter){
        vector<vector<int>> ans;
        vector<int> v1;

        int n = inter.size();
        if(n==0){
            // v1.push_back(newInter);
            ans.push_back(newInter);
            return ans;
            v1.clear();
        }
        ans.clear();
        int sOld = inter[0][0];
        int eOld = inter[0][1];

        if(n==1){
            if(sOld>newInter[0] && sOld>newInter[1]){
                v1.push_back(inter[0][0]);
                v1.push_back(inter[0][1]);
                ans.push_back(v1);
                v1.clear();
                v1.push_back(newInter[0]); 
                v1.push_back(newInter[1]);  
                ans.push_back(v1);      
                return ans;
            }
            else if(eOld>newInter[1] && sOld<newInter[0]){
                return inter;
            }else if(eOld<=newInter[1] && newInter[0]<=eOld){
                inter[0][1] = newInter[1];
                return inter;
            }else if(eOld>newInter[1] && newInter[0]<sOld){
                inter[0][0] = min(newInter[0],sOld);
                return inter;
            }else{
                v1.push_back(inter[0][0]);
                v1.push_back(inter[0][1]);
                ans.push_back(v1);
                v1.clear();
                v1.push_back(newInter[0]); 
                v1.push_back(newInter[1]);  
                ans.push_back(v1);      
                return ans;  
            }
        }
            v1.clear();
            ans.clear();
        int start=0,end=0;

        for(int i=0;i<n;i++){   
            
            sOld = inter[i][0]; // 1
            eOld = inter[i][1]; // 3 

            if(newInter[0]<eOld && newInter[1]>eOld){ // 2<3
                start = sOld;
                end = newInter[1];
                v1.push_back(start);
                v1.push_back(end);
                ans.push_back(v1);
                v1.clear();
            }else{
                v1.push_back(inter[i][0]);
                v1.push_back(inter[i][1]);
                ans.push_back(v1);
                v1.clear();
            }
        }   
        v1.clear();

        vector<vector<int>> mainAns;

        int size = ans.size();
        for(int i=0;i<size;i++){
            start = ans[i][0];
            end = ans[i][1];

            int j = i+1;

            while(j<n && ans[j][0]<=end){

                end = max(end,ans[j][1]);
                j++;

            }
            j--;

            v1.push_back(start);
            v1.push_back(end);
            mainAns.push_back(v1);

            v1.clear();
            i=j;

        }


        return mainAns;  
}
int main(){
    //{{1,2},{3,5},{6,7},{8,10},{12,16}}
    // {4,8}
    vector<vector<int>> v1= {{1,5}};

    vector<int> in = {0,0};

    vector<vector<int>> ans = insert(v1,in);

    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }

    return 0;
}