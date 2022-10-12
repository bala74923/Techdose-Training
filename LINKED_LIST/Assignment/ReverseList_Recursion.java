package LINKED_LIST.Assignment;

import LINKED_LIST.ListNode;

import java.util.List;
import java.util.Scanner;

public class ReverseList_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr  = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        // create list with elements in the array
        ListNode ll = ListNode.converListToArray(arr);

        // reverse list
        ll = reverse(ll);

        //display list
        ListNode.display(ll);
    }
    static ListNode HEAD= null;
    static ListNode reverse(ListNode head){
        if(head==null) return null;
        HEAD = null;
        solve(head);
        return HEAD;
    }
    static ListNode solve(ListNode head){
        if(head.next==null){
            HEAD = head;
            return head;
        }
        ListNode nextEnd = solve(head.next);
        head.next = null; // we will break this bond a->b
        nextEnd.next = head; // create new bond a <- (b<-c)
        return head;
    }

}
