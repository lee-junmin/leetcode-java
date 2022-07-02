package plusOne;

import java.util.Arrays;
// TC O(n)
// SC O(n) but if we count the worst case array as an output
// space complexity will be O(1)


class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int indexToIncrement = len - 1;

        while (digits[indexToIncrement] == 9){
            digits[indexToIncrement] = 0;
            indexToIncrement--;
            if (indexToIncrement < 0){
                int[] newDigits = new int[len+1];
                Arrays.fill(newDigits,0);
                newDigits[0] = 1;
                return newDigits;
            }

        }

        digits[indexToIncrement]++;
        return digits;

    }
}