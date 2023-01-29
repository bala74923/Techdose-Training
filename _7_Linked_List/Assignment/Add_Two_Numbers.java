package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode ptr  = res;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+ carry;
            carry = sum/10;
            sum%=10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry>0) ptr.next = new ListNode(carry);
        return res.next;
    }
}
