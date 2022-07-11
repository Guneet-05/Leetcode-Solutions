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
    
    public int height(TreeNode root) {
        
        if(root == null) return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh,rh) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        boolean self = ((int)Math.abs(height(root.left) - height(root.right)) <= 1) ?
            true : false;
        
        return (self && left && right) ? true : false; 
    }
}