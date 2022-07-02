package nQueenII;

import java.util.HashSet;
// TC O(n!) where n is the number of queens
// SC O(n) the sets and recursion calls all increase linear with the number of queens
class Solution {

    int n;
    HashSet<Integer> attCol = new HashSet<>();
    HashSet<Integer> attPosDia = new HashSet<>();
    HashSet<Integer> attNegDia = new HashSet<>();

    public int totalNQueens(int n) {
        this.n = n;
        return backtrack(0);
    }

    private int backtrack(int r){
        int count = 0;
        if (r == n) return 1;

        // match -> backtrack
        for(int c=0; c<n; c++){

            if (attCol.contains(c) || attPosDia.contains(c + r) || attNegDia.contains(c - r)) continue;

            attCol.add(c);
            attPosDia.add(c + r);
            attNegDia.add(c - r);

            count += backtrack(r+1);

            attCol.remove(c);
            attPosDia.remove(c + r);
            attNegDia.remove(c - r);
        }

        return count;
    }
}