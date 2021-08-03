/**
 * Problem - https://leetcode.com/problems/merge-in-between-linked-lists/
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr1 = list1;
        int size=0;
        while(size!=(a-1)){
            ptr1 = ptr1.next;
            size++;
        }
        
        ListNode ptr2 = ptr1.next;
        ptr1.next = list2;
        
        ListNode ptr3 = list2;
        
         while(ptr3.next!=null){
            ptr3 = ptr3.next;
        }
        
        while(size!=(b-1)){
            ptr2 = ptr2.next;
            size++;
        }
        
        ptr3.next = ptr2.next;
        
        return list1;
    }
}
