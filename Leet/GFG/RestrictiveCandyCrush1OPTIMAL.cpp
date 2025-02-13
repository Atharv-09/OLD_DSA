// OPTIMAL 

#include<bits/stdc++.h>
using namespace std;

string reducedString(int k,string s){

    if(k==1) return "";

    int len = s.length();
    stack<pair<char,int>> st;

    for(int i=0;i<len;i++){

        if(st.empty()) st.push(make_pair(s[i],1));
        else{

            if((st.top()).first == s[i]){
                (st.top()).second++; // increse count of char as it incresed in linear fashion;

                // as if the top and curr char is eql then we increse count of char 
                // so if count becomes eql to k then pop ele
                if((st.top()).second == k ){
                    st.pop();
                }
            }else{
                // else push the 1 as count 
                st.push(make_pair(s[i],1));
            }
        }

    }
    string result="";
    while(!st.empty()){
        result = string((st.top()).second,(st.top()).first)+result;

        st.pop();
    }

    return result;

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

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/GFG
$ ./a.exe
Enter string : geegsforgeeeks
Enter k consecutive char : 2
sforgeks
hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Leet/GFG
$ ./a.exe
Enter string : geegsforgeeeks
Enter k consecutive char : 3
geegsforgks*/