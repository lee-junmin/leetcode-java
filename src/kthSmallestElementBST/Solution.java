package kthSmallestElementBST;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
  
  
  //recursive solution
  // T O(n) S O(n)
  
  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> inTrav = new ArrayList<>();
    return gen(root, inTrav).get(k-1);
  }
  
  private ArrayList<Integer> gen(TreeNode root, ArrayList<Integer> inTrav){
    
    if (root == null) return null;
    
    gen(root.left,inTrav);
    inTrav.add(root.val); // do the main task on the root between the left and right call
    gen(root.right,inTrav);
    
    
    return inTrav;
  }
  
  // iterative solution
  // T O(N + k) S O(n) in the worst case unbalanced tree
  
  public int kthSmallest_iter(TreeNode root, int k) {
    
    Stack<TreeNode> stk = new Stack<>();
    TreeNode curr = root;
    
    while (true){
      while (curr != null){
        stk.push(curr);
        curr = curr.left;
      }
      
      curr = stk.pop();
      k--;
      if (k == 0) return curr.val;
      curr =  curr.right;
    }
    
  }
}
