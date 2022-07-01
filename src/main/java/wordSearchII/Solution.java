package wordSearchII;

import java.util.ArrayList;
import java.util.List;

// TC where m is the number of cells
// TC is around O(m * 4^m) this is the worst case where a word can cover up the whole board
// to be more exact with the TC it should be O(m * 4 * 3^(l-1) where l is the length of the longest word
// SC O(n) where n is the total number of characters in the word list
// the recursion stack will go up to the length of the longest word, which will always be less than m

class TrieNode{

    static final int ALPHABET_SIZE = 26;
    char c;
    TrieNode[] adj;
    String endOfWord = null;

    public TrieNode(char c){
        this.c = c;
        this.adj = new TrieNode[ALPHABET_SIZE];
        this.endOfWord = null;
    }

    public void add(String word){
        TrieNode currNode = this;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int cIndex = c - 'a';
            if (currNode.adj[cIndex] == null){
                currNode.adj[cIndex] = new TrieNode(c);
            }
            currNode = currNode.adj[cIndex];
        }
        currNode.endOfWord = word;
    }
}

class Solution {

    char[][] board;
    List<String> results;

    public List<String> findWords(char[][] board, String[] words) {

        this.board = board;
        this.results = new ArrayList<>();

        TrieNode root = new TrieNode('*');

        // add words to trie
        int ROWS = board.length, COLS = board[0].length;
        for (String word: words){
            root.add(word);
        }

        // dfs + backtracking recurse
        for (int r=0; r<ROWS; r++){ // TC O(mn x 4^mn)
            for (int c=0; c<COLS; c++){
                if (root.adj[board[r][c] - 'a'] != null) dfs(r, c, root);
            }
        }
        return results;
    }

    private void dfs(int r, int c, TrieNode node){

        char bChar = board[r][c];
        if (bChar == '#') return;
        TrieNode child = node.adj[bChar - 'a'];
        if (child == null) return;
        // before exploration
        if (child.endOfWord != null){
            results.add(child.endOfWord);
            child.endOfWord = null; // don't want duplicates. don't return because you might have other words down along the branch
        }

        this.board[r][c] = '#';

        // exploration
        int ROWS = board.length, COLS = board[0].length;
        if (r < ROWS - 1) dfs(r+1,c, child);
        if (r > 0) dfs(r-1,c, child);
        if (c < COLS - 1) dfs(r,c+1, child);
        if (c > 0) dfs(r,c-1, child);

        // after exploration
        board[r][c] = bChar;

        // optimization: cut off leaves
        for (int i=0; i<child.adj.length; i++){
            if (child.adj[i] != null) return;
        }
        node.adj[bChar-'a'] = null;
    }

}