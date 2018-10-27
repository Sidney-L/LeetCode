class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<Integer>();
        if(s.length() == 0 || s.length() < p.length())
            return ans;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < p.length(); i++){
            if(!map.containsKey(p.charAt(i))){
                map.put(p.charAt(i), 1);
            }
            else{
                map.put(p.charAt(i), map.get(p.charAt(i))+1);
            }
        }
        int start = 0;
        int end = 0;
        int diff = p.length();
        for(; end < p.length(); end++){
            char temp = s.charAt(end);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)-1);
            }
            if(map.containsKey(temp)&&map.get(temp)>=0)
                diff--;
        }
        if(diff == 0){
            ans.add(0);
        }
        while(end < s.length()){
            char temp = s.charAt(start);
            if(map.containsKey(temp) && map.get(temp) >= 0){
                diff++;
            }
            if(map.containsKey(temp))
                map.put(temp, map.get(temp)+1);
            start++;
            temp = s.charAt(end);
            if(map.containsKey(temp))
                map.put(temp, map.get(temp)-1);
            if(map.containsKey(temp)&&map.get(temp)>=0)
                diff--;
            if(diff == 0)
                ans.add(start);
            end++;
        }
        return ans;
    }
}
