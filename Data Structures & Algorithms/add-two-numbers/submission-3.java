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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while(l1!=null || l2!=null){
            int val1 = l1!=null? l1.val : 0;
            int val2 = l2!=null? l2.val : 0;
            int sum = val1 + val2 + carry;
            int digit = sum%10;
            carry = sum/10;
            ListNode curr = new ListNode(digit);
            result.next = curr;
            result=result.next;
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        if(carry!=0){
            ListNode extra = new ListNode(carry);
            result.next=extra;
        }
        return head.next;
    }
}
