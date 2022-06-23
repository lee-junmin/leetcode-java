package reverseInteger;

class Solution {
    public int reverse(int x) {

        boolean isNegative = false;
        int result =  0;

        if (x < 0){
            isNegative = true;
            x *= -1;
        }

        while (x > 0){
            if (result > (int)Math.pow(2,31) / 10) return 0;
            result *= 10;
            result += x % 10;
            x /= 10;
        }

        if (isNegative){
            result *=  -1;
        }

        return result;
    }
}