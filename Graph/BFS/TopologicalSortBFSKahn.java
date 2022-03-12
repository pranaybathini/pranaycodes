
class Solution
{
    //Function to return list containing vertices in Topological order. 
   //kahn's algo
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] topo = new int[V];
        int[] indegree = new int[V];
        
        for(int i=0;i<V;i++){
            for(int ad : adj.get(i)){
                indegree[ad]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0)q.add(i);
        }
        
        int count = 0;
        int ind=0;
        
        while(!q.isEmpty()){
            Integer node  = q.poll();
            topo[ind++] = node;
            
            for(int ad : adj.get(node)){
                indegree[ad]--;
                if(indegree[ad] == 0) q.add(ad);
            }
            
        }
        
        return topo;
    }
}
