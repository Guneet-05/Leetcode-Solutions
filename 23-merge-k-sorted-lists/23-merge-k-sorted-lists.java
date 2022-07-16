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
    
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode dummy = new ListNode(-1000);
        ListNode h = dummy;
        ListNode p = list1, r = null, q = list2, s = null;
        
        while(p != null && q != null) {
            if(p.val < q.val) {
                h.next = p;
                r = p;
                p = p.next;
                h = h.next;
            } else if(q.val < p.val) {
                h.next = q;
                s = q;
                q = q.next;
                h = h.next;
            } else {
                h.next = p;
                r = p;
                p = p.next;
                r.next = q;
                s = q;
                q = q.next;
                h = s;
            }
        }
        
        while(p != null) {
            h.next = p;
            h = p;
            p = p.next;
        }
        
        while(q != null) {
            h.next = q;
            h = q;
            q = q.next;
        }
        
        return dummy.next;
    }
    
    public ListNode mergeLists(ListNode[] lists, int lo, int hi) {
        
        if(lo == hi) {
            return lists[lo];
        }
        
        int mid = lo + (hi-lo)/2;
        
        ListNode leftHalf = mergeLists(lists,lo,mid);
        ListNode rightHalf = mergeLists(lists,mid + 1,hi);
        
        ListNode merged = mergeTwoLists(leftHalf,rightHalf);
        return merged;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0 || lists == null) return null;
        
        return mergeLists(lists,0,lists.length-1);
    }
}