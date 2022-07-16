/**
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
        if(head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        ListNode curr1 = head;
        ListNode curr2 = slow;
        
        while(curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return curr1;
    }
}