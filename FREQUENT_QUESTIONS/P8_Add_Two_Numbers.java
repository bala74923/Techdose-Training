package FREQUENT_QUESTIONS;

public class P8_Add_Two_Numbers {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode(),temp = head;
        int carry=0;
        while(l1!=null || l2!=null){
            int a = 0,b=0;
            if(l1!=null) {
                a = l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a+b+carry;
            carry = sum/10;
            sum%=10;
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        if(carry!=0) temp.next = new ListNode(carry);
        return head.next;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}