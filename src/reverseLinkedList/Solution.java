package reverseLinkedList;

/*

      1 --> 2 --> 3 --> 4 -->
      p     c     n
 
where n is the number of nodes in the linked list
iterative: T O(n) S O(1)
recursive : T O(n) S O(n)

iterative solution: prev = null, curr = head slides through.
store original next node in oriNext before changing curr.next to prev.

recursive:  basecase is when head == null,
pass in head and tail for each recursion
and pass out the tail we got from the basecase

 */

public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    
    while (curr != null) {
      ListNode temp = curr.next; // temp store to move on
      curr.next = prev; // main switch
      prev = curr; // move on
      curr = temp; // move on
    }
    
    return prev;
    
  }
  /*
  RECURSIVE SOLUTION
  
  public ListNode reverseList(ListNode head) {
    return reverseListInt(head, null);
  }
  
  private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null)
      return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
  }
  */
}
