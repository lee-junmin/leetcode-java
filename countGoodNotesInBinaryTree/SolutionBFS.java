package countGoodNotesInBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
// TC O(N) where n is the number of nodes
// SC O(N) where n is the number of nodes. this is the worst case where the tree is full
// and the queue will need to hold half the tree.
class SolutionBFS {
    public int goodNodes(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, Integer.MIN_VALUE));
        int result = 0;

        while(!que.isEmpty()){
            Pair curr = que.poll();
            if (curr.node.val >= curr.max) result++;
            if (curr.node.left != null) que.offer(new Pair(curr.node.left, Math.max(curr.max, curr.node.val)));
            if (curr.node.right!= null) que.offer(new Pair(curr.node.right, Math.max(curr.max, curr.node.val)));
        }
        return result;
    }

}