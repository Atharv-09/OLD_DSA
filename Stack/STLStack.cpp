#include<bits/stdc++.h>
using namespace std;

void print(stack<int> s1){
    while(!s1.empty()){
        cout<<s1.top()<<" ";
        s1.pop();
    }
    cout<<"\n";
}

int main(){

    stack<int> s;
    s.push(10);
    s.push(2);
    s.push(9);
    s.push(19);
    s.push(1);

    print(s);

    s.pop(); // pop 1

    print(s);
 
    cout<< s.size()<<"\n"; // 4
    cout<<s.top()<<"\n"; // 19 
    return 0;
}