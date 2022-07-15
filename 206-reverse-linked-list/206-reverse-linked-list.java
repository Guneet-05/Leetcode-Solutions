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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        head = q;
        return head;
    }
}