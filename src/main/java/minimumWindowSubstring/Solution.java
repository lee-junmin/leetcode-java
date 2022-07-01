package minimumWindowSubstring;



//TC O(S + T) where S is the s length T is t length
//SC O(T) where T is the length of T

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        int[] result = {-1,-1};
        int minSoFar = Integer.MAX_VALUE;

        for (int i=0; i<tLen; i++){
            char curr = t.charAt(i);
            tMap.put(curr, tMap.getOrDefault(curr,0) + 1);
        }

        for (char c: tMap.keySet()){
            windowMap.put(c,0);
        }

        int left = 0;
        int right = 0;

        int need = tMap.size();
        int have = 0;

        while (right < sLen){

            char rightChar = s.charAt(right);

            if (tMap.containsKey(rightChar)){
                windowMap.put(rightChar, windowMap.get(rightChar) + 1);
                // Integer and int comparison: need to use (int) 
                if ((int)windowMap.get(rightChar) == (int)tMap.get(rightChar)){
                    have++;
                }
            }

            while (need == have){

                if (right - left < minSoFar){
                    minSoFar = right - left;
                    result[0] = left;
                    result[1] = right;
                }

                char leftChar = s.charAt(left);

                if (tMap.containsKey(leftChar)){
                    if((int)windowMap.get(leftChar) == (int)tMap.get(leftChar)) have--;
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }

                left++;
            }

            right++;
        }



        return result[0] == -1 ? "" : s.substring(result[0], result[1] + 1);

    }
}
