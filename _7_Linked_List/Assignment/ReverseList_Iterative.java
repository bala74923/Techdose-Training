package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

import java.util.Scanner;

public class ReverseList_Iterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr  = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        // create list with elements in the array
        ListNode ll = ListNode.converListToArray(arr);

        // reverse list
        ll = solve(ll);

        //display list
        ListNode.display(ll);
    }
    static ListNode solve(ListNode head){
        ListNode tmp = head, prev= null;
        while(tmp!=null){
            ListNode nextNode= tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = nextNode;
        }
        return prev;
    }
}
