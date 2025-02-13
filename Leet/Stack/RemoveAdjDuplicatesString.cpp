#include<bits/stdc++.h>
using namespace std;

int main(){
    string s;

    cout<<"Enter string : ";
    cin>>s;

    int len = s.length();

    stack<char> st;
    for(int i=0;i<len;i++){

        if(st.empty()) st.push(s[i]);
        else{
            if(s[i]==st.top()){
                st.pop();
            }else{
                st.push(s[i]);
            }
        }
    }

    string ans="";
    while(!st.empty()){
        ans.push_back(st.top());
        st.pop();
    }

    reverse(ans.begin(),ans.end());

    cout<<"Ans : "<<ans;

    return 0;
}