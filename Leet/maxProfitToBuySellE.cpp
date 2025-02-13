#include<bits/stdc++.h>
using namespace std;

void findProfit(vector<int> prices){
   
            
            // int key =INT_MAX;
            // int ans[prices.size()-1],keyI=0;
        
            // for(int i=0;i<prices.size()-1;i++){
                
            //     if(prices[i]<prices[i+1] || key>prices[i]){
                    
            //             key=prices[i];
            //             keyI = i;
                
            //             for(int i=keyI;i<prices.size()-1;i++){
                                
            //                     ans[i]= prices[i]-key;
            //             }
                    
            //     }else{
            //         ans[i]=0;
            //     }
            // }
            // for(int i=0;i<prices.size();i++){
            //     cout<<ans[i]<<" ";
            // }
            
            // cout<<"\n"<<keyI<<"\n";
            // int max = INT_MIN;
        
            // for(int i=0;i<prices.size()-1;i++){
            //     if(ans[i]>max){
            //         max = ans[i];
            //     }
            // }
         int min = *min_element(prices.begin(),prices.end());
            int minI;
        
            for(int i=0;i<prices.size();i++){
                if(min == prices[i]){
                    minI = i;
                    break;
                }
            }
            if(minI == prices.size()-1){
                prices.erase(prices.begin()+minI);// 2 4 1 (2) 
                min = *min_element(prices.begin(),prices.end());
            }
            for(int i=0;i<prices.size();i++){
                if(min == prices[i]){
                    minI = i;
                    break;
                }
            }
            // cout<<min<<" "<<minI<<"\n";

            // for(int i=0;i<prices.size()-1;i++){
            //     cout<<prices[i]<<" ";
            // }
            int max = *max_element(prices.begin()+minI,prices.end());
            // int maxI;
            // cout<<max<<"\n";
            int ans = 0;
            if(max>min){
                ans = max-min;
            }
        cout<<ans;
            
}

int main(){

    vector<int> prices = {2,4,1};

    findProfit(prices);

    return 0;

}