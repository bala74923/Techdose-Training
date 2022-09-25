package FREQUENT_QUESTIONS;

public class _86_lowest_common_ancestor_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root ==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode  right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
}
