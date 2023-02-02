package _8_Stacks_And_Queues.ASSIGNMENTS;

import java.util.List;

/*
consider stack as linked list
1->2->3->4
both insertion ,deletion occurs at head makes this push-O(1), pop-O(1)

now reverse the list ->O(n) time O(1) space
4->3->2->1  stack is reversed
 */
public class _Reverse_a_stack_without_using_extra_space_in_O_n {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data, ListNode next){
            this.data = data;
            this.next = next;
        }
        ListNode(int data ){
            this.data = data;
            this.next = null;
        }
    }
    static class stack{
        ListNode top;
        stack(){
            top = null ;
        }
        void push(int new_data){
            ListNode new_node = new ListNode(new_data);
            if( top == null){
                top = new_node;
            }else{
                new_node.next = top;
                top = new_node;
            }
        }
        int pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            int result = top.data ;
            top = top.next ;
            return result ;
        }
        int peek(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            int result = top.data ;
            return result ;
        }
        // reverse stack
        void reverse(){
            ListNode curr_node = top, prev_node = null, next_node=  null;
            while(curr_node != null){
                next_node = curr_node.next;

                curr_node.next = prev_node;

                prev_node = curr_node;
                curr_node = next_node;
            }
            this.top = prev_node ;
        }
        boolean  isEmpty(){
            return top == null ;
        }
        void print(){
            ListNode curr_node = top;
            while(curr_node != null){
                System.out.print(curr_node.data+"=>");
                curr_node = curr_node.next;
            }
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        stack st = new stack();

        st.push(1);
        st.push(2);
        st.push(3);

        st.print();

        st.reverse();

        st.print();

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }
}
