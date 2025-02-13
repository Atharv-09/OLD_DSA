/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.*/



int maxPro(int[] price){


    int curProfit = 0;
    int buyInd = 0;
    int prevProfit = 0;
    int totalPro = 0;

    for(int curIndex=1;curIndex<price.length;curIndex++){

        prevProfit = curProfit;
        curProfit = price[curIndex]-price[buyInd];

        if(curPro<0){

            curProfit = 0;
            buyInd = curIndex;
        }

        if(curProfit<prevProfit){
            totalPro = curProfit + prevProfit;
            buyInd = curIndex;
            curProfit = 0;
        }

    }

    if(curProfit>0)
        totalPro += curProfit;

    return totalPro;



}



#include<bits/stdc++.h>
using namespace std;

int maxProfit(vector<int> v){

    int minV=v[0];
    int pro = 0;

    for(int p:v){
        minV = min(minV,p);
        pro = max(pro,p-minV);
    }
    return pro;

}

int main(){
    vector<int> vec = {7,1,5,3,6,4};
    int pro = maxProfit(vec);
    cout<<pro<<"\n";
}