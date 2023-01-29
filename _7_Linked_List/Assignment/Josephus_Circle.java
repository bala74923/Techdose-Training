package _7_Linked_List.Assignment;

public class Josephus_Circle {

    public static void main(String[] args) {
        System.out.println(solve(3,1));
    }
    static class Node{
        int val;
        Node next,prev;
        Node(){}
        Node(int val){this.val = val;}
    }
    static int solve(int n,int k){
        Node head = null;
        for(int i=1;i<=n;i++)
            head= append(head,i);
        return josephusCircleDeletion(head,k);
    }
    static Node append(Node head,int data){
        if(head ==null){
            head= new Node(data);
            head.next = head;
            head.prev = head;
        }else{
            Node tmp = head;
            while(tmp.next!=head) tmp = tmp.next;
            // tmp is in last node
            Node nn = new Node(data);
            tmp.next = nn;

            nn.prev=  tmp;
            nn.next = head;

            head.prev= nn;
        }
        return head;
    }
    static boolean Cannot_delete(Node prev,Node tmp){
        if(prev==tmp) return true;
        prev.next = tmp.next;
        tmp.next.prev = prev;
        return false;
    }
    static int josephusCircleDeletion(Node head,int k){
        Node tmp = head;
        boolean singleEelemnt=  false;
        while(!singleEelemnt){
            for(int i=1;i<k;i++){
                tmp = tmp.next;
            }
            System.out.println(tmp.val+" is deleted");
            singleEelemnt= Cannot_delete(tmp.prev,tmp);
            tmp = tmp.next;
        }
        return tmp.val;
    }
}
