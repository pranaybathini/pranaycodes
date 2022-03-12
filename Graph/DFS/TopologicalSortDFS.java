class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] topo = new int[V];
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<V;i++){
           if(vis[i] == false){
               dfs(i,adj,st,vis);
           }
        }
        
        int i = 0;
        while(!st.isEmpty()){
            topo[i++] = st.pop();
        }
        
        
        return topo;
    }
    
    static void dfs(int n, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] vis){
        vis[n] = true;
        
        for(int ad : adj.get(n)){
            if(vis[ad] == false){
                dfs(ad,adj,st,vis);
            }
        }
        
        st.push(n);
    }
}
