package STACKS_AND_QUEUES.ASSIGNMENTS;

import java.util.Stack;

class MinStack {
    Stack<Long> st;
    long min= -1;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(long val) {
        if(st.isEmpty()){
            min = val;
            st.push(val);
        }else{
            if(min<=val) st.push(val);
            else{
                // 2*val-min (2*currmin-prevmin)
                st.push(val-min+val);
                min = val;
            }
        }
    }

    public void pop() {
        long p = st.pop();
        if(p<min){
            min = min-p+min;
            // min = 2*min-p
            // 2*currmin-small part
        }
    }

    public int top() {
        // st.peek()<min(in indication)? (this is the elemennt)min: (normal)st.peek()
        return (int)Math.max(st.peek(),min);
    }

    public int getMin() {
        return (int)min;
    }
}

