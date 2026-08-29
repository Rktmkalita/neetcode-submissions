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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow = head;
        while(prev!=null && slow!=null){
            ListNode l1Next = slow.next;
            slow.next = prev;
            ListNode l2Next = prev.next;
            slow = l1Next;
            prev.next = slow;
            prev = l2Next;
        }
        if(slow!=null)
            slow.next = null;
    }
}
