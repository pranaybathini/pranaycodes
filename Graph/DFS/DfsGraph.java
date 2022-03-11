public ArrayList<Integer> DfsGraph(int V, ArrayList<ArrayList<Integer>> adj){
    ArrayList<Integer> dfsList = new ArrayList<>();
    boolean[] visited = new boolean[V+1]; // nodes start from 1
    for(int i=1;i<=V;i++){
       if(visited[i] == false){
          dfs(i,visited,adj,dfsList);
       }
    }
  return dfsList;
}

public void dfs(int node,  boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList ){
   dfsList.add(node);
   visited[node] = true;
   for(Integer i : adj.get(node)){
      if(visited[i] == false){
        dfs(i, visited, adj, dfsList);
      }
   }
}
