package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _226_Invert_Binary_Tree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            rev(root);
            return root;
        }
        void rev(TreeNode root){
            if(root== null)
                return ;
            rev(root.left);
            rev(root.right);
            TreeNode temp  = root.left;
            root.left = root.right;
            root.right= temp;
        }
    }
}
