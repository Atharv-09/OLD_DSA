/*
Given a string S and an integer K, the task is to reduce the string by applying the following operation:
Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.


K = 2
S = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geeksforgeeks" -> "gksforgks"
Example 2:

Input:
K = 2
S = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
*/

#include<bits/stdc++.h>
using namespace std;

string reducedString(int k,string s){
        // Your code goes here
        
        if(k==1) return "";
        
        
        stack<char> st;
        st.push(s[0]);
        
        int len = s.length();
        
        
        
        char t;
        char ele;
        for(int i=1;i<len;i++){
            
            int cou=0;
            
            if(!st.empty())
                t = st.top();
         
            if(s[i]==t && !st.empty()){
                
                ele = s[i];
                for(int j=0;j<k-1 && !st.empty() && s[i]==st.top();j++){
                    st.pop();
                    cou++;
                }
                
                if(cou+1 != k){
                    for(int l=0;l<cou+1;l++){
                        st.push(s[i]);
                    }
                }
            }else{
                st.push(s[i]);
            }
            
            
                
        }
        string ans="";
        int count=0;
        while(!st.empty()){
            ans = ans + st.top();
            count++;
            st.pop();
        }
        
         // reversing ans 
         
         for(int i=0;i<count/2;i++){
             swap(ans[i],ans[count-i-1]);
         }
        return ans;
}
int main(){

    string str;

    cout<<"Enter string : ";
    cin>>str;

    int k;
    cout<<"Enter k consecutive char : ";
    cin>>k;

    cout<<reducedString(k,str);
    return 0;
}

 // OPTIMAL IN NEXT FILE 