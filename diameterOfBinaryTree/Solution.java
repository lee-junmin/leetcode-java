/*

SUMMARY
recursive answers are the bestDiameterSoFar and height. construct these values from the bestDiameter and height information coming from the left and right child.


MAIN IDEA
Typical recursion for trees
for each node the recursive method should return

1) bestDiameter
2) height

the current node will ask its left and right children
their bestDiameter and height to calculate these two values.

best diameter can be made by max( larger bestDiameter of left & right, left height + right height)
height can be made by adding 1 to the max height of the left and right subtree

the base case is when current node is null and returns both 0 for the two.
the recursive answer will be passed in as an object

REVIEW

n: number of nodes, and h: height of the tree
Time Complexity - O(n)
Space Complexity - O(h)

Other Approaches
	- using a global variable can make thigs simple. in our solution we tried to package information and pass it on to the next recursive function so that we can avoid this
	- The brute force approach where we try to find the max diameter for each node will be O(n^2) where our solution will be O(n) with


 */



package diameterOfBinaryTree;

  
  class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
      Status result = getStatus(root);
      return result.bestDiameter;
    }
    
    private Status getStatus(TreeNode root){
      
      //base case
      if (root == null){
        return new Status(0,0);
      }
      
      Status leftStatus = getStatus(root.left);
      Status rightStatus = getStatus(root.right);
      
      int largerBestDiameter = Math.max(leftStatus.bestDiameter, rightStatus.bestDiameter);
      int currentBestDiameter = Math.max(largerBestDiameter, leftStatus.height + rightStatus.height);
      
      int largerHeight = Math.max(leftStatus.height, rightStatus.height);
      int currentHeight = largerHeight +1;
      
      return new Status(currentBestDiameter, currentHeight);
    }
    
    private class Status{
      int bestDiameter;
      int height;
      public Status(int bestDiameter, int height){
        this.bestDiameter = bestDiameter;
        this.height = height;
        
      }
    }
  }
  
