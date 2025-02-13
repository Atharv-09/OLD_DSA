#include<bits/stdc++.h>
using namespace std;

void generate(int N)
{
    vector<string> s;
    s.push_back("1");
    int num;
    char rem;
    for(int i=2;i<=N;i++){
        num = i;
        string ss="";
        // cout<<num<<"\n";
        while(num>0){
            
            // rem =num%2; // 3 # 2 = 1 
            ss = ss+(num%2);
            num = num/2;      
        }
    
        s.push_back(ss);
    }
 //   return s;

    for(int i=0;i<N;i++){
        cout<<s[i]<<" ";
    }
}
int main(){

    
    int n;
    
    cout<<"Enter n : ";
    cin>>n;
    generate(n); 
}