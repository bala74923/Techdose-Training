package LINKED_LIST.Assignment;

import LINKED_LIST.ListNode;

public class Remove_Duplicates_SortedList_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp= head,newList = new ListNode();
        ListNode ptr = newList;
        while(tmp!=null){
            ListNode nn = tmp;
            int count= 0;
            while(nn!=null && nn.val==tmp.val){
                nn = nn.next;
                count++;
            }
            // creating a new list and append if count is 1
            if(count==1){
                ptr.next = new ListNode(tmp.val);
                ptr=  ptr.next;
            }
            tmp = nn;
        }
        return newList.next;
    }
}
