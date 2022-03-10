public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<B;i++){
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        }
        arr.add(map.size());
        for(int i=B;i<A.size();i++){
            if(map.get(A.get(i-B))== 1) map.remove(A.get(i-B));
            else map.put(A.get(i-B),map.get(A.get(i-B))-1);
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
            arr.add(map.size());
        }

        return arr;
    }
}
