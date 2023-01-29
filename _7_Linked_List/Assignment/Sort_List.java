package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

public class Sort_List {
    public static void main(String[] args) {
        // sort linkedlist with merge sort
        int[] arr = {4,3,2,1,5,100,53,9};
        ListNode list = ListNode.converListToArray(arr);
        list=  solution.mergeSort(list);
        ListNode.display(list);
//        ListNode.display(list);
//
//        list= mergeSort(list,null);
//        ListNode.display(list);
    }
    static ListNode mergeSort(ListNode start,ListNode end){
        // if only one element it is already sorted
        if(start==end) {
            return start;
        }
        ListNode middle= getMiddleNode(start,end);
        ListNode newStart = middle.next;
        middle.next = null;
        ListNode list1= mergeSort(start,middle);
        ListNode list2 = mergeSort(newStart,end);
        return merge(list1,list2);
    }

    static ListNode getMiddleNode(ListNode start,ListNode end){
        ListNode fast = start,slow = start;
        while(fast!=end && fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode merge(ListNode l1,ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode ptr= res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ptr.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                ptr.next = new ListNode(l2.val);
                l2= l2.next;
            }
            ptr=  ptr.next;
        }
        while (l1!=null){
            ptr.next = new ListNode(l1.val);
            l1=l1.next;
            ptr=  ptr.next;
        }
        while (l2!=null){
            ptr.next = new ListNode(l2.val);
            l2=l2.next;
            ptr=  ptr.next;
        }
        return res.next;
    }
    // other method
}
class solution{
    static ListNode mergeSort(ListNode start){
        // if only one element it is already sorted
        if(start==null||start.next==null) {
            return start;
        }
        ListNode middle= getMiddleNode(start);
        ListNode newStart = middle.next;
        middle.next = null;
        ListNode list1= mergeSort(start);
        ListNode list2 = mergeSort(newStart);
        return merge(list1,list2);
    }

    static ListNode getMiddleNode(ListNode start){
        ListNode fast = start,slow = start;
        while(fast.next!=null && fast.next.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode merge(ListNode l1,ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode ptr= res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ptr.next = new ListNode(l1.val);
                l1=l1.next;
            }else{
                ptr.next = new ListNode(l2.val);
                l2= l2.next;
            }
            ptr=  ptr.next;
        }
        while (l1!=null){
            ptr.next = new ListNode(l1.val);
            l1=l1.next;
            ptr=  ptr.next;
        }
        while (l2!=null){
            ptr.next = new ListNode(l2.val);
            l2=l2.next;
            ptr=  ptr.next;
        }
        return res.next;
    }
}
