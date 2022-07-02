package multiplyString;
// TC O(m x n)
class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";
        int L1 = num1.length();
        int L2 = num2.length();

        int[] arr1 = new int[L1];
        int[] arr2 = new int[L2];
        int[] result = new int[L1 + L2];

        //construct arrays TC & SC O(m+n)
        for (int i=0; i<L1; i++){
            arr1[i] = num1.charAt(L1 - 1 - i) - '0';
        }

        for (int i=0; i<L2; i++){
            arr2[i] = num2.charAt(L2 - 1 - i) - '0';
        }

        // get result array TC O(m x n)
        int offset = 0;
        for (int n2=0; n2<L2; n2++){
            for (int n1=0; n1<L1; n1++){
                int mult = arr1[n1] * arr2[n2];
                result[offset + n1] += mult;
            }
            offset++;
        }

        // calculate carries TC O(m + n)
        for (int i=0; i<result.length-1; i++){
            int val = result[i];
            result[i] = val % 10;
            result[i+1] += val / 10;
        }

        // reverse string TC O(m + n)
        StringBuilder sb = new StringBuilder();
        for(int r: result){
            sb.insert(0,r);
        }

        // remove leading zeros TC O(m+n)
        String resultString = sb.toString();
        while (resultString.charAt(0) == '0'){
            resultString = resultString.substring(1);
        }
        return resultString;

    }
}