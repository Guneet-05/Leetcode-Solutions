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
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) fast = fast.next;
        }
        
        ListNode middle = slow;
        prev.next = null;
        ListNode h1 = head;
        ListNode h2 = middle;
        
        h2 = reverse(h2);
        
        ListNode p = h1;
        ListNode q = h2;
        
        while(p != null && q!= null) {
            if(p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        
        return true;
    }
}