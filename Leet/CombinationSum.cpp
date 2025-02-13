#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> combSum(vector<int> v1,int t){

        int n = v1.size();
        vector<vector<int>> ans;
        vector<int> vec ;

        if(n == 0 || (n==1 && v1[0]>t)){
            return vector<vector<int>>();
        }else if(n==1 && v1[0]<t){
            for(int i=0;i<t;i++){
                vec.push_back(v1[0]);
            }
            ans.push_back(vec);
            return ans;
        }else{
           for(int i=0;i<n;i++){
               int rem = t%v1[i];
               if(rem == 0){
                   int div = t/v1[i];
                   vec.insert(vec.end(),div,v1[i]);
               }
               ans.push_back(vec);
                vec.clear();   
           }

            for(int i=0;i<i<n;i++){
                int howManyTime = 2;

                int mul = v1[i]*howManyTime;
                int j = i+1;

                while(mul<t){
                    
                    if(mul+v1[j] == t){
                        vec.push_back(vec.end(),howManyTime,v1[i]);
                        vec.push_back(v1[j]);
                        j++;
                    }

                }

            }

             
        }

        return ans;
}

int main(){

    vector<int> cand = {2,4,5};
    
    vector<vector<int>> ans = combSum(cand,8);


    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<"\n";
    }

    return 0;
}