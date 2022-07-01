package distinctSubsequence;
// TC O(mxn) where m,n is the length of s,t
// SC O(mxn)

// This code gives a time limit exceeded message
// if you use Pair<> from javafx instead of a custom class, you can avoid time limite exceed

import java.util.HashMap;

class SolutionRec {

    private HashMap<Pair,Integer> memo;
    String main;
    String sub;

    public int numDistinct(String s, String t) {
        memo = new HashMap<>();
        main = s;
        sub = t;

        return numDistinctOf(0,0);
    }

    private int numDistinctOf(int m, int s){
        // base case
        int mLen = main.length();
        int sLen = sub.length();

        if (mLen - m < sLen - s || mLen == m || sLen == s){
            if ( s == sLen) return 1;
            else return 0;
        }

        // memo
        Pair key = new Pair(m, s);
        if (memo.containsKey(key)) return memo.get(key);

        // recursion
        int result = numDistinctOf(m + 1, s);
        if (main.charAt(m) == sub.charAt(s)){
            result += numDistinctOf(m + 1, s + 1);
        }

        memo.put(key,result);
        return result;
    }
}