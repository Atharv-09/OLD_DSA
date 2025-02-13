#include<bits/stdc++.h>
using namespace std;
#define MAX 100

class Stack{
    int top;

    public:
        int arr[MAX];
        Stack(){
            top = -1;
        }

        void push(int x);
        bool isEmpty();
        void pop();
        int peek();
};

void Stack::push(int x){

    if(top>=(MAX-1)){
        cout<<"Overflow Stack";
    }else{
        arr[++top] = x;
        cout<<x<<" is pushed into stack\n";
    }
}
bool Stack::isEmpty(){
    if(top == -1){
        return true;
    }else{
        return false;
    }
}
void Stack::pop(){
    
    if(isEmpty()){
        cout<<"Stack Underflow";
    }else{
        int x = arr[top];
        cout<<x<<"is poped back from stack\n";
        top--;
    }
}
int Stack::peek(){

    if(isEmpty()){
        cout<<"Stack is empty";
        return 0;
    }else{
        int x = arr[top];
        return x;
    }
}

int main(){

    Stack s;
    s.push(10);
    s.push(30);
    s.push(20);
    
    s.pop();
    s.pop();
    s.pop(); // 10 o
    // int len = sizeof(s.arr)/sizeof(s.arr[0]);
    // for(int i=0;i<len;i++){
    //     cout<<s.arr[i]<<" ";
    // }

    int ans = s.peek();
    cout<<ans;
    return 0;
}