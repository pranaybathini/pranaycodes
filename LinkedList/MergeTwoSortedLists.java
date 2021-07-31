/**
 * Problem - https://leetcode.com/problems/merge-two-sorted-lists/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null ){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
        
            ListNode start = null;
            ListNode result = null;
        
            while(l1!=null && l2!=null){
                
                if(l1.val < l2.val){
                    if(start == null){
                        start = l1;
                        result = l1;
                        l1 = l1.next;
                    }else{
                    start.next = l1;
                    start = start.next;
                    l1 = l1.next;
                  }
                }else{
                    if(start == null){
                        start = l2;
                         result = l2;
                        l2 = l2.next;
                    }else{
                    start.next = l2;
                    start = start.next;
                    l2 = l2.next;
                    }
                    
                }
            }
        
        if(l1== null){
            start.next = l2;
        }
        
        if(l2 == null){
            start.next = l1;
        }
        
        return result;
    }
}
