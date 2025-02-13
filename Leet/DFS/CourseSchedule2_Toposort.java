/*
	
	STACK + DFS 

*/
class CourseSchedule2{
	boolean isCyclic = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge:prerequisites)
            graph.get(edge[1]).add(edge[0]);
        
        Stack<Integer> stack =  new Stack<>();
        
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            toposort(graph,stack,i,visited,recStack);
        }
        if(isCyclic)
            return new int[0];


        int[] res = new int[numCourses];
        int index = 0;
        while(!stack.isEmpty())
            res[index++] = stack.pop();
        return res;
        
    }
    
    public void toposort(ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack, int i,boolean[] visited,boolean[] recStack){
        if(recStack[i])
            isCyclic = true;
        if(visited[i])
            return;
        visited[i] = true;
        recStack[i] = true;
        for(int x:graph.get(i)){
            toposort(graph,stack,x,visited,recStack);
        }
        recStack[i] = false;
        stack.push(i);
    }

}


/*
	
	QUEUE + BFS  == using KAHN ALGO 


*/

import java.util.*;

class CourseSchedule{
    
    void addEdge(ArrayList<ArrayList<Integer>> adj,int s,int d){
        adj.get(s).add(d);
    }
    
    boolean topoSort(ArrayList<ArrayList<Integer>> adj,int index,boolean[] vis,boolean[] visitSet){
            
        if(visitSet[index]==true) return true;
        if(vis[index] == true) return false;
        vis[index] = true;
        visitSet[index] = true;
        
        for(int nei:adj.get(index)){
                if(topoSort(adj,nei,vis,visitSet))
                    return true;
        }
    // if we reach the end without finding any cycles, remove the node from exploring, and mark as visited

        visitSet[index] = false;
        return false;
        
    }
    
    boolean check(int cou,int[][] pre,boolean[] visitSet){
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<cou;i++){
            adj.add(i,new ArrayList<Integer>());
        }
        
        for(int i=0;i<pre.length;i++){
            addEdge(adj,pre[i][0],pre[i][1]);
        }
        
        boolean vis[] = new boolean[cou];
        for(int i=0;i<cou;i++){
        
            if(topoSort(adj,i,vis,visitSet))
                  return false;            
        }
        
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean visitSet[] = new boolean[numCourses];
        return check(numCourses,prerequisites,visitSet);
    }

    public static void main(String[] args) {
            
        int n = 3;
        // int[][] pre =  {{0,1},{0,2},{1,3},{1,4},{3,4}};
        int[][] pre = {{0,1},{1,2},{2,0}};
        if(new CourseSchedule().canFinish(5,pre))
            System.out.println("All the courses finishes");
        else
            System.out.println("All courses not finish as it is creating a cycle that one course depend on another and another on one so it is immpossible tp do any of the course ");
    }
}