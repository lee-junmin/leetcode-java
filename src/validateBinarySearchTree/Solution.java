package validateBinarySearchTree;
// T O(n) S O(1), if implicit systems stacks considered O(n)
class Solution {
  public boolean isValidBST(TreeNode root) {
    return val(root, Long.MIN_VALUE, Long.MAX_VALUE);
    
  }
  
  public boolean val(TreeNode root, long lower, long upper){
    
    if (root == null) return true;
    
    if (root.val >= upper || root.val <= lower) return false;
    
    boolean isLeftValid = val(root.left, lower, root.val);
    boolean isRightValid = val(root.right, root.val, upper);
    
    return isLeftValid && isRightValid;
    
  }
  
  public boolean isValidBST_stk(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
    }
    return true;
  }
}