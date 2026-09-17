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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,-1000);
        return count;
    }

    private void dfs(TreeNode root, int prevVal){
        if(root==null) return;
        if(root.val>=prevVal) count++;
        prevVal = Math.max(prevVal, root.val);
        dfs(root.left, prevVal);
        dfs(root.right, prevVal);
    }
}
