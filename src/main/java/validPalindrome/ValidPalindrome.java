/*
change everything to lowercase and take out the non alphanumerics
then loop half way through while comparing from the end
 */

package validPalindrome;

public class ValidPalindrome {
  
  public static boolean isPalindrome(String s) {
    
    s = s.toLowerCase();
    s = s.replaceAll("[^a-z0-9]", "");
    
    int halfLength = s.length() / 2;
    int fullLength = s.length();
    for (int i = 0; i < halfLength; i++) {
      if (s.charAt(i) != s.charAt(fullLength - 1 - i)) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args){
    boolean answer = isPalindrome("asdff d$sa");
    System.out.println(answer);
  }
}

