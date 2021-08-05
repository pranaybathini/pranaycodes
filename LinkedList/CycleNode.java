/**
 * Problem - https://leetcode.com/problems/linked-list-cycle-ii/
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == head){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        boolean cycle = false;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        
        if(!cycle){
            return null;
        }
        
        slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;

    }
}
