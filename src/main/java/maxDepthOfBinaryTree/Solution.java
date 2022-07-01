package maxDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

IDEA
  3 ways of doing this. they all have time/space O(n)/O(n)
  speed was better on leetcode for DFS and BFS iterations
  
  1) recursion
  2) preorder traversal using a stack where each element stores the node and the depth
  3) level order traversal using a queue where each element is the node. depth is updated.


< Depth First Traverals >
  with 1 as the root and 2, 3 for left and right node
  
  (1)
  / \
 2   3
  
  preorder: (1) 2  3
  inorder:   2 (1) 3
  postorder: 2  3 (1)

*/
class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    
    return Math.max(left, right) + 1;
    
  }
  
  // iterative solution
  // make sure to use the poll not remove
  // The remove() and poll() methods differ only in their behavior
  // when the queue is empty:
  // the remove() method throws an exception,
  // while the poll() method returns null.
  
  public int maxDepth_BFS(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    int depth = 0;
    // start the queue
    // 3
    queue.add(root);
    
    
    //while (queue.size() != 0){
    while (queue.size() > 0){
      for (int i=0; i<queue.size(); i++){
        // remove the first
        TreeNode curr = queue.poll();
        // add children
        // 9 20
        if (curr.left != null) queue.add(curr.left);
        if (curr.right!= null) queue.add(curr.right);
      }
      depth += 1;
      // and keep on doing this for all nodes
      
    }
    
    return depth;
  }
  
  // DFS solution stack elements should hold level info
  public int maxDepth_DFS(TreeNode root) {
    if (root == null) return 0;
    Stack<nodeDetail> stack = new Stack<>();
    int result = 0;
    stack.push(new nodeDetail(root,0));
    while (stack.size() > 0){
      nodeDetail curr = stack.pop();
      if (curr.node.left != null) stack.push(new nodeDetail(curr.node.left, curr.depth + 1));
      if (curr.node.right!= null) stack.push(new nodeDetail(curr.node.right, curr.depth + 1));
      result = Math.max(result, curr.depth + 1);
    }
    return result;
  }
  
  class nodeDetail {
    public TreeNode node;
    public int depth;
    public nodeDetail(TreeNode node, int depth){
      this.node = node;
      this.depth = depth;
    }
  }
  
}