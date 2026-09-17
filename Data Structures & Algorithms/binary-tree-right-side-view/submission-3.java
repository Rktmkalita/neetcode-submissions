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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            for(int i=q.size(); i>0; i--){
                TreeNode node = q.poll();
                if(node!=null){
                    level.add(node.val);
                    q.add(node.right);
                    q.add(node.left);
                }
            }
            if(!level.isEmpty()){
                res.add(level.get(0));
            }
        }
        return res;
    }
}
