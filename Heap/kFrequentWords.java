//https://leetcode.com/problems/top-k-frequent-words/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map  = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>((a,b)->{
                if(a.getValue()!=b.getValue())
                     return  Integer.compare(a.getValue(),b.getValue());
                return b.getKey().compareTo(a.getKey());    
                });
        
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(Map.Entry<String,Integer> me : map.entrySet()){
            pq.add(me);
            if(pq.size()>k) pq.poll();
        }
        
        List<String> list = new ArrayList<>();
        for(int i=0;i<k;i++) list.add(0,pq.poll().getKey());
        return list;
    }
}
