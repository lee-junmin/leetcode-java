package decodeWays;

class Solution {
    public int numDecodings(String s) {

        int len = s.length();
        int oneBack = 1;
        int twoBack = 1;


        if (s.charAt(0)  == '0') {
            return 0;
        }

        for (int i=1; i<len; i++){
            int curr = 0;

            int doubleDigit = Integer.parseInt(s.substring(i-1,i+1));
            if (doubleDigit == 0) return 0;

            if (s.charAt(i) == '0'){
                if (doubleDigit > 26) return 0;
                curr = twoBack;
            } else if (s.charAt(i-1) == '0'){
                curr = oneBack;
            } else if (doubleDigit > 26){
                curr = oneBack;
            } else {
                curr = oneBack + twoBack;
            }
            twoBack = oneBack;
            oneBack = curr;

        }
        return oneBack;





    }
}



