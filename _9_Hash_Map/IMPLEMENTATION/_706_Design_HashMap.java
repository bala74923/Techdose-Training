package _9_Hash_Map.IMPLEMENTATION;

public class _706_Design_HashMap {
    class MyHashMap {
        static class ListNode{
            int key,val;
            ListNode next,prev;
            ListNode(){}
            ListNode(int key,int val){this.key=key;this.val= val;}
        }
        static ListNode prepend(ListNode head, int key,int val){
            ListNode nn = new ListNode(key,val);
            nn.next = head;
            if(head!=null) head.prev=nn;
            head = nn;
            return nn;
        }
        static ListNode search(ListNode head, int key){
            ListNode tmp = head;
            while(tmp!=null){
                if(tmp.key==key) return tmp;
                tmp = tmp.next;
            }
            return null;
        }
        static ListNode delete(ListNode head,ListNode tmp){
            ListNode prevNode = tmp.prev,nextNode = tmp.next;
            if(nextNode!=null)
                nextNode.prev = prevNode;
            if(prevNode==null){
                // deleting head
                return tmp.next;
            }
            prevNode.next = nextNode;
            return head;
        }
        ListNode[] arr ;
        int size;
        public MyHashMap() {
            size = 1000;
            arr = new ListNode[size];
        }

        public void put(int key, int value) {
            ListNode prev = search(arr[key%size],key);
            if(prev!=null) arr[key%size] = delete(arr[key%size], prev);
            arr[key%size] = prepend(arr[key%size],key,value);
        }

        public int get(int key) {
            ListNode prev = search(arr[key%size],key);
            return prev==null?-1:prev.val;
        }

        public void remove(int key) {
            ListNode prev = search(arr[key%size],key);
            if(prev!=null)
                arr[key%size] = delete(arr[key%size], prev);
        }
    }
}
