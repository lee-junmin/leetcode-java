package linkedListCycle;

/*
INTRO
  there are two ways of solving this problem
  1) using a hash set 2) using the Floyd's Tortoise & Hare algorithm
  Floyd's algorithm can be done with O(1) memory
  Hashset would be O(n) and O(n). this will save the visited nodes as we walk along the linked list
  and return True when there is a duplicate node (hasCycle_hash)
  In this solution we will use the Floyd's Tortoise and Hare
  O(n) O(1)
  
  IDEA
  
  there will be two indicators: slow and fast
  slow will move 1 step and fast will move 2 steps
  if there is a loop these two indicators there will be a moment were the two are at the same spot at the same time
  this is because the loop will never end if there is loop and enough opportinities for the two indicators to meet.
  
  STEPS
  1. declare two variables and initiate both with head
  2. while there is a next node for fast (and fast is not null)
  3. update slow and fast
  4. check if they match and return true of they do
  5. if the loop finishes without a match return false
*/

public class Solution {
  public boolean hasCycle(ListNode head) {
    
    if (head == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      
      if (slow.equals(fast)) {
        return true;
      }
    }
    
    return false;
    
  }
}
/*

HashSet solution


public class Solution {
  public boolean hasCycle(ListNode head) {
    
    HashSet<ListNode> seen = new HashSet<>();
    
    ListNode curr = head;
    
    while (curr != null){
      if (seen.contains(curr)){
        return true;
      } else {
        seen.add(curr);
      }
      
      curr = curr.next;
    }
    
    return false;
  }
}*/