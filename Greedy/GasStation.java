//https://leetcode.com/problems/gas-station/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total =0, tank =0, start=0;
        for(int i=0;i<gas.length;i++){
            int current = gas[i]-cost[i];
            tank += current;
            total += current;
            if(tank <0){
                // if this is true, car cannot reach next station
                start = i+1;
                tank=0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
