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
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode temp = q.poll();
                if(temp!=null){
                    q.add(temp.left);
                    q.add(temp.right);
                    level.add(temp.val);
                }
            }
            if (level.size() > 0) {
                result.add(level);
            }
        }
        return result;
    }
}
