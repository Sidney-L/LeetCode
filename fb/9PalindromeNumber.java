class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(x!=0){
            list.add(x%10);
            x /= 10;
        }
        int l = 0;
        int r = list.size()-1;
        while(l<=r){
            if(list.get(l)!=list.get(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
