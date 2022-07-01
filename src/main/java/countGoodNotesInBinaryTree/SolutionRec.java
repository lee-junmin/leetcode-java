package countGoodNotesInBinaryTree;
// TC O(N) where n is the number of nodes in the tree
// SC O(N) it will be the height, but worst case the number of nodes can be the hight.

class SolutionRec {

    int result;

    public int goodNodes(TreeNode root) {
        result = 0;
        dfs(root, Integer.MIN_VALUE);
        return result;
    }

    private void dfs(TreeNode root, int max){
        if (root.val >= max) result++;
        if (root.left != null)  dfs(root.left, Math.max(max, root.val));
        if (root.right != null) dfs(root.right, Math.max(max, root.val));
    }
}
