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
    public ListNode partition(ListNode head, int x) {
       ListNode leftHead = new ListNode(-1);
        ListNode left = leftHead;
       ListNode rightHead = new ListNode(-1);
        ListNode right = rightHead;
        
        while(head != null) {
            if(head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
        
    }
}