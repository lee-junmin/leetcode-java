package removeNthNodeFromLinkedList;
// T O(n) S O(1)
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n){
    
    ListNode dummy = new ListNode(0,head);
    ListNode nAhead = head;
    ListNode oneBefore = dummy;
    
    for (int i=0; i<n; i++){
      nAhead = nAhead.next;
    }
    
    while (nAhead != null){
      nAhead = nAhead.next;
      oneBefore = oneBefore.next;
    }
    
    oneBefore.next = oneBefore.next.next;
    
    return dummy.next;
    
  }
}
