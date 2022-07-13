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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        List<List<Integer>> res = new ArrayList<>();
        
        while(q.size() > 0) {
            int qs = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<=qs;i++) {
                TreeNode front = q.remove();
                list.add(front.val);
                
                if(front.left != null)
                    q.add(front.left);
                
                if(front.right != null)
                    q.add(front.right);
            }
            res.add(list);
        }
        
        return res;
    }
}