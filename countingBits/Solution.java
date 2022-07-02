package countingBits;

// TC O(n)


public class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for (int i=1; i<=n; i++){
            res[i] = res[i & (i-1)] + 1;
        }


        return res;

    }

    public int[] countBits2(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        int offset = 1;
        int index = 1;

        while (offset <= n){
            while (index < offset << 1 && index <= n){
                res[index] = 1 + res[index - offset];
                index++;
            }

            offset <<= 1;
        }

        return res;

    }



    /*

    NAIVE APPROACH
   class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0; i<=n; i++){
            res[i] = count(i);
        }
    }

    private int count(int num){
        int res = 0;
        while (num != 0){
            num &= (num - 1);
            res++;
        }
        return res;
    }
}

    **/

}
