package LINKED_LIST.Assignment;

import LINKED_LIST.ListNode;

public class check_palindrome {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        ListNode list = ListNode.converListToArray(arr);
        ListNode.display(list);
        System.out.println(isPalindrome(list));
    }
    static boolean isPalindrome(ListNode head) {
        ListNode slow  = head,fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow =slow.next;
        }
        ListNode l2 = reverse(fast==null?slow:slow.next);
        return compare(head,l2);
    }
    static boolean compare(ListNode l1,ListNode l2){
        while(l1!=null && l2!=null){
            if(l1.val!=l2.val) return false;
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
    static ListNode reverse(ListNode head){
        ListNode tmp=head,prev=  null;
        while(tmp!=null){
            ListNode nextNode = tmp.next;
            tmp.next = prev;
            prev=  tmp;
            tmp = nextNode;
        }
        return prev;
    }
}
