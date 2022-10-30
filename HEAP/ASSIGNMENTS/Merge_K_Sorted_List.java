package HEAP.ASSIGNMENTS;

import java.util.PriorityQueue;

public class Merge_K_Sorted_List {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){this.val = val;this.next = next;}
    }
    static ListNode solve(ListNode[] arr){
        int N = arr.length;
        ListNode res = new ListNode(-1);
        ListNode ptr = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b)->a.val-b.val
        );
        for(ListNode list: arr){
            if(list!=null)  pq.add(list);
        }
        while(!pq.isEmpty()){
            ListNode front = pq.poll();
            ListNode nextNode = front.next;
            front.next = null;
            ptr.next = front;
            if(nextNode!=null) pq.add(nextNode);
            ptr = ptr.next;
        }

        return res.next; // removing dummy node
    }
}
