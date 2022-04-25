package longestRepeatingCharacterReplacement;


import java.util.HashMap;
import java.util.Map;
// T O(n) S O(n)
// you can also use an array instead of a map, that will be faster (but time complexity the same)
// and make the space complexity constant


class Solution {
  public int characterReplacement(String s, int k) {
    
    Map<Character,Integer> count = new HashMap<>();
    
    int l = 0;
    int maxSoFar = 0; // to be returned
    int currMaxRepeat = 0; // check isValid
    
    for (int r=0; r < s.length(); r++){
      char rightChar = s.charAt(r);
      
      //update map
      if (!count.containsKey(rightChar)){
        count.put(rightChar,0);
      }
      count.put(rightChar, count.get(rightChar) + 1);
      
      // check isValid
      int currLen = r - l + 1;
      //currMaxRepeat = Collections.max(count.values()); // can be optimized
      // currMaxRepeat is not the accurate number of dominant character, It is the historical maximum count
      // We do not care about it because unless it gets greater, it won't affect our final max window size.
      currMaxRepeat = Math.max(currMaxRepeat, count.get(rightChar));
      boolean isValid = currLen - currMaxRepeat <= k;
      
      if (!isValid){
        // increment l and decrease map value
        char leftChar = s.charAt(l);
        count.put(leftChar, count.get(leftChar) - 1);
        l++;
      }
      maxSoFar = Math.max(maxSoFar, r - l + 1);
    }
    return maxSoFar;
  }
}
