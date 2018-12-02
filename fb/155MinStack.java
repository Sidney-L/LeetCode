class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack();
        minSt = new Stack();
    }
    
    public void push(int x) {
        if(minSt.isEmpty())
            minSt.push(x);
        else{
            if(x <= minSt.peek())
                minSt.push(x);
        }
        st.push(x);
    }
    
    public void pop() {
        if(st.pop().intValue() == minSt.peek().intValue())
            minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
