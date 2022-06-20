//https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        boolean[] visit = new boolean[lastDay+1];
        
        for(int day : days){
            visit[day] = true;
        }
        
        for(int i=1;i<=lastDay;i++){
            if(!visit[i]){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = cost[0] + dp[i-1];
            dp[i] = Math.min(dp[i], cost[1]+dp[Math.max(i-7,0)]);
            dp[i] = Math.min(dp[i], cost[2]+dp[Math.max(i-30,0)]);
        }
        return dp[lastDay];
    }
}
