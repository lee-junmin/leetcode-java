package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
  // TC O(m*n) where m is the number of elements and n is the length of the strings
  public List<List<String>> groupAnagrams(String[] strs) {
    
    List<String> anagramList = new ArrayList();
    
    HashMap<HashMap<Character, Integer>, List<String>> seen = new HashMap<>();
    
    for (String s: strs){
      HashMap<Character, Integer> id = stringToMap(s);
      if (seen.containsKey(id)){
        List<String> newList = new ArrayList();
        newList = seen.get(id);
        newList.add(s);
        seen.replace(id, newList);
      } else {
        // create anagram list and add it to res
        List<String> newList = new ArrayList();
        newList.add(s);
        seen.put(id, newList);
      }
    }
    
    
    return new ArrayList<List<String>>(seen.values());
    
  }
  
  private HashMap<Character, Integer> stringToMap(String s){
    HashMap<Character, Integer> res = new HashMap<>();
    char[] charArray = s.toCharArray();
    for(char c: charArray){
      if(res.containsKey(c)){
        int newCount = res.get(c) + 1;
        res.replace(c,newCount);
      } else {
        res.put(c,1);
      }
      
    }
    return res;
  }
  
  public List<List<String>> groupAnagrams_2(String[] strs) {
    
    HashMap<int[], List<String>> seen = new HashMap<>();
    
    for (String s: strs){
      int[] key = mapArray(s);
      seen.putIfAbsent(key,new ArrayList());
      seen.get(key).add(s);
    }
    return new ArrayList<>(seen.values());
  }
  
  private int[] mapArray(String s){
    int[] map = new int[26];
    Arrays.fill(map,0);
    for (char c: s.toCharArray()){
      map[c - 'a']++;
    }
    return map;
  }

}
  
