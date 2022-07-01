package pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// T O(m*n) S O(m*n) where m is row number, n is col numbers
class Solution {
  
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    
    int ROW = heights.length;
    int COL = heights[0].length;
    
    boolean[][] pacificMatrix = new boolean[ROW][COL];
    boolean[][] atlanticMatrix = new boolean[ROW][COL];
    
    for (int i=0; i<COL; i++){// upper bottom
      dfs(0, i, 0, pacificMatrix, heights);
      dfs(ROW-1, i, 0, atlanticMatrix, heights);
    }
    
    for (int i=0; i<ROW; i++){// left right edge of matrix
      dfs(i, 0, 0, pacificMatrix, heights);
      dfs(i, COL-1, 0, atlanticMatrix, heights);
    }
    
    List<List<Integer>> res = new ArrayList<>();
    
    for (int i=0; i<ROW; i++){
      for (int j=0; j<COL; j++){
        if (pacificMatrix[i][j] && atlanticMatrix[i][j]){
          res.add(new ArrayList<Integer>(Arrays.asList(i,j)));
        }
      }
    }
    
    return res;
    
  }
  
  //dfs method
  private void dfs(int row, int col, int prevHeight, boolean[][] recordMatrix, int[][] heights){
    // return cases - bound / prevHeight is lower / already has it
    if (row < 0 || col < 0 || row > heights.length-1 || col > heights[0].length-1 ||
      prevHeight > heights[row][col]  ||
      recordMatrix[row][col]
    ){
      return;
    }
    
    // update record matrix
    recordMatrix[row][col] = true;
    
    // recursive calls on 4 directions
    dfs(row+1, col, heights[row][col], recordMatrix, heights);//up
    dfs(row-1, col, heights[row][col], recordMatrix, heights);//down
    dfs(row, col-1, heights[row][col], recordMatrix, heights);//right
    dfs(row, col+1, heights[row][col], recordMatrix, heights);//left
  }
}