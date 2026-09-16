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
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode node = list.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            
            if(right!=null){
                list.add(right);
                map.put(right, node);
            }

            if(left!=null){
                list.add(left);
                map.put(left, node);
            }
        }

        Set<TreeNode> pAncestors = new HashSet<>();
        while(p!=null){
            pAncestors.add(p);
            p = map.get(p);  
        }

        while(!pAncestors.contains(q)){
            q = map.get(q);
        }

        return q;
    }
}