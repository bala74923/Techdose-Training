package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

public class MultiplyList {
    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2= {1,2};

        ListNode l1 = ListNode.converListToArray(num1);
        ListNode l2= ListNode.converListToArray(num2);

        ListNode res =multiply(l1,l2);
        ListNode.display(res);
    }
    static ListNode multiply(ListNode l1,ListNode l2){

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode ans = new ListNode(0);
        ListNode ptr = ans;
        int m = ListNode.size(l1), n = ListNode.size(l2);
        for(int i=1;i<=m+n+1;i++){
            ptr.next = new ListNode(0);
            ptr= ptr.next;
        }
        ListNode start = ans;
        // take a number in l2, multiply with every number in l1
        while(l2!=null){
            ListNode tmp =start, value = l1;
            int carry= 0;
            while(value!=null){
                int sum = tmp.val+(value.val*l2.val)+carry;
                carry = sum/10;
                sum%=10;
                tmp.val=sum;
                // moving both pointer
                tmp = tmp.next;
                value = value.next;
            }
            if(carry>0) tmp.val+=carry;
            start=  start.next;
            l2 = l2.next;
        }
        ListNode res =  reverse(ans);
        // remove all prefix zeros and if it is single zero dont remove
        while(res.next!=null && res.val==0)
            res = res.next;
        return res;
    }
    static ListNode reverse(ListNode list){
        ListNode prev= null,tmp = list;
        while(tmp!=null){
            ListNode nextNode = tmp.next;
            tmp.next= prev;
            prev= tmp;
            tmp = nextNode;
        }
        return prev;
    }
}
