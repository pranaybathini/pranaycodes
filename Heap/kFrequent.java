// https://leetcode.com/problems/top-k-frequent-elements/
// MinHeap Approach - nlogk
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq =
            new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));
        
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            pq.add(mp);
            if(pq.size() > k) pq.poll();
        }
        
        int ans[] = new int[k];
        
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
