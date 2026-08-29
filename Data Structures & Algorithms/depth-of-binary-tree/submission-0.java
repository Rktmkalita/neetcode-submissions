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
    public int maxDepth(TreeNode root) {
        int maxHeight = 0;
        return helper(root, 0, maxHeight);
    }
    private int helper(TreeNode root, int height, int maxHeight){
        if(root==null){
            return Math.max(height,maxHeight);
        }
        height++;
        maxHeight = Math.max(helper(root.left,height,maxHeight),maxHeight);
        maxHeight = Math.max(helper(root.right,height,maxHeight),maxHeight);
        return maxHeight;
    }
}
