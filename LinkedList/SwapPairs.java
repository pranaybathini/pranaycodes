/**
 * Problem - https://leetcode.com/problems/swap-nodes-in-pairs/
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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        return reverseKGroup(head,2);
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        boolean isValidSize = false;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
            if(size >= k){
                isValidSize = true;
                break;
            }
        }
        
        if(!isValidSize){
            return head;
        }
        
        ListNode prev = null, curr = head, next = null;
        for(int i=1;i<=k;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head.next = reverseKGroup(curr,k);
        return prev;
        
    }
}
