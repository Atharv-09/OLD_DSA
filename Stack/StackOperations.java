
class Stack{

    static final int MAX = 1000; // maximum sice of stack
    int top;
    int arr[] = new int[MAX] ; 
    Stack(){
        top = -1;
    }

    boolean isEmpty(){
        if(top<0){
            return true;
        }else{
            return false;
        }
    }
    void push(int data){
        if(top>= (MAX-1)){
            System.out.println("Stack overflow");
        }else{
            top++;
            arr[top] = data;
            System.out.println(data+" is pushed in stack");
        }
    }

    int pop(){

        if(top<0){
            System.out.println("Stack underflow");
            return 0;
        }else{

            int x = arr[top];
            top--;
            return x;
        }

    }
}

class Main{
    public static void main(String[] args){

        Stack s = new Stack();
        s.push(10);
        s.push(2);
        s.push(90);

        System.out.println(s.isEmpty()); // it is not empty 
        for(int i=0;i<3;i++){
            System.out.print(s.pop()+ " ");
        }
        System.out.println();

        System.out.println(s.isEmpty()); // it is empty as we pop all the element above 
        System.out.println(s.pop() + " is popped from stack"); // 0 
    }
}