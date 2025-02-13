#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
        int data;
        Node* next;
};
void printSLL(Node* n){

    while(n!=NULL){
        cout<<n->data<<" ";
        n = n->next;
    }
}

void pushAtFront(Node** head_ref,int new_data){

    Node* new_node = new Node();

    new_node->data = new_data;
    new_node->next = *head_ref;

    (*head_ref) = new_node;
}
int main(){

    Node* head = new Node();
    Node* sec = new Node();
    Node* third = new Node();

    head->data = 1;
    head->next = sec;

    sec->data =2;
    sec->next = third;

    third->data = 3;
    third->next = NULL;

    pushAtFront(,19);
    
    printSLL(head);

}