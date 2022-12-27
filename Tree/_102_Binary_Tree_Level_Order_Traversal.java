package Tree;

import CONTEST_PROBLEMS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_Binary_Tree_Level_Order_Traversal {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if(root==null) return res;

            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> sub = new ArrayList<>();
                while(size-->0){
                    TreeNode front = q.poll();
                    sub.add(front.val);
                    if(front.left!=null) q.add(front.left);
                    if(front.right!=null) q.add(front.right);
                }
                res.add(sub);
            }
            return res;
        }
    }
}
