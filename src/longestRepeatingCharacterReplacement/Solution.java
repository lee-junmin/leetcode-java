package longestRepeatingCharacterReplacement;

import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static int characterReplacement(String s, int k) {
        char[] input = s.toCharArray();
        HashMap<Character, Integer> occ = new HashMap<>();

        int maxSoFar = 0; // r-1+1 where isValid
        int l = 0;
        int r = 1;
        occ.put(input[0],1);
        while (r < input.length) {

            // isValid: length - max occuring char <= k
            int maxCharCount = 0;
            if (!occ.isEmpty()) maxCharCount = Collections.max(occ.values());
            boolean isValid = (r - l + 1) - maxCharCount <= k;


            if (isValid) {
                r++;
                occ.put(input[r], occ.getOrDefault(input[r], 0) + 1);
                maxSoFar = Math.max(maxSoFar, r - l + 1);



            } else {

                occ.put(input[l], occ.get(input[l])-1);
                l++;
            }
        }
        return maxSoFar;

    }

    public static void main (String[] args){
        System.out.println(characterReplacement("ZZCCXXCCCCCC",2));
    }
}

