// FIFO 
// There are 2 front and rear 
//    rear(added)          front(remove) 
//  enqueue         dequeue

class Queue{

    int rear=-1,front=-1,size=10;
    int[] arr = new int[10];
    // int capacity;

    // Queue(int capacity){
    //     this.capacity = capacity;
    //     front = this.size = 0;
    //     // rear = capacity -1;
    //     arr = new int[this.capacity];
    // }
    boolean isFull(){
        if(rear==size-1){
            return true;
        }
        return false;
    }
    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue Overflow");
            return;
        }else if(front==-1 && rear==-1){
            front=rear=0;
            arr[rear] = data;
        }else{
            rear++;
            arr[rear] = data;
        }
    }

    boolean isEmpty(){
        if(rear==-1 && front==-1){
            return true;
        }
        return false;
    }
    void dequeue(){

        if(isEmpty()){
            System.out.println("Queue Underflow");
            return;
        }else if(front==rear){ // it means the queue is having oly one element
            front=rear=-1;
        }else{
            System.out.println(arr[front] + " is deleted");
            front++;
        }
    }
    void peek(){
        if(front==-1 && rear==-1){
            System.out.println("QUeue is empty");
        }else{
            System.out.println("Peek/Front element = " + arr[front]);
        }
    }
    void display(){
        if(rear==-1 && front==-1){
            System.out.println("Queue is empty");
        }else{
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){

        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.dequeue();
        q.peek();
        q.dequeue();
        q.dequeue();

        q.display();
    }

     
}


