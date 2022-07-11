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
    
    static class Pair {
        int h;
        boolean isBalanced;
        
        Pair() {
            h = 0;
            isBalanced = true;
        }
        
        Pair(int h, boolean isBalanced) {
            this.h = h;
            this.isBalanced = isBalanced;
        }
    }
    
    public Pair helper(TreeNode root) {
        
        if(root == null) {
            Pair p = new Pair();
            return p;
        }
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        Pair p = new Pair();
        p.h = Math.max(left.h,right.h) + 1;
        p.isBalanced = (Math.abs(left.h - right.h) <= 1) && (left.isBalanced == true)
            && (right.isBalanced == true);
        
        return p;
    }
    
    public boolean isBalanced(TreeNode root) {
        Pair res = helper(root);
        return res.isBalanced;
    }
}