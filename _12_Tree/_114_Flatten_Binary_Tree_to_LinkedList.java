package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _114_Flatten_Binary_Tree_to_LinkedList {
    public void flatten(TreeNode root) {
        go(root);
    }
    TreeNode go(TreeNode root){
        if(root==null) return null;
        TreeNode lend = go(root.left);
        TreeNode rend = go(root.right);
        if(lend!=null){
            lend.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        return rend==null?(lend!=null?lend:root):rend;
    }
}
