package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

public class LoopDetectionLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
