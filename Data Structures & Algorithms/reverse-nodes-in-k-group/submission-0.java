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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true){
            ListNode kthNode = findKthNode(groupPrev,k);
            if(kthNode==null){
                break;
            }
            ListNode groupNext = kthNode.next;
            ListNode curr = groupPrev.next;
            ListNode prev = kthNode.next;
            while(curr!=groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode findKthNode(ListNode head, int k){
        while(head!=null && k>0){
            head = head.next;
            k--;
        }
        return head;
    }
}
