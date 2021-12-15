//https://www.interviewbit.com/problems/subarray-with-given-xor/
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int xr=0,cnt=0;
        for(int i=0;i<A.size();i++){
            xr = xr^A.get(i);
            if(map.containsKey(xr^B)){
                cnt += map.get(xr^B);
            }
            if(xr == B){
                cnt++;
            }
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return cnt;
    }
}
