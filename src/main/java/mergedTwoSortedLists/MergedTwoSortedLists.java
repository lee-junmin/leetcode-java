/*
  
 main idea is to add the smaller node of list1 and list2.
 
 
 it's always good to have a dummy node at the beginning of linked list problems
 to avoid dealing with edge cases
 
 think that we are creating a new linked list starting with the dummy and ending with the tail
 we put the smaller of list1 and list2 to the tail and update list1 to list1 next
 or list2 to list2 next as we add either of them to the tail. 
 and of course we would need to update tail to tail.next no matter which we add
 
 for the cases where list1 and list2 length is different
 we will add the remaining link list to the tail by simple updating tail.next to the head of the 
 remaining list
 
 and finally we return dummy.next
 
 
 O(n) O(1)
 
 recursive approach would be O(n) O(n)
 
 run a recursive function with parameters,
 the next node of the smaller element, and the other head.
 The recursive function will return the next smaller
 element linked with rest of the sorted element.
 Now point the next of current element to that
*/

package mergedTwoSortedLists;

public class MergedTwoSortedLists {

	 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		 
	      ListNode dummy = new ListNode(0);
	      ListNode tail = dummy;
	      
	      while (list1 != null && list2 != null) {
	        
	        if (list1.val < list2.val){
	          tail.next = list1;
	          list1 = list1.next;
	        } else {
	          tail.next = list2;
	          list2 = list2.next;
	        }
	        
	        tail = tail.next;
	        
	      }
	      
	      if (list1 == null){
	        tail.next = list2;
	      }
	      
	      if (list2 == null){
	        tail.next = list1;
	      }
	      
	      return dummy.next;
	      
	    
	 }
	 
	 //recursive solution
	
        /*
         
         list1: 1 --> 3
         list2: 2 --> 4
        
        f(1,2) --> return 1
            f(3,2) -->  return 2
                f(4,3) --> return 3
                    f(4,null) -> return 4
        */
	
	
	public ListNode mergeTwoLists_r(ListNode list1, ListNode list2) {
		
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		
		
		// 1 --> (3) --> 5
		// 2 --> (4) --> 8
		if (list1.val < list2.val){
			// list1 selected
			list1.next = mergeTwoLists_r(list1.next, list2);
			return list1;
		} else {
			// list2 selected
			list2.next = mergeTwoLists_r(list2.next, list1);
			return list2;
		}
		
		
		
		
	}
	 
	
}

	
	

