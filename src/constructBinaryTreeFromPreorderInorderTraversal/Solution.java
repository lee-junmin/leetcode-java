package constructBinaryTreeFromPreorderInorderTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// T O(n) - building the hashmap will cost O(n) useful because we do it outside the recursion
// S O(n) - hashmap O(n). the recursion will be worst case O(n) for implicit system stacks
class Solution {
  
  Map<Integer, Integer> indexMap;
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    indexMap = new HashMap<>();
    for (int i=0; i<inorder.length; i++){
      indexMap.put(inorder[i],i);
    }
    return gen(preorder, inorder);
  }
  
  private TreeNode gen(int[] preorder, int[] inorder) {
    
    if (preorder.length == 0 || inorder.length == 0) return null;
    
    TreeNode root = new TreeNode(preorder[0]);
    
    int i = indexMap.get(preorder[0]);
    
    
    root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),
      Arrays.copyOfRange(inorder,0,i));
    root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),
      Arrays.copyOfRange(inorder,i+1,inorder.length));
    return root;
    
  }
}