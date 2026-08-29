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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root,0);
        return res;
    }
    int dfs(TreeNode root, int h){
        if(root==null){
            return 0;
        }
        if(!res){
            return 0;
        }
        int left = dfs(root.left,h+1);
        int right = dfs(root.right,h+1);
        if(Math.abs(left-right)>1){
            res=false;
        }
        return 1+Math.max(left,right);
    }
}
