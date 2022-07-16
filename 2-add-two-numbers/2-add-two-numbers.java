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
    
    public ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode q = null, r = null;
        
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        head = q;
        return q;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        
        int ca = 0;
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        
        while(p != null || q != null || ca > 0) {
            int d1 = (p == null) ? 0 : p.val;
            int d2 = (q == null) ? 0 : q.val;
            
            if(p != null) p = p.next;
            if(q != null) q = q.next;
            
            int d = 0;
            if(d1 + d2 + ca >= 10) {
                d = (d1 + d2 + ca)%10;
                ca = (d1 + d2 + ca) / 10;
            } else {
                d = d1 + d2 + ca;
                ca = 0;
            }
            
            ListNode node = new ListNode(d);
            ptr.next = node;
            ptr = node;
        }
        
        return dummy.next;
    }
}