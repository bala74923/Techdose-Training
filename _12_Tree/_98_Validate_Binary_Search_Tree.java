package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _98_Validate_Binary_Search_Tree {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root==null) return true;
            return go(root.left,Long.MIN_VALUE,root.val) && go(root.right,root.val,Long.MAX_VALUE);
        }
        boolean go(TreeNode root,long left,long right){
            if(root==null) return true;
            return go(root.left,left,root.val) && go(root.right,root.val,right) && left<root.val && root.val<right;
        }
    }
}
