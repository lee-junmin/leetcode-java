package ValidParentheses;
/*
IDEA
  Use a stack to store the opening brackets
  Pop where the matching closing brackets appear in the string
  Return true when the final stack is empty
  
  COMPLEXITY
  Time: O(n) - we need to loop through the string once
  Space: O(n) - worst case we would need to store the whole string in a stack
*/


import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    
    
    // create stack store opeings
    Stack<Character> openingsStack = new Stack<>();
    
    for (char curr: s.toCharArray()) {
      
      if (!isClosing(curr)){
        openingsStack.push(curr);
        
      } else {
        // pop and see if matching
        if (openingsStack.isEmpty() || openingsStack.pop() != getMatching(curr)) {
          return false;
        }
      }
      
    }
    return openingsStack.isEmpty();
    
  }
  
  private boolean isClosing(char c){
    if (c == ')' || c == '}' || c == ']') {
      return true;
    } else {
      return false;
    }
  }
  
  private char getMatching(char c){
    if (c == ')') return '(';
    if (c == '}') return '{';
    if (c == ']') return '[';
    
    return ' ';
  }
}