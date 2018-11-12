class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int l = 0, r = 0; r < s.length(); r++){
            if(!map.containsKey(s.charAt(r)) || map.get(s.charAt(r))==0)
                map.put(s.charAt(r),1);
            else{
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
                while(l<=r){
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                    l++;
                    if(map.get(s.charAt(r)) == 1)
                        break;
                }
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
