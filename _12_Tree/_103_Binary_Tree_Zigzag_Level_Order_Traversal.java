package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            List<List<Integer>> res = new ArrayList<>();
            if(root==null) return res;
            int level=0;
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> list=  new ArrayList<>();
                while(size-->0){
                    TreeNode front = q.poll();
                    if(level%2==0)  list.add(front.val);
                    else list.add(0,front.val);
                    if(front.left!=null) q.add(front.left);
                    if(front.right!=null) q.add(front.right);
                }
                res.add(list);
                ++level;
            }
            return res;
        }
    }
}
