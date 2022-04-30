package designAddAndSearchWords;

import java.util.HashMap;

public class WordDictionary {
  
  
  static final int SIZE = 26;
  TrieNode root;
  
  class TrieNode {
    char c;
    HashMap<Character,TrieNode> children;
    boolean isEnd;
    
    public TrieNode(){
      children = new HashMap<>();
      isEnd = false;
    }
  }
  
  public WordDictionary() {
    root = new TrieNode(); // dummy character
  }
  
  public void addWord(String word) {
    TrieNode currNode = root;
    for (int i=0; i<word.length(); i++){
      char charToAdd = word.charAt(i);
      if(!currNode.children.containsKey(charToAdd)){
        currNode.children.put(charToAdd, new TrieNode());
      }
      currNode = currNode.children.get(charToAdd);
    }
    
    currNode.isEnd = true;
  }
  
  public boolean search(String word){
    return genSearch(word, root);
  }
  
  
  
  private boolean genSearch(String word, TrieNode root) {
    
    TrieNode currNode = root;
    
    for (int i=0; i<word.length(); i++){
      char charToSearch = word.charAt(i);
      
      if (currNode.children.containsKey(charToSearch)){// match, move on
        currNode = currNode.children.get(charToSearch);
        
      } else { // not a match
        if (charToSearch == '.'){
          // call this method on each key of the map
          for(char c: currNode.children.keySet()){
            boolean isChildrenValid = genSearch(word.substring(i+1), currNode.children.get(c));
            if (isChildrenValid) return true;
          }
        }   // not a match and not a '.'
        
        return false;
        
      }
      
    }
    
    return currNode.isEnd;
    
  }
  
}
