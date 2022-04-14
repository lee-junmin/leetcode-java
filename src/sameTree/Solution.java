package sameTree;
/*

"""

IDEA

we will use recursion
think that we are comparing the subtree under p's left node and q's left node
and p's right node and q's right node

base case need to cover the three cases below:
1) both p and q are null --> return True
2) only one of them are null --> return False (because they are different)
3) both of them are not null but have different values --> return True

the final return should be the bool value of when both left and right subtree
return of isSameTree is True

REVIEW
recursion should be O(n) specifically O(p+q`)
and O(N) in a worst case completly unbalanced
* */

public class Solution {
  private boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null ^ q == null) return false;
    if (p.val != q.val) return false;
    
    boolean left = isSameTree(p.left, q.left);
    boolean right = isSameTree(p.right, q.right);
    
    return left && right;
    
  }
}
