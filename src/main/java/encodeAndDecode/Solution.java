package encodeAndDecode;

import java.util.ArrayList;
import java.util.List;

/*

* */
public class Solution {
  final static char SEP = ';';
  public static String encode(List<String> strs) {
    StringBuilder res = new StringBuilder();
    for (String s: strs){
      // get length
      int len = s.length();
      // start with
      res.append(len);
      res.append(SEP);
      res.append(s);
    }
    
    return res.toString();
    
  }
  
  public static List<String> decode(String str) {
    List<String> res = new ArrayList<>();
    int currIndex = 0;
  
    while (currIndex<str.length()){
    
      // get the word length - while until meet ;
      StringBuilder length = new StringBuilder();
      while (str.charAt(currIndex) != ';') {
        length.append(str.charAt(currIndex));
        currIndex++;
      }
      int currWordLength = Integer.parseInt(length.toString());
      currIndex++; // after meeting delim go to next character
    
    
      // make word for wordLength
      StringBuilder word = new StringBuilder();
      for (int i=0; i<currWordLength; i++){
        word.append(str.charAt(currIndex));
        currIndex++;
      
      }
    
      // add it to res
      res.add(word.toString());
    }
    return res;
  
  }
  
  
  public static void main (String[] args){
    
    ArrayList<String> input = new ArrayList<>();
    input.add("love");
    input.add("you");
    input.add("**true&&");
    
    System.out.println(encode(input));
    System.out.println(decode(encode(input)));
    
  }
}
