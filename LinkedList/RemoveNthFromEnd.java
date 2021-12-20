/**
 * Problem - https://leetcode.com/problems/remove-nth-node-from-end-of-list
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n==1){
            return null;
        }
        ListNode ptr1 = head, ptr2 = head;
        
        if(n==1){
            while(ptr1.next.next != null){
                ptr1 = ptr1.next;
            }
                ptr1.next = null;
            return head;
            
        }
        
        while(n>1){
            ptr2 = ptr2.next;
            n--;
        }
        
        while(ptr2.next!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr1.val = ptr1.next.val;
        ptr1.next = ptr1.next.next;
        return head;
        
    }
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}
    //count approach - 2 iterations
        public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy.next; 
        while(curr!=null){
            curr=curr.next;
            ++total;
        }
        curr = dummy;
        int target = total-n;
        int count=0;
        while(count<target){
            ++count;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
