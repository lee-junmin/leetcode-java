package validAnagram;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        int sLen  = s.length();
        int tLen  = t.length();

        if (sLen != tLen) return false;

        for (int i=0; i<sLen; i++){

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            sMap.put(sChar, sMap.getOrDefault(sChar,0) +1);
            tMap.put(tChar, tMap.getOrDefault(tChar,0) +1);

        }

        return sMap.equals(tMap);
    }
}
