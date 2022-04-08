package balancedBinaryTree;
/*
SUMMARY
when recurse up with left and right, pass on the isBalaced and height of each. return an object with a nested class.

MAIN IDEA
As we recurse up the tree we will pass the parent two pieces of information
isBalanced and the height of each left and right subtree.
the parent will then pass that on to the higher node.

In this code, to pass those two things that have a different type,
we will pass them through as an object

The parent will get the larger height and add 1 to it for it's height
and if either of the children are not balanced it will pass false for isBalanced.


REVIEW
n is the number of nodes in the tree
h is the height of the tree
TC O(n)
SC O(h) - stack max standard recursion

OTHER APPROACHES
the naive solution by finding the height for each node
but TC will be O(n^2)

* leetcode shows faster when the recursive is only giving the height
and recurses again in
 */

public class Solution {
  public boolean isBalanced(TreeNode root){
    return checkBalancedAndHeight(root).isBalanced;
  }
 
  private Status checkBalancedAndHeight(TreeNode root){
    //base case
    if (root == null) return new Status(true,-1);
    
    
    // get information from children
    Status leftStatus = checkBalancedAndHeight(root.left);
    if (!leftStatus.isBalanced) return leftStatus;// return right away
    Status rightStatus = checkBalancedAndHeight(root.right);
    if (!rightStatus.isBalanced) return rightStatus;
    
    boolean isBalanced = Math.abs(leftStatus.height - rightStatus.height) <= 1;
    int height = Math.max(leftStatus.height, rightStatus.height) + 1;
    
    return new Status(isBalanced,height);
  
  }
  
  private class Status {
    public boolean isBalanced;
    public int height;
    public Status(boolean isBalanced, int height){
      this.isBalanced = isBalanced;
      this.height = height;
    }
  }
  
  
  
  
  //driver
  
  public static void main(String[] args){
    TreeNode n = new TreeNode(3);
    n.left = new TreeNode(9);
    n.right = new TreeNode(20);
    n.right.left = new TreeNode(15);
    n.right.right = new TreeNode(7);
    
    Solution b = new Solution();
    System.out.println(b.isBalanced(n));
    
  }
}

