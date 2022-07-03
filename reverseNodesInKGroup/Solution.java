       public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head; // 
        ListNode ktail = null; // tail of the previous group
        ListNode newHead = null; // head of the remaining unprocessed list
        
        while (curr != null){
            int count = 0;
            while (count < k && curr != null){
                curr = head;
                curr = curr.next;
                count++;
            }
            
            if (count == k) {
                ListNode reversedHead = reverse(head,k);
                if (ktail != null) ktail.next = reversedHead;
                if (newHead == null) newHead = reversedHead;
                ktail = head;
                head = curr;
            }
        }
        
        if (ktail != null) ktail.next = head;
        return newHead == null ? head : newHead;

        
        
    }
    
    private ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {          
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }
        return prev;
    }
}