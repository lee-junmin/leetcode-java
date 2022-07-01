package addBinary;

class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        String s1 = "";
        String s2 = "";
        if (aLen > bLen) {
            s1 = a;
            s2 = b;
        } else {
            s1=b;
            s2=a;
        }
        int offset = s1.length() - s2.length();
        StringBuilder fill = new StringBuilder(s2);
        for (int i=0; i<offset; i++){
            fill.insert(0,"0");
        }
        s2 = fill.toString();


        boolean carry = false;
        StringBuilder res = new StringBuilder();

        for (int i=s1.length() - 1; i>=0; i--){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (!carry){
                if (c1 == '0' && c2 == '0'){
                    res.insert(0,"0");
                    carry = false;
                } else if (c1 == '1' && c2 == '1'){
                    res.insert(0,"0");
                    carry = true;
                } else {
                    res.insert(0,"1");
                    carry = false;
                }
            } else {
                if (c1 == '0' && c2 == '0'){
                    res.insert(0,"1");
                    carry = false;
                } else if (c1 == '1' && c2 == '1'){
                    res.insert(0,"1");
                    carry = true;
                } else {
                    res.insert(0,"0");
                    carry = true;
                }
            }
        }

        if (carry){
            res.insert(0,"1");
        }
        return res.toString();
    }
}
