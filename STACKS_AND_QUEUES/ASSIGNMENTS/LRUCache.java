package STACKS_AND_QUEUES.ASSIGNMENTS;

import java.util.HashMap;
import java.util.Map;
public class LRUCache {
    DListNode head,tail;
    int size,capacity;
    Map<Integer,DListNode> map;
    public LRUCache(int capacity) {
        head = new DListNode(-1,-1);
        tail = head;// o(1) insertion
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DListNode curr=  map.get(key);
            int res = curr.value;
            //delete the old position
            tail = DListNode.DeleteNode(curr,tail);

            // append it to last and update to map
            curr  = new DListNode(key,res);
            map.put(key,curr); //updating the map
            tail = DListNode.appendNode(tail,curr);
            return res;
        }
        return -1;// key not found
    }

    public void put(int key, int value) {
        // if already exist remove it
        if(map.containsKey(key)){
            tail = DListNode.DeleteNode(map.get(key),tail);
            map.remove(key);
            size--;
        }
        if(size==capacity){
            //DListNode.display(head);
            int val = head.next.key;
            tail= DListNode.removeFrontNode(head,tail);
            map.remove(val);
            size--;
        }
        // appending at last
        DListNode curr = new DListNode(key,value);
        tail = DListNode.appendNode(tail,curr);
        map.put(key,curr);
        size++;
    }
}

class DListNode{
    int key,value;
    DListNode next,prev;
    DListNode(int key,int value){
        this.key = key;
        this.value= value;
    }
    static DListNode appendNode(DListNode tail,DListNode node){
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
        return tail;
    }
    static DListNode removeFrontNode(DListNode head,DListNode tail){
        DListNode actualHead = head.next, newHead = actualHead.next;
        head.next = newHead;
        if(newHead==null) tail= head;
        else newHead.prev = head;
        actualHead = null;
        return tail;
    }
    static DListNode DeleteNode(DListNode node,DListNode tail){
        DListNode prevNode= node.prev,nextNode = node.next;
        // deletion at end is different bit easier
        if(nextNode==null){
            prevNode.next  = null;
            tail = prevNode;
            node = null; // for deleting the node
        }else{
            // delete at middle
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node=  null;
        }
        return tail;
    }
    static  void display(DListNode head){
        DListNode tmp= head;
        while (tmp!=null){
            System.out.printf("{key =%d value=%d} ->",tmp.key,tmp.value);
            tmp = tmp.next;
        }
        System.out.println(" done");
    }
}
