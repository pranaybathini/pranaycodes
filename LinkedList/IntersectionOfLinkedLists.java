/**
  * Problem - https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;


//Stack approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();
        boolean intersect = false;
        
        while(headA!=null){
            stackA.push(headA);
            headA = headA.next;
        }
        
        while(headB!=null){
            stackB.push(headB);
            headB = headB.next;
        }
        
        ListNode lastNode = null;
        
        while(!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek() ){
            lastNode = stackA.pop();
            stackB.pop();
        }

        
        return lastNode;

    }
}


// other approaches - finding the difference and travelling the difference in the long list. Now both pointers are at same position from intersection if any and travel one step at a time to find it out.
// make a cycle with one list by connecting head and tail. THen from other list find the start of the cycle. 
// genious of an approach - https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len! 
// suppose a = 4 nodes, b = 6 nodes. Intersection at last 2nd node.  Travel both nodes 1 step, if ptr reaches null, reset a node to b start and vice-versa. 
// After the longer list reaches list end, they start at same distance from intersection node. 

public class SolutionB {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a!=b){
            a = a==null ? headB : a.next;
            b = b==null ? headA : b.next;
        }

        
        return a;

    }
}
