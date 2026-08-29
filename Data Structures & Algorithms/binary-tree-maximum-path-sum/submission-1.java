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
    int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)  return 0;
        dfs(root);
        return maxVal;
    }

    int dfs(TreeNode root){
        if(root==null)  return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = Math.max(left,0);
        right = Math.max(right,0);
        maxVal = Math.max(left+right+root.val,maxVal);
        return root.val+Math.max(left,right);
    }
}
