class Solution {
    public int findKthLargest(int[] nums, int k) {
        return partitionSelect(nums, 0, nums.length-1, k);
    }
    
    private int partitionSelect(int[] a, int l, int r, int k){
        if(l == r)
            return a[l];
        int q = RandomizedPartition(a, l, r);
        int j = q - l + 1;
        if(j == k){
            return a[q];
        }
        else if(k < j){
            return partitionSelect(a, l, q-1, k);
        }
        else
            return partitionSelect(a, q+1, r, k-j);
    }
    
    private int partition(int[] a, int l, int r){
        int x = a[r];
        int i = l - 1;
        for(int j = l; j < r; j++){
            if(a[j] >= x){
                i++;
                exchange(a, i, j);
            }
        }
        exchange(a, i+1, r);
        return i+1;
    }
    
    private int RandomizedPartition(int[] a, int l, int r){
        int rand = (int)(Math.random()*(r-l+1))+l;
        exchange(a, rand, r);
        return partition(a, l, r);
    }
    
    private void exchange(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return;
    }
}
