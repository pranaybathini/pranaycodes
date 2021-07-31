/**
 * Problem - https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode ptr = head;
        
        while(ptr.next != null){
            if(ptr.val == ptr.next.val){
                ptr.next = ptr.next.next;
            }else{
                ptr = ptr.next;
            }
        }
        
        return head;
    }
}
