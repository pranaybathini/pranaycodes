/**
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| head.next == null||k==0) return head;
        
        int i=0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        
        while(temp!=null){
            temp = temp.next;
            i++;
        }
        
        if(k>i)k = k%i;
                if(i == k || k ==0)return head;

        temp = dummy;
        
        for(int j=1;j<=k+1;j++){
            temp = temp.next;
        }
        
        ListNode second = dummy;
        
        while(temp!=null){
            second  = second.next;
            temp = temp.next;
        }
        
        temp = second.next;
        second.next = null;
        
        ListNode temp2 = temp;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        
        temp2.next = dummy.next;
        return temp;
        
        
    }
}
