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

    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        inorder(root, new int[]{k}, res);
        return res[0];
    }

    private void inorder(TreeNode root, int[] k, int[] res){
        if(root == null)    return;
        inorder(root.left, k, res);
        k[0]=k[0]-1;
        if(k[0]==0){
            res[0] = root.val;
            return;
        }
        inorder(root.right, k, res);
    }
}
