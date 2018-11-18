class Solution {
    public int totalFruit(int[] tree) {
        int max = 0;
        int l = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();//recording the last index of a kind of fruit
        for(int r = 0; r < tree.length; r++){
            map.put(tree[r], r);
            if(map.size() > 2){
                int index = Collections.min(map.values());
                
                map.remove(tree[index]);
                l = index + 1;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
