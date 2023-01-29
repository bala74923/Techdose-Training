package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null || root==p || root ==q) return root;
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode  right = lowestCommonAncestor(root.right,p,q);
            if(left!=null && right!=null) return root;
            return left!=null?left:right;
        }
    }
}
