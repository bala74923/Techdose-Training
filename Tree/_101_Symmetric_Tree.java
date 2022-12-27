package Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        return same(root.left,root.right);
    }
    boolean same(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null)
            return true;
        if(r1==null || r2==null)
            return false;
        return r1.val==r2.val && same(r1.left,r2.right) && same(r1.right,r2.left);
    }
}
