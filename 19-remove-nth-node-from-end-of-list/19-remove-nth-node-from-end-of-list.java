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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        if(head.next == null) {
            head = null;
            return head;
        }
        
//         if(head.next.next == null) {
//             if(n == 1) {
//                 head.next = null;
//                 return head;
//             } else {
//                 head = head.next;
//                 return head;
//             }
//         }
        
        ListNode s = head;
        ListNode f = head;
        ListNode p = null;
        
        for(int i=1;i<n;i++) {
            f = f.next;
        }
        
        while(f.next != null) {
            f = f.next;
            p = s;
            s = s.next;
        }
        
        if(s == head) {
            head = head.next;
            return head;
        }
        p.next = p.next.next;
        return head;
    }
}