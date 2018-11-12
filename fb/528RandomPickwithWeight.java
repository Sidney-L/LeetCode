class Solution {
    Random rand;
    int[] sum;
    public Solution(int[] w) {
        rand = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i = 1; i<w.length; i++){
            sum[i] = sum[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
        int rnd = rand.nextInt(sum[sum.length-1])+1;
        //do binary search
        return bsearch(rnd, 0, sum.length-1);
    }
    private int bsearch(int target, int l, int r){
        if(l == r)
            return l;
        int mid = (l+r)/2;
        if(sum[mid] >= target)
            return bsearch(target, l, mid);
        else
            return bsearch(target, mid+1, r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
