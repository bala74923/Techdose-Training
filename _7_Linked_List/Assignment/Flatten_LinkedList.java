package _7_Linked_List.Assignment;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

}
public class Flatten_LinkedList {
    // o(1) space o(N) time (just change the links)
    public Node flatten(Node head) {
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                Node tmp = curr.child;
                while(tmp.next!=null){
                    tmp = tmp.next;
                }
                tmp.next=  curr.next;
                if(curr.next!=null) curr.next.prev = tmp;

                // setting currnodes child as current nodes next
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        // display(head);
        return head;
    }
    class Solution {
        Node res,tmp;
        public Node flatten(Node head) {
            res = new Node();
            tmp = res;
            add(head);
            if(res.next!=null)res.next.prev= null;
            return res.next;
        }
        void add(Node curr){
            if(curr==null) return ;

            // tmp.next=  new Node(val =curr.val,prev = tmp)
            tmp.next = new Node();
            tmp.next.val = curr.val;
            tmp.next.prev = tmp;

            tmp = tmp.next;
            add(curr.child);
            add(curr.next);
        }

    }
}
