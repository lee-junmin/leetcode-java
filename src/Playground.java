import java.util.ArrayList;
import java.util.HashMap;

public class Playground {
  
  public static void main(String[] args){
    HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    adjMap.put(1, new ArrayList<>());
    adjMap.put(2, new ArrayList<>());
    for (int key:adjMap.keySet()){
      System.out.println(key);
    }
  }
 
  
}
