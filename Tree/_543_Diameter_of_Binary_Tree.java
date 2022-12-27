package Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _543_Diameter_of_Binary_Tree {
    class Solution {
        int res =0 ;
        public int diameterOfBinaryTree(TreeNode root) {
            res =0;
            depth(root);
            return res;
        }
        int depth(TreeNode root){
            if(root==null)
                return 0;
            int left = depth(root.left);
            int right = depth(root.right);
            res = Math.max(res,left+right);
            return Math.max(left,right)+1;
        }
    }
}
