package LINKED_LIST;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(ListNode next,int val){
        this.val = val;
        this.next = next;
    }
   public static ListNode converListToArray(int[] arr){
        ListNode ptr = new ListNode(), tmp = ptr;
        for(int n: arr){
            tmp.next = new ListNode(n);
            tmp = tmp.next;
        }
        return ptr.next;
    }
    public static void display(ListNode head){
        ListNode tmp = head;
        while(tmp!=null){
            System.out.print(tmp.val+" => ");
            tmp = tmp.next;
        }
        System.out.println("NULL");
    }
    public static int  size(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
