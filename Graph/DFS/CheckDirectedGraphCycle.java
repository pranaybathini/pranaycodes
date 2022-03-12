public boolean check(ArrayList<ArrayList<Integer>> adj, int v){

boolean vis[] = new boolean[v];
boolean dfsv[] = new boolean[v]; // to check parent in recursive stack or not

  
    for(int i=0;i<v;i++){
      if(vis[i] == false){ 
          if(checkForCycle(i,vis,dfsv,adj)){
            return true; 
          }
      }
    }
  return false;
}


public boolean checkForCycle(int n, boolean[] vis, boolean[] dfsv, ArrayList<ArrayList<Integer>> adj){
  vis[n] = true;
  dfsv[n] = true;
  
  for(int i: adj.get(n)){
    if(vis[i] == false){
        if(checkForCycle(i, vis, adj, n)){
            return true;
        }
    }else if(dfsv[n] == true){
          return true; 
        }
  }
  
  dfs[n] = false;
  return false;
  
}
