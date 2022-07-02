package numberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

// m rows n cols - Time complexity O(m * n) Space Complexity O(m*n)
//
class Solution {
    public int numIslands(char[][] grid) {

        int result = 0;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == '1'){
                    result += 1;
                    DFS(i,j,grid); // change adj 1s to 0s
                }
            }
        }
        return result;
    }

    private void DFS(int row, int col, char[][] grid){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) return;// boundary
        if (grid[row][col] != '1') return; // not 1

        grid[row][col] = '0';

        DFS(row-1, col, grid); // up
        DFS(row+1, col, grid); // down
        DFS(row, col-1, grid); // left
        DFS(row, col+1, grid); // right
    }


  //=============== bfs iterative solution
    // m rows n cols - Time complexity O(m * n) Space Complexity O(min(m*n))


    class Location {
            int row;
            int col;
            public Location(int row, int col){
                this.row = row;
                this.col = col;
            }
        }

        public int numIslands_bfs(char[][] grid) {
            int result = 0;
            for (int i=0; i<grid.length; i++){
                for (int j=0; j<grid[i].length; j++){
                    if (grid[i][j] == '1'){
                        result += 1;
                        bfs(grid, i, j); // turn island to 0
                    }
                }
            }
            return result;
        }



        private void bfs(char[][] grid, int row, int col){
            Queue<Location> queue = new LinkedList<>();
            queue.offer(new Location(row,col));

            while(!queue.isEmpty()){
                Location curr = queue.poll();
                int cRow = curr.row;
                int cCol = curr.col;
                grid[cRow][cCol] = '0';

                if (cRow > 0 && grid[cRow-1][cCol] == '1'){// up
                    queue.offer(new Location(cRow-1, cCol));
                    grid[cRow-1][cCol] = '0';
                }
                if (cRow < grid.length-1 && grid[cRow+1][cCol] == '1'){// down
                    queue.offer(new Location(cRow+1, cCol));
                    grid[cRow+1][cCol] = '0';
                }
                if (cCol> 0 && grid[cRow][cCol-1] == '1'){// left
                    queue.offer(new Location(curr.row, cCol-1));
                    grid[cRow][cCol-1] = '0';
                }
                if (cCol < grid[cRow].length-1 && grid[cRow][cCol+1] == '1'){// right
                    queue.offer(new Location(cRow, cCol+1));
                    grid[cRow][cCol+1] = '0';
                }
            }
        }
    }












