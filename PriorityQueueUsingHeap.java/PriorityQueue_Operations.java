import java.util.ArrayList;

class PriorityQueue{

    ArrayList<Integer> ans;

    PriorityQueue(){
        ans = new ArrayList<>();
    }

    void swap(int i1,int i2){
        int ith = ans.get(i1);
        int jth = ans.get(i2);

        ans.set(i1,jth);
        ans.set(i2,ith);
    }
    void upheapify(int pos){

        if(pos==0) return;

        int pi = (pos-1)/2;

        while(ans.get(pos)<ans.get(pi)){
            swap(pos,pi);
            upheapify(pi);
        }

    }
    void add(int ele){
        
        ans.add(ele);
        upheapify(ans.size()-1);
    }

    void downheapify(int pos){

        int li = pos*2+1;
        int ri = pos*2+2;
        int mini = pos;

        if(li<ans.size() && ans.get(mini)>ans.get(li)){
            mini = li;
        }
        if(ri<ans.size() && ans.get(mini)>ans.get(ri)){
            mini = ri;
        }

        while(mini!=pos){
            swap(mini,pos);
            downheapify(mini);  
        }

    }
    int remove(){
        
        swap(0,ans.size()-1);
        int val = ans.remove(ans.size()-1);
        downheapify(0);

        return val;
    }


    int peek(){

        if(ans.size()==0){
            System.out.println("Underflow");
            return -1;
        }

        return ans.get(0);
    }

    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(2);
        pq.add(19);
        pq.add(13);
        pq.add(6);
        pq.add(3);


        System.out.println(pq.peek() +  " is top element ");
        int ans = pq.remove();

        System.out.println(ans + " removes");
    }
}