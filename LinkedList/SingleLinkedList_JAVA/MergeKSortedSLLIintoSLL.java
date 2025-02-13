import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Merge
{   
    //space O(n+m) && time O(m+n)
    void merge(Node a[],int ind1,int ind2){

        Node dum = new Node(-1);
        Node ptr = dum;

        Node l1 = a[ind1];
        Node l2 = a[ind2];

        while(l1!=null || l2!=null){

            if(l1==null){
                ptr.next = l2;
                break;
            }

            if(l2==null){
                ptr.next = l1;
                break;
            }

            if(l1.data<=l2.data){
                ptr.next = l1;
                l1 = l1.next;
            }else{
                ptr.next = l2;
                l2 = l2.next;
            }

            ptr = ptr.next;
        }

        a[ind1] = dum.next;
        // return dum.next;
    }
    Node mergeKList(Node[] a,int N)
    {


        int len = a.length;
        int interval = 1;

        while(interval<len){
            for(int i=0;i<(len-interval);i+=(interval*2)){
                merge(a,i,i+interval);
            }
            interval*=2;
        }

        return a[0];
        //to join many list of array 
        // Node temp = ans;
        
        

        // for(int i=1;i<N;i++){
            
            
        //     while(temp.next!=null){
        //         temp = temp.next;
        //     }
            
        //     temp.next = a[i];
        //     // System.out.print(a[i].data+" ");
        // }
        
        // return ans;
    }
}



class LinkedList
{
    static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            // System.out.println(1);
            Merge g = new Merge();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
