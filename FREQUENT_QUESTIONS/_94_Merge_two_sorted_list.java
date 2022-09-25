package FREQUENT_QUESTIONS;

public class _94_Merge_two_sorted_list {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ll = new ListNode(-1),head = ll;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val) {
                ll.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                ll.next = new ListNode(l2.val);
                l2= l2.next;
            }
            ll = ll.next;
        }
        while(l1!=null){
            ll.next = new ListNode(l1.val);
            ll= ll.next;
            l1 = l1.next;
        }
        while(l2!=null){
            ll.next = new ListNode(l2.val);
            ll= ll.next;
            l2 = l2.next;
        }
        return head.next;
    }
}
