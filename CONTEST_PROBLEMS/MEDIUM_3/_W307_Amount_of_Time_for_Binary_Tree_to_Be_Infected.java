package CONTEST_PROBLEMS.MEDIUM_3;

import CONTEST_PROBLEMS.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class _W307_Amount_of_Time_for_Binary_Tree_to_Be_Infected {
    Map<TreeNode,List<TreeNode>> map;
    TreeNode startNode;
    int startVal;
    int  solve(TreeNode root, int start){
        this.startVal = start;
        Map<TreeNode,List<TreeNode>> map = toGraph(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startNode);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode front = q.poll();
                for(TreeNode adj: map.getOrDefault(front,new ArrayList<>())){
                    if(!visited.contains(adj)){
                        q.add(adj);
                        visited.add(adj);
                    }
                }
                map.remove(front);
            }
            level++;
        }
        return level;
    }
    Map<TreeNode,List<TreeNode>> toGraph(TreeNode root){
        map = new HashMap<>();
        startNode = null;
        inorder(root);
        return map;
    }
    void inorder(TreeNode root ){
        if(root==null) return ;
        if(root.left!=null)
            addEdge(root,root.left,map);
        if(root.right!=null)
            addEdge(root,root.right,map);
        if(root.val==startVal) startNode= root;
        inorder(root.left);
        inorder(root.right);
    }
    void addEdge(TreeNode p,TreeNode c,Map<TreeNode,List<TreeNode>> map){
        List<TreeNode> childs =  map.getOrDefault(p,new ArrayList<>());
        childs.add(c);
        map.put(p,childs);

        List<TreeNode> parents = map.getOrDefault(c,new ArrayList<>());
        parents.add(p);
        map.put(c,parents);
    }
}
