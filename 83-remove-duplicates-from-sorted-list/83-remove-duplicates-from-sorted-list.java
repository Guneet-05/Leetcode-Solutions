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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(1000);
        ListNode c = head;
        ListNode p = dummy;
        
        while(c != null) {
            if(p.val == c.val) {
                c = c.next;
            } else {
                p.next = c;
                p = c;
                c = c.next;
            }
        }
        
        if(p.next == null) return dummy.next;
        if(p.val == p.next.val) p.next = null;
        return dummy.next;
    }
}