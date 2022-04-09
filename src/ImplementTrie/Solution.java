package ImplementTrie;

/*

SUMMARY
the three components of TrieNode. find index of the TrieNode array with (character - 'a')


MAIN IDEA
The TrieNode should have three attributes
1) the character
2) the TrieNode array that holds children TrieNodes
3) isEnd boolean

insert: curr at root. loop for each character and add if null then update the curr node. the end line should set isEnd
search, startsWith: same as insert

REVIEW
m: the length of the given word
insert search will be O(m)


 */

class Trie {
  
  static final int ALPHABET_SIZE = 26;
  TrieNode root;
  
  public Trie() {
    root = new TrieNode('#'); //dummy character for the root
  }
  
  private class TrieNode {
    char character;
    TrieNode[] adj;
    boolean isEnd;
    public TrieNode(char character){
      this.character = character;
      this.adj = new TrieNode[ALPHABET_SIZE];
      this.isEnd = false;
    }
  }
  
  public void insert(String word) {
    
    TrieNode curr = root;
    
    for (int i = 0; i < word.length(); i++) {
      char charToAdd = word.charAt(i);
      int index = charToAdd - 'a';
      if(curr.adj[index] == null) {
        curr.adj[index] = new TrieNode(charToAdd);
      }
      curr = curr.adj[index];
    }
    curr.isEnd = true;
  }
  
  public boolean search(String word) {
    TrieNode curr = root;
    
    for (int i=0; i < word.length(); i++) {
      char charToSearch = word.charAt(i);
      int index = charToSearch - 'a';
      if (curr.adj[index] == null) {
        return false;
      }
      curr = curr.adj[index];
    }
    
    return curr.isEnd;
    
  }
  
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    
    for (int i=0; i < prefix.length(); i++) {
      char charToSearch = prefix.charAt(i);
      int index = charToSearch - 'a';
      if (curr.adj[index] == null) {
        return false;
      }
      curr = curr.adj[index];
    }
    
    return true;
    
  }
}
