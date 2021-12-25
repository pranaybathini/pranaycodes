//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1, j =0, platformNeeded=1, max = 1;
        
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platformNeeded++;
                i++;
            }else if(arr[i]>dep[j]){
                 platformNeeded--;
                j++;
            }
            
            if(platformNeeded>max){
                max = platformNeeded;
            }
        }
        
        return max;
        
    }
    
}
