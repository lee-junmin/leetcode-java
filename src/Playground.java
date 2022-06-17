import java.util.ArrayList;
import java.util.List;

public class Playground {

  public static void main(String[] args){

    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    Integer[] arr = list.toArray(new Integer[0]);
    System.out.println(arr.getClass().getName());
    System.out.println(arr[0]);
    int[] test = new int[]{1,2,3};
    System.out.println(test.getClass().getName());


  }
 
  
}
