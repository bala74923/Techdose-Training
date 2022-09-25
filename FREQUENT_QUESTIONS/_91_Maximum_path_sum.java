package FREQUENT_QUESTIONS;

public class _91_Maximum_path_sum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = -(int)1e9;
        go(root);
        return max;
    }
    int go(TreeNode root){
        if(root==null) return 0;
        int left = go(root.left);
        int right = go(root.right);
        max=Math.max(max,left+right+root.val);
        return Math.max(root.val+ Math.max(left,right),0);
    }
}
