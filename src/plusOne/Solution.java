package plusOne;



class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if  (digits[len-1] != 9){
            digits[len-1]++;
            return digits;
        } else {
            // 1200
            int i = len - 1;
            while (digits[i] == 9){
                digits[i] = 0;
                // 0000
                if (i == 0){
                    return generateArray(len+1);
                }
                i--;
            }
            digits[i]++;
        }

        return digits;
    }

    private int[] generateArray(int n){
        int[] res = new int[n];
        res[0] = 1;
        for (int i=1; i<n; i++){
            res[i] = 0;
        }
        return res;
    }

}


