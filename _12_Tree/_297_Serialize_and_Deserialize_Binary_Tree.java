package _12_Tree;

import CONTEST_PROBLEMS.TreeNode;

public class _297_Serialize_and_Deserialize_Binary_Tree {
    public class Codec {

        StringBuilder porder;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            porder = new StringBuilder("");
            preorder(root);
            porder.deleteCharAt(0);
            return porder.toString();
        }
        void preorder(TreeNode root){
            if(root==null){
                porder.append(",null");
                return ;
            }
            porder.append(","+root.val);
            preorder(root.left);
            preorder(root.right);
        }
        int pindex;
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            pindex= 0;
            String[] arr = data.split(",");
            return build(arr);
        }
        TreeNode build(String[] arr){
            if(pindex>=arr.length || arr[pindex].equals("null")){
                pindex++;
                return null;
            }
            TreeNode curr = new TreeNode(Integer.parseInt(
                    arr[pindex++]));
            curr.left = build(arr);
            curr.right = build(arr);
            return curr;
        }
    }
}
