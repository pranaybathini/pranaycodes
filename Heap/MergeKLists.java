/**
 * Definition for singly-linked list.
 *https://leetcode.com/problems/merge-k-sorted-lists
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        
        ListNode dummy = new ListNode();
        ListNode tail  = dummy;
        
        for(ListNode l : lists){
            if(l!=null) pq.add(l);
        }
        
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            
            if(tail.next!=null){
                pq.add(tail.next);
            }
        }
        
        return dummy.next;
    }
}
