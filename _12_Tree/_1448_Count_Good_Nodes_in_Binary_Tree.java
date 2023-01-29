package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _1448_Count_Good_Nodes_in_Binary_Tree {
    class Solution {
        public int goodNodes(TreeNode root) {
            return dfs(root,root.val);
        }
        int dfs(TreeNode root,int prev){
            if(root==null) return 0;
            int next = Math.max(prev,root.val);
            return dfs(root.left,next) +
                    dfs(root.right,next) + (prev<=root.val?1:0);
        }
    }
}
