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
    public List<Double> averageOfLevels(TreeNode root) {
       if(root == null) {
           List<Double> list = new ArrayList<>();
           list.add(0.00);
           return list;
       }
        
       Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Double> list = new ArrayList<>();
        
        while(q.size() != 0) {
            int qs = q.size();
            double avg = 0.00;
            for(int i=1;i<=qs;i++) {
                //remove
                TreeNode front = q.remove();
                avg += front.val;
                
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            avg = avg/qs;
            list.add(avg);
        }
        
        return list;
    }
}