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
        int size = 0;
        ListNode curr = head;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        if(size==n) return head.next;
        curr = head;
        int pos = 1;
        while(pos++<size-n){
            curr=curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
