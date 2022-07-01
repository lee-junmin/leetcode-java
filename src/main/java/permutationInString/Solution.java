package permutationInString;

// TC O(n) where n is the total number of characters in s2
// SC O(1) because the size of the array for s1 and s2 map is fixed


class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        //Arrays.fill(s1Map,0);
        //Arrays.fill(s2Map,0);

        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) return false;

        // make a s1 map
        for(int i=0; i<s1Len; i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = left + s1Len - 1;
        int matchCount = 0;

        // set initial matchCount
        for (int i=0; i<26; i++){
            if (s1Map[i] == s2Map[i]){
                matchCount++;
            }
        }

        if (matchCount == 26) return true;

        while (right < s2Len - 1){


            int leftIndex = s2.charAt(left) - 'a';
            if (s1Map[leftIndex] == s2Map[leftIndex]) matchCount--;
            s2Map[leftIndex]--;
            if (s1Map[leftIndex] == s2Map[leftIndex]) matchCount++;

            left++;
            right++;
            int rightIndex = s2.charAt(right) - 'a';
            if (s1Map[rightIndex] == s2Map[rightIndex]) matchCount--;
            s2Map[rightIndex]++;
            if (s1Map[rightIndex] == s2Map[rightIndex]) matchCount++;

            if (matchCount == 26) return true;

        }

        return false;
    }
}
