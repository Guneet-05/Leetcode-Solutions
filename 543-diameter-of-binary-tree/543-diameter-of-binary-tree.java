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
        int dia;
        
        Pair() {
            h = 0;
            dia = 0;
        }
        
        Pair(int h, int dia) {
            this.h = h;
            this.dia = dia;
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
        p.dia = Math.max(left.h + right.h + 1,Math.max(left.dia,right.dia));
        
        return p;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        Pair ans = helper(root);
        return ans.dia - 1;
    }
}