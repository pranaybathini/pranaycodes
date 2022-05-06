//https://leetcode.com/problems/find-median-from-data-stream/
class MedianFinder {
    
    PriorityQueue<Integer> max = null;
    PriorityQueue<Integer> min = null;


    public MedianFinder() {
       max = new PriorityQueue<>(Collections.reverseOrder());
       min = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        
        if(min.size() < max.size()){
            min.offer(max.poll());
        }
        
    }
    
    public double findMedian() {
        if(min.size() > max.size()){
            return min.peek();
        }else{
            return (min.peek()+max.peek())/2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
