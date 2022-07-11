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
    
    static int dia = 0;
    //calculate dia and return height
    public int diameter(TreeNode root) {
        if(root == null) return 0;
        
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        
        int h = Math.max(lh,rh) + 1;
        
        dia = Math.max(dia,lh + rh + 1);
        
        return h;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        dia = 0;
        diameter(root);
        return dia -1;
    }
}