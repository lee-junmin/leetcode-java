package implementStr;

// TC O(m*n) where m,n are the length of haystack, needle
// SC O(1) as we are checking in-place

class NaiveSolution {
    public int strStr(String haystack, String needle) {

        int needleLen = needle.length();
        int haystackLen = haystack.length();

        if (needleLen == 0) return 0;

        for(int i=0; i<haystackLen; i++){
            for (int j=0; j<needleLen && i + j < haystackLen; j++){
                if(needle.charAt(j) != haystack.charAt(i + j)){
                    break;
                } else if (j == needleLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
