/*Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.*/
// find the totalProfit 
#include<bits/stdc++.h>
using namespace std;

int maxProfit(vector<int> v){
    int totalP=0;
    for(int i=1;i<v.size();i++){

        if(v[i]>v[i-1]){
            totalP += v[i]-v[i-1];
        }
    }
    return totalP;

}

int main(){
    vector<int> vec = {7,1,5,3,6,4};
    int pro = maxProfit(vec);
    cout<<pro<<"\n";
}