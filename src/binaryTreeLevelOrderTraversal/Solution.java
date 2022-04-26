package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// T O(n) S O(n) where n is the number of trees

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    
    Queue<TreeNode> qu = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    
    if (root != null) qu.offer(root);
    
    while (!qu.isEmpty()){
      
      List<Integer> vals = new ArrayList<>();
      int len = qu.size();
      for (int i=0; i<len; i++){
        TreeNode curr = qu.poll();
        
        if (curr.left != null) qu.offer(curr.left);
        if (curr.right != null) qu.offer(curr.right);
        
        vals.add(curr.val);
      }
      
      res.add(vals);
      
      
    }
    return res;
  }
}
