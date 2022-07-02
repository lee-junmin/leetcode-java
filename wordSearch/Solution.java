package wordSearch;

// n: row of the board, m: col of the board, l: length of the word

// Time complexity O(n * m * 4^l) , Space Complexity O(1)


class Solution {
  
  public boolean exist(char[][] board, String word) {
    for (int i=0; i<board.length; i++){
      for (int j=0; j<board[0].length; j++){
        if (existAt(board,word,i,j,0)){
          return true;
        }
      }
    }
    
    return false;
    
  }
  
  private boolean existAt(char[][] board, String word, int row, int col, int index){
    
    
    
    if (index >= word.length()) return true;
    // bound
    if (row < 0 || col < 0 || row >= board.length|| col >= board[0].length) return false;
    // revisit
    char charToSearch = board[row][col];
    if (charToSearch == '#') return false;
    // no match
    if (charToSearch != word.charAt(index)) return false;
    
    
    
    board[row][col] = '#';
    boolean result = existAt(board, word, row+1, col, index+1) ||
      existAt(board, word, row-1, col, index+1) ||
      existAt(board, word, row, col+1, index+1) ||
      existAt(board, word, row, col-1, index+1);
    board[row][col] = charToSearch;
    
    return result;
    
  }
}