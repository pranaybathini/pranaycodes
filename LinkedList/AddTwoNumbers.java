/**
 * Problem - https://leetcode.com/problems/add-two-numbers/
 * /
 * 
 * 
 * /**
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //Time - O(max(l1,l2))
        //Time - O(max(l1,l2))

        if(l2 == null){
            return l1;
        }
        
        if(l1 == null){
            return l2;
        }
        
        int sum = 0, carry = 0;
        
        ListNode result = new ListNode();
        ListNode ptr = result;
        boolean isL1 =false, isL2 = false;
        
        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        
        while(l1 != null && l2 != null){
            sum = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
           // ptr.next = new ListNode(sum);
         //   ptr = ptr.next;
            l1.val = sum;
            l2.val = sum;
            if(l1.next == null && l2.next == null){
                 if(carry!=0){
                     l1.next = new ListNode(carry);
                  return l1Ptr;
                 }
                return l1Ptr;
             }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            isL1=true;
            sum = (l1.val + carry)%10;
            carry = (l1.val + carry)/10;
           // ptr.next = new ListNode(sum);
          //  ptr = ptr.next;
            l1.val = sum;
            if(l1.next == null){
                 break;
             }
            l1 = l1.next;
        }
        
         while(l2 != null){
             isL2=true;
            sum = (l2.val + carry)%10;
            carry = (l2.val + carry)/10;
           // ptr.next = new ListNode(sum);
          //  ptr = ptr.next;
            l2.val = sum;
             if(l2.next == null){
                 break;
             }
            l2 = l2.next;
        }
        
        if(carry != 0){
           // ptr.next = new ListNode(carry);
            if(isL1){
                l1.next = new ListNode(carry);
                return l1Ptr;
            }
            if(isL2){
                l2.next = new ListNode(carry);
                return l2Ptr;
            }
            
        }
        
        if(isL1){
                return l1Ptr;
            }
        
        if(isL2){
                return l2Ptr;
            }
        
        return l2Ptr;
        
    }
}