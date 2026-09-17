/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for(int i=0; i<n;i++){
                TreeNode node = q.poll();
                if(node!=null){
                    level.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(!level.isEmpty())
                res.add(level);
        }
        return res;
    }
}
