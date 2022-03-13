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
        
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            
            int n = q.poll();
            
             for(int it=0;it<graph[n].length;it++){
                 int val = graph[n][it];
                if(color[val] == -1 ){
                    color[val] = color[n] == 1 ? 0 : 1;
                    q.add(val);
                }else if(color[val] == color[n]){
                    return false;
                }
             }
        }
        
       
        return true;
    }
}
