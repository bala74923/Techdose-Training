package LINKED_LIST.Assignment;

import LINKED_LIST.ListNode;

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
