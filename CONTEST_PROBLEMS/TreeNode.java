package CONTEST_PROBLEMS;

public class TreeNode {
    public int val;
    public TreeNode left, right;
    TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    TreeNode(TreeNode left, TreeNode right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
