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
        ListNode curr = head;
        List<Integer> list = new ArrayList<>();
        while(curr!=null){
            list.add(curr.val);
            curr = curr.next;
        }
        curr = head;
        for(int i=0;i<list.size()/2;i++){
            curr.val=list.get(i);
            curr=curr.next;
            curr.val=list.get(list.size()-i-1);
            curr=curr.next;
        }
        if(list.size()%2!=0) curr.val=list.get(list.size()/2);
    }
}
