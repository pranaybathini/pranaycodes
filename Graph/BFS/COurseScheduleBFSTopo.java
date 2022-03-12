//https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int v, int[][] edges) {
       ArrayList<Integer>[] adj = new ArrayList[v];
       int[] indegree = new int[v];
        
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            adj[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0) q.add(i);
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            Integer node = q.poll();
            for(int it:adj[node]){
                if(--indegree[it] == 0)q.add(it);
            }
        }
        
        return cnt==v;
    }
}
