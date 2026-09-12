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
        return helper(root,0);
    }

    private int helper(TreeNode root, int count){
        if(root==null){
           return 0;
        }
        return 1 + Math.max(helper(root.left, count++), helper(root.right, count++));
    }
}
