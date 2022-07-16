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
        ListNode dummy = new ListNode(1000);
        ListNode c = head;
        ListNode p = dummy;
        
        while(c != null && c.next != null) {
            if(c.val == c.next.val) {
                int x = c.val;
                while(c != null && c.val == x) {
                    c = c.next;
                }
            } else {
                p.next = c;
                p = c;
                c = c.next;
            }
        }
        
        if(c == null) p.next = null;
        else {
            p.next = c;
        }
        
        return dummy.next;
    }
}