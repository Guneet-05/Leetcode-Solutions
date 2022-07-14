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
    
    public TreeNode helper(int[] preorder,int[] inorder,int lop,int hip, int loi, int hii) {
        if(loi > hii) return null;
        
        int ele = preorder[lop];
        int idx = loi;
        while(inorder[idx] != ele) {
            idx++;
        }
        
        int j = idx - loi;
        
        TreeNode root = new TreeNode(ele);
        root.left = helper(preorder,inorder,lop + 1,lop + j,loi,idx -1);
        root.right = helper(preorder,inorder,lop + j + 1,hip,idx + 1,hii);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
}