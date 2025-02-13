import java.util.ArrayList;
import java.util.Scanner;
//ADJACENCY MATRIX 
// take more space O(v^2);

// ADJACENCY LIST 
class Main{

    static void addEdge(ArrayList<ArrayList<Integer>> arr,int u,int v){

        arr.get(u).add(v);
        arr.get(v).add(u);


        // printGraph(ans);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> arr){

        for(int i=0;i<arr.size();i++){
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print("->"+arr.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices count : ");
        int v = sc.nextInt();
        System.out.print("\nEnter edges count : ");
        int e = sc.nextInt();

        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<v;i++)
            ans.add(new ArrayList<Integer>());

        
        System.out.print("\nEnter edges : ");
        for(int i=0;i<e;i++){
            addEdge(ans,sc.nextInt(),sc.nextInt());
        }

        printGraph(ans);
    }
}

/*hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/Graphs
$ java Main
Enter vertices count : 5

Enter edges count : 7

Enter edges : 0 1
0 4
1 4
1 3
4 3
2 3
1 2
Adjacency list of vertex 0
head->1->4
Adjacency list of vertex 1
head->0->4->3->2
Adjacency list of vertex 2
head->3->1
Adjacency list of vertex 3
head->1->4->2
Adjacency list of vertex 4
head->0->1->3 */