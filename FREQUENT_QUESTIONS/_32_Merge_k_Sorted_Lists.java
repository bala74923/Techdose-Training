package FREQUENT_QUESTIONS;

public class _32_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists,0,lists.length-1);
    }
    ListNode mergeSort(ListNode[] lists,int lo,int hi){
        if(lo<hi){
            int mid = (lo+hi)>>1;
            ListNode l1 = mergeSort(lists,lo,mid);
            ListNode l2 = mergeSort(lists,mid+1,hi);
            return merge(l1,l2);
        }
        return (lo>hi)?null:lists[lo];
    }
    ListNode merge(ListNode l1,ListNode l2){
        ListNode head = new ListNode(), temp = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2=l2.next;
            }
            temp = temp.next;
        }
        while(l1!=null){
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1=l1.next;
        }while(l2!=null){
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2=l2.next;
        }
        return head.next;
    }
}
