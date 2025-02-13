#include<bits/stdc++.h>
using namespace std;

void fourSum(vector<int> v1,int target){

    int n = v1.size();
    set<vector<int>> ans;
    vector<int> vec;
    vector<vector<int>> a;

    sort(v1.begin(),v1.end());

    if(n<=3){
        cout<<" ";
    }else{

        for(int i=0;i<n-3;i++){

                    int l1 = i+1;
                    int l2 = i+2;
                    int h = n-1;
                    int sum1 =0 ;

                    while(l2<h){

                        sum1 = v1[i]+v1[l1]+v1[l2]+v1[h];
                        cout<<sum1<<"\n";
                        if(sum1>target){
                        
                            if(h == l2+1){
                                l1++;
                                l2 = l1+1;
                                h = n-1;
                            }else{
                                h--;    
                            }
                        }else if(sum1<target){
                                if(l2 != h-1){
                                    l2++;
                                }else{
                                    l1++;
                                    l2 = l1+1;
                                    h = n-1;
                                }
                        }else{
                            ans.insert(vector<int>({v1[i],v1[l1],v1[l2],v1[h]}));
                            if(l2 != h-1){
                                // if(sum1<target){
                                    // l2++;
                                // }else{
                                    h--;
                                // }
                            }else{
                                l1++;
                                l2 = l1+1;
                                  h = n-1;
                            }

                        }   
                    }
                }

        copy(ans.begin(),ans.end(),back_inserter(a));
        
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a[i].size();j++){
                cout<<a[i][j]<<" ";
            }
            cout<<"\n";
        }
    }
}


int main(){
    //-3,-2,-1,0,0,1,2,3->  0 
    //0,3,4,-2,-1,3,3,3,1-> 2
    //-4,-3,-2,-1,0,0,1,2,3,4 -> 0
    vector<int> v1 = {0,3,4,-2,-1,3,3,3,1};
    
    // vector<vector<int>> ans = fourSum(v1,0);
    fourSum(v1,2);
    // for(int i=0;i<ans.size();i++){
    //     for(int j=0;j<ans[i].size();j++){
    //         cout<<ans[i][j]<<" ";
    //     }
    //     cout<<"\n";
    // }
    return 0;
}