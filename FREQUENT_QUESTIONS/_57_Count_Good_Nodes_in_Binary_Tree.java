package FREQUENT_QUESTIONS;



public class _57_Count_Good_Nodes_in_Binary_Tree {
    public int goodNodes(TreeNode root) {
        return get(root,root.val);
    }
    int get(TreeNode root,int val){
        if(root==null)
            return 0;
        int left = get(root.left,Math.max(val,root.val));
        int right = get(root.right,Math.max(val,root.val));
        return left+right+(val<=root.val?1:0);
    }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
