package invertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
[recursive approach]
use recursion to swap the left and right node of an input root
where n is the number of nodes and h is the height of the tree
T O(n) S O(h)

[iterative approach]
using a queue(level order traversal) or stack(preorder traversal) to store the nodes
where n is the number of nodes in the tree

T O(n) S O(n)

*/
public class Solution {
  public TreeNode invertTree(TreeNode root) {
    
    if (root == null) return null;
    // base case - when leaf
    if (root.left == null && root.right == null) {
      return root;
    }
    
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    invertTree(root.left);
    invertTree(root.right);
    
    
    return root;
    
  }
  // iterative solution with queue (level order traversal)
  public TreeNode invertTree_q(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()){
      TreeNode parent = queue.remove();
      swap(parent);
      if (parent.left != null) queue.add(parent.left);
      if (parent.right!= null) queue.add(parent.right);
      
    }
    
    return root;
    
  }
  
  // iterative solution with stack (preorder traversal)
  public TreeNode invertTree_s(TreeNode root) {
    if (root == null) return null;
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    
    while (!stack.isEmpty()){
      TreeNode parent = stack.pop();
      swap(parent);
      if (parent.left != null) stack.push(parent.left);
      if (parent.right!= null) stack.push(parent.right);
      
    }
    
    return root;
    
  }
  
  
  
  
  private void swap(TreeNode root){
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
  
  
  
}
