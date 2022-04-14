package subtreeOfAnotherTree;
/*

"""
https://leetcode.com/problems/subtree-of-another-tree/

IDEA
use recursion. recursion is the first thing to think about when dealing with trees
check whether subRoot is the same with the left and right of each node of the root

isSubtree base cases
1) null is a subtree of null
2) null is a subtree of not null
   so, if subtree is null --> return True
3) not null is a subtree of null
   so, if root is null --> return False (after the previous if statement)
4) if root and subtree are the same --> return True

need a helper function - sameTree
sameTree based cases
1) both null. null is same as null --> True
2) only one is null --> False
3) both not null and value is different --> False

Then, we do the recursion.
compare the left and right of the root with the subRoot
if either one of them are True, return True

isSubtree will call sameTree which is recursive
time complexity will be O(s*t)

* */

public class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    // base case
    if (root == null && subRoot == null) return true;
    if (root == null ^ subRoot == null) return false;
    if (isSameTree(root, subRoot)) return true;
    
    boolean left = isSubtree(root.left, subRoot);
    boolean right= isSubtree(root.right, subRoot);
    
    return left || right;
    
  }
  
  private boolean isSameTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null ^ t2 == null) return false;
    if (t1.val != t2.val) return false;
    
    boolean left = isSameTree(t1.left, t2.left);
    boolean right = isSameTree(t1.right, t2.right);
    
    return left && right;
    
  }
}
