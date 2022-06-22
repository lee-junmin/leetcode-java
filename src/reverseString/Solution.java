package reverseString;

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int headIndex=0; headIndex<len/2; headIndex++){
            int tailIndex= len - 1 - headIndex;
            char temp = s[headIndex];
            s[headIndex] = s[tailIndex];
            s[tailIndex] = temp;
        }
    }
}
