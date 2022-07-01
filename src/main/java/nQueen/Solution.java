package nQueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// TC O(n!) where n is the number of queens
// SC O(n) the sets and recursion calls all increase linear with the number of queens
class Solution {

    int n;
    HashSet<Integer> attCol = new HashSet<>();
    HashSet<Integer> attPosDia = new HashSet<>();
    HashSet<Integer> attNegDia = new HashSet<>();
    List<List<String>> result = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] emptyBoard = new char[n][n];
        for (int r=0; r<n; r++){
            for (int c=0; c<n; c++){
                emptyBoard[r][c] = '.';
            }
        }
        backtrack(0, emptyBoard);
        return result;
    }

    private void backtrack(int row, char[][] boardSolution){

        if (row == n){
            //TODO boardSolution add to result
            List<String> rowStrings = new ArrayList<>();
            for (int r=0; r<n; r++){
                String rowString = "";
                for (int c=0; c<n; c++){
                    rowString += boardSolution[r][c];
                }
                rowStrings.add(rowString);
            }
            result.add(rowStrings);
        }

        for (int col=0; col<n; col++){
            if (attCol.contains(col) || attPosDia.contains(col+row) || attNegDia.contains(col-row)){
                continue;
            }

            attCol.add(col);
            attPosDia.add(col+row);
            attNegDia.add(col-row);
            boardSolution[row][col] = 'Q';

            backtrack(row+1, boardSolution);

            attCol.remove(col);
            attPosDia.remove(col+row);
            attNegDia.remove(col-row);
            boardSolution[row][col] = '.';
        }
    }
}
