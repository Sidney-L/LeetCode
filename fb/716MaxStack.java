class MaxStack {
    Stack<Integer> st;
    Stack<Integer> maxst;
    /** initialize your data structure here. */
    public MaxStack() {
        st = new Stack<Integer>();
        maxst = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if(maxst.isEmpty())
            maxst.push(x);
        else{
            if(x >= maxst.peek())
                maxst.push(x);
            else
                maxst.push(maxst.peek());
        }
    }
    
    public int pop() {
        
        maxst.pop();
        return st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int peekMax() {
        return maxst.peek();
    }
    
    public int popMax() {
        Stack<Integer> temp = new Stack();
        int max = peekMax();
        while(top()!=max){
            temp.push(pop());
        }
        pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
