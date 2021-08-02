/**
 * Problem - https://leetcode.com/problems/next-greater-node-in-linked-list/ 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        if(head == null){
            return new int[0];
        }
        
        int size = 0;
        ListNode ptr = head;
        
        while(ptr!=null){
            ptr = ptr.next;
            size++;
        }
        
        int[] arr = new int[size];
        //Use Deque Instead of stack, as stack is a class and subclass of vector and contains synchronized methods, will be a slower
        Deque<Integer> stack = new LinkedList<Integer>();
        head = reverse(head);
        size = size-1;
        arr[size] = 0;
        stack.push(head.val);
        head = head.next;
        
        while(head!=null){
            if(!stack.isEmpty()){
                if(head.val < stack.peek()){
                    arr[--size] = stack.peek();
                    stack.push(head.val);
                }else{
                    while(!stack.isEmpty() && head.val>= stack.peek()){
                        stack.pop();
                    }
                    if(!stack.isEmpty()){
                        arr[--size] = stack.peek();
                        stack.push(head.val);
                    }else{
                        arr[--size] = 0;
                        stack.push(head.val);
                    }
                }
            }else{
                arr[size--] = 0;
                stack.push(head.val);
            }
            head = head.next;
        }
        
        return arr;
        
    }
    
    ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode prev=null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
