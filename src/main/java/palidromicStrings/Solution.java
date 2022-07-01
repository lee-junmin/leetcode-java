package palidromicStrings;

//TC O(n^2) where n is the length of String s
// SC O(1)

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        for (int i=0; i<len; i++){
            count += countPal(s,i,i);
            count += countPal(s,i,i+1);
        }
        return count;
    }


    private int countPal(String s, int left, int right){
        int count = 0;
        int len = s.length();
        while (left >=0 && right <len){
            if (s.charAt(left) != s.charAt(right)){
                break;
            } else {
                count++;
            }

            left--;
            right++;
        }

        return count;
    }
}