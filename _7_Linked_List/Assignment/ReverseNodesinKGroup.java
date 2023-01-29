package _7_Linked_List.Assignment;

import _7_Linked_List.ListNode;

import java.util.Scanner;
/*
https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/555294158/
 */
public class ReverseNodesinKGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr  = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        int K = sc.nextInt();

        // create list with elements in the array
        ListNode ll = ListNode.converListToArray(arr);

        ListNode res = solve(ll,K);

        ListNode.display(res);
    }
    static ListNode solve(ListNode head,int K){
        int size = ListNode.size(head); // returns size of list
        ListNode prev = null, tmp = head;
        ListNode preTail = null;
        for(int itr= 0;itr<size/K;itr++){
            ListNode currTail = tmp;
            for(int i=0;i<K;i++){
                ListNode nextNode =  tmp.next;
                tmp.next = prev;
                prev = tmp;
                tmp = nextNode;
            }
            ListNode currHead = prev;// points to new head of block
            if(preTail==null) head = currHead; // first time
            else preTail.next  = currHead;// remaining times
            preTail = currTail;
        }
         preTail.next = tmp;
        return head;
    }
}
