//MINIMUM NO OF VERTICES TO RACH EACH NODE 

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int indegree[] = new int[n];
        
        
        
        for(int j=0;j<edges.size();j++){
            
            indegree[edges.get(j).get(1)]++;
            
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<indegree.length;i++){
            
            if(indegree[i] == 0){
                ans.add(i);
            }
        }
        
        return ans;
    }
}



class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    
        // make into adj list 
        // call 

         boolean[] visited = new boolean[n];
        
        //List to hold final answer
        List<Integer> nodes = new ArrayList<>();
        
        //Iterate through all nodes as there maybe some nodes without any edges coming into it i.e indegree = 0
        
        for (int i =0;i<graph.size();i++)
        {
            if (!visited[i])
            {
                dfs(graph,i,visited);
            }
        }
        
        for(int i =0;i<n;i++)
        {
            if (!visited[i])
                nodes.add(i);
        }
        
        return nodes;
    }
    
    
    //Main driver code
    //A point to note here is that when we do dfs on a node we are not necessarily marking that node as visited
    //as there maybe a node in the upcoming iterations that also visits this node
    // That way we do not have to include redundant nodes and this way we obtain the minimum number of nodes 
    
    public static void dfs(List<List<Integer>>graph,int index,boolean[] visited)
    {    
            //Visit the neighbours of the node
            //Also visit all the neighbours of the neighbour and so on and so forth untill none remain
            if (!visited[nei])
            {
            visited[nei] = true;
            dfs(graph,nei,visited);
            }
        }
            
    }
}   

