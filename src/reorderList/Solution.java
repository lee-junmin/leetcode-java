<<<<<<< HEAD:src/productOfArrayExceptSelf/reorderList/Solution.java
<<<<<<< HEAD:src/reorderList/Solution.java
package reorderList;
// 1 --> 2 --> 3 -->
// 5 --> 4 -->
//
// 1 --> 2 --> 3 -->
// 4 -->
//
=======
package productOfArrayExceptSelf.reorderList;
>>>>>>> 2e25041ef6158910368db56f7eac12c675046411:src/productOfArrayExceptSelf/reorderList/Solution.java

public class Solution {
  public void reorderList(ListNode head) {

    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    
    ListNode second = slow.next;
    ListNode prev = null;
    slow.next = null;
    
    while (second != null){
      ListNode temp = second.next;
      second.next = prev;
      prev = second;
      second = temp;
    } // prev will become the head
    
    ListNode first = head;
    second = prev;
    while (second != null){
      ListNode temp1 = first.next;
      ListNode temp2 = second.next;
      first.next = second;
      second.next = temp1;
      first = temp1;
      second = temp2;
    }
    
  }
}
=======
package reorderList;

public class Solution {
  public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    
    ListNode second = slow.next;
    ListNode prev = null;
    slow.next = null;
    
    while (second != null){
      ListNode temp = second.next;
      second.next = prev;
      prev = second;
      second = temp;
    }
    
    ListNode first = head;
    second = prev;
    while (second != null){
      ListNode temp1 = first.next;
      ListNode temp2 = second.next;
      first.next = second;
      second.next = temp1;
      first = temp1;
      second = temp2;
    }
    
  }
}
>>>>>>> c57bc7df8c3e9f5873419b75a35fb066f1e2dd5c:src/reorderList/Solution.java
