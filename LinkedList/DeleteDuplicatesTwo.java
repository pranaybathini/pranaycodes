/**
 * Problem - https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
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
        
        //By taking a dummy node, removed the case of starting duplicate nodes.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode ptr = dummy;
        
        while(ptr.next!=null){
            ListNode curr = ptr.next.next;
            boolean duplicate = false;
            while(curr!=null && curr.val == ptr.next.val){
                curr = curr.next;
                duplicate = true;
            }
            
            if(duplicate){
                ptr.next = curr;
            }else{
                ptr = ptr.next;
            }
        }
        
        return dummy.next;
    }
}
