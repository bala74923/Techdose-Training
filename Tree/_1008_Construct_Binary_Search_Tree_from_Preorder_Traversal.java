package Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
    class Solution {

        int index ;
        public TreeNode bstFromPreorder(int[] preorder) {
            index = 0;
            return build(preorder,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        TreeNode build(int[] arr,long left,long right){
            //if satisfies the condition build else terminate this branch
            if(index>=arr.length || arr[index]<left || arr[index]>right)
                return null;
            TreeNode curr= new TreeNode(arr[index++]);
            curr.left = build(arr,left,curr.val);
            curr.right = build(arr,curr.val,right);
            return curr;
        }
    }
}
