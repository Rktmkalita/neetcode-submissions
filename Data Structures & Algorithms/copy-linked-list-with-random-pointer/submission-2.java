/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        while(curr!=null){
            Node node = new Node(curr.val);
            map.put(curr,node);
            curr = curr.next;
        }
        curr=head;
        while(curr!=null){
            map.get(curr).random = map.get(curr.random);
            map.get(curr).next = map.get(curr.next);
            curr=curr.next;
        }
        return map.get(head);
    }
}
