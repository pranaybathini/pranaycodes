class Solution {
  // best
    public int maxProfit(int[] prices) {
       int min = prices[0], max=0;
        for(int price : prices){
            min = Math.min(min, price);
            max = Math.max(max, price-min);
        }
        return max;

    }
  
  //Extra Space - O(n)
  
      public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        
        int len = prices.length;
        int maxPrices[] = new int[len];
        
        int revLen = len-1, maxLeft = 0;
        
        while(revLen >= 0){
            maxLeft = Math.max(prices[revLen],maxLeft);
            maxPrices[revLen--] = maxLeft;
        }
        
        int max = 0;
        
        for(int i=0;i<len;i++){
            max = Math.max(maxPrices[i]-prices[i], max);
        }
        
        return max;

    }
}
