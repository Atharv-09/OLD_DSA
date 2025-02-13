class Graph{

	class Node{

		String key;
		double val;

		Node(String d,double v){
			key = d;
			val = v;
		}

	}

	Map<String,List<Node>> buildGraph(List<List<String>> eq,double[] values){


			Map<String,List<Node>> map = new HashMap();

			for(int i=0;i<values.length;i++){

				String src = eq.get(i).get(0);
				String des = eq.get(i).get(1);


				map.putIfAbsent(src,new ArrayList<>());
				map.putIfAbsent(des,new ArrayList<>());

				map.get(src).add(new Node(des,values[i]));
				map.get(des).add(new Node(src,1/values[i]))	;
			}

			return map;

	}	

	double dfsUtil(String src,String des,Set<String> vis,Map<String,List<Node>> gr){

		//if any of vertex is not contains in our graph then we return -1 

		if(!(gr.containsKey(src) && gr.containsKey(des)))
			return -1.0;

		if(src.equals(des))
			return 1.0;

		vis.add(src);

		for(Node nei:gr.get(src)){

			if(!vis.contains(nei.key)){
				double ans = dfsUtil(nei.key,des,vis,gr);

				if(ans!=-1.0)
					return ans*nei.val; // i.e 
				//	if we hav a/b = 2.0 b/c = 4.0 
				//then a/c = a*b = 8.0
			}
		}
		return -1.0;

	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        	
        	Map<String,List<Node>> gr = buildGraph(equations,values);


        	double ans[] = new double[queries.size()];
        	

        	for(int i=0;i<queries.size();i++){

        		ans[i] = dfsUtil(queries.get(i).get(0),queries.get(i).get(1),new HashSet(),gr);

        	}
        
        return ans;
    }

	public static void main(String[] args) {
		

	}
}