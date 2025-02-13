#include<bits/stdc++.h>
using namespace std;

struct StackA{

    vector<int> s1;
    vector<int> s2;


    void push(int x){
        s1.push_back(x);
        if(s2.empty()) s2.push_back(x);
        else{
            int min_ele = min(x,*s2.rbegin());
            s2.push_back(min_ele);
        }
    }

    int pop(){

        s1.pop_back();
        s2.pop_back();

        return *s1.rbegin();
    }

    int getMin(){
        return *s2.rbegin();
    }

};

int main(){

    StackA s;
    s.push(10);
    cout<<s.getMin()<<"\n";
    s.push(3);
    s.push(12);
    s.push(2);
    cout<<s.getMin()<<"\n";
    cout<<"Popped = " <<s.pop()<<"\n";
    cout<<s.getMin();

}