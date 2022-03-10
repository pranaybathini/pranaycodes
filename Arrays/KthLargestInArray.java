// 
// O(N * logN)
class Solution {
    public int findKthLargest(int[] nums, int k) {
       Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

//O(N*logk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
}

//Best & Avg case O(n0) with quick select -> Same Partition Algo used in quick sort

class Solution {
    public int findKthLargest(int[] nums, int k) {
       k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    int partition(int nums[], int lo, int hi){
      int pivot = nums[hi];
      int i = lo;

      for(int j=lo;j<hi;j++){
         if(nums[j]<=pivot){
            swap(nums,i,j); i++;
         }
      }
      swap(nums,i,hi);
      return i;
    }
    
     private void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
