//https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] arr) {
        int l=0,r=arr.length-1,lm=0,rm=0,res=0;
        
        while(l<r){
            if(arr[l]<=arr[r]){
                if(lm<arr[l]){
                    lm = arr[l];
                }else{
                    res += lm-arr[l];
                }
                l++;
            }else{
                if(rm<arr[r]){
                    rm = arr[r];
                }else{
                    res += rm-arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
