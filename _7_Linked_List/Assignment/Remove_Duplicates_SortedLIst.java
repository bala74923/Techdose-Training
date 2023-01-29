package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

public class Remove_Duplicates_SortedLIst {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while(tmp!=null){
            int val = tmp.val;
            ListNode nn=  tmp;
            while(nn!=null && val==nn.val) nn= nn.next;
            tmp.next = nn;
            tmp = nn;
        }
        return head;
    }
}
