class KthLargest {
    PriorityQueue<Integer> q;
    int capacity;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<Integer>(k);
        capacity = k;
        for(int i = 0; i<nums.length; i++){
            if(q.size() < k){
                q.offer(nums[i]);
                continue;
            }
            if(q.peek() < nums[i]){
                q.poll();
                q.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(q.size() < capacity){
            q.offer(val);
            return q.peek();
        }
        if(q.peek() < val){
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
