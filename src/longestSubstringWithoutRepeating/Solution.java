package longestSubstringWithoutRepeating;

import java.util.*;
// T O(n) S O(n) using a hashset


class Solution {
  
  public int lengthOfLongestSubstring(String s) {
    
    Set<Character> charPool = new HashSet<>();
    int len = s.length();
    if (len < 2) return len;
    
    int maxSoFar = 0;
    
    int l = 0;
    charPool.add(s.charAt(0));
    
    
    for (int r = 1; r < len; r++){
      
      while (charPool.contains(s.charAt(r))){
        charPool.remove(s.charAt(l));
        l++;
      }
      charPool.add(s.charAt(r));
      maxSoFar = Math.max(maxSoFar, r - l + 1);
    }
    return maxSoFar;
  }
  
  
  public int lengthOfLongestSubstring_2(String s) {
    if (s.length() < 2) return s.length();
    Map<Character, Integer> count = new HashMap<>();
    int maxSoFar = 0; // to be returned
    
    int l = 0; // init left pointer
    count.put(s.charAt(0),1); // add to map
    
    for (int r = 1; r < s.length(); r++){
      char rightChar = s.charAt(r);
      char leftChar = s.charAt(l);
      
      if (!count.containsKey(rightChar)){
        count.put(rightChar,0);
      }
      count.put(rightChar, count.get(rightChar) + 1);
      
      boolean isValid = Collections.max(count.values()) < 2;
      
      if (!isValid) {
        count.put(leftChar, count.get(leftChar) - 1);
        l++;
      }
      
      maxSoFar = Math.max(maxSoFar, r - l + 1);
      
    }
    
    return maxSoFar;
    
  }
}
