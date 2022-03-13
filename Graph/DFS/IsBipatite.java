//https://leetcode.com/problems/is-graph-bipartite/
class Solution {
    public boolean isBipartite(int[][] graph) {
        
       int[] color = new int[graph.length];
       Arrays.fill(color,-1); 
        
       for(int i=0;i<graph.length;i++){
           if(color[i] == -1){
               color[i] = 0;
               if(!isBipartite(i,graph,color)){
                   return false;
               }
           }
       }
        
        return true;
    }
    
    boolean isBipartite(int node, int[][] graph, int[] color){
        
     for(int it=0;it<graph[node].length;it++){
          int val = graph[node][it];
          if(color[val] == -1 ){
             color[val] = color[node] == 1 ? 0 : 1;
             if(!isBipartite(val, graph,color)){
                 return false;
             }
          }else if(color[val] == color[node]){
                    return false;
                }
          }
       
        return true;
    }
}
