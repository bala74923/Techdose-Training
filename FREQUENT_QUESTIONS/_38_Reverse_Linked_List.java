package FREQUENT_QUESTIONS;

public class _38_Reverse_Linked_List {
    ListNode tail ;
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        this.tail = null;
        get(head);
        return tail;
    }
    ListNode get(ListNode head){
        if(head.next==null){
            this.tail = head;
            return head;
        }
        ListNode nextNode = get(head.next);
        nextNode.next = head;
        head.next=null;
        return head;
    }
}
