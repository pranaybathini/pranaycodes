/**
 * Problem - https://leetcode.com/problems/design-browser-history/
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

class BrowserHistory {
    
    ListNode ptr = null;

    public BrowserHistory(String homepage) {
        ptr = new ListNode(homepage);
    }
    
    public void visit(String url) {
        if(ptr.next!= null){
            ptr.next.prev = null;
        }
        ptr.next = new ListNode(url);
        ptr.next.prev = ptr;
        ptr = ptr.next;
    }
    
    public String back(int steps) {
        while(ptr.prev != null && (steps-- != 0)){
            ptr = ptr.prev;
        }
        return ptr.data;
    }
    
    public String forward(int steps) {
         while(ptr.next != null && steps-- != 0){
            ptr = ptr.next;
        }
        return ptr.data;
    }
}

class ListNode{
    String data;
    ListNode next;
    ListNode prev;
    
    ListNode(){
        
    }
    
    ListNode(String data){
        this.data = data;
        this.next = this.prev = null;
    }
}

