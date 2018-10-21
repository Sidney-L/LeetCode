class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] copy = strs[i].toCharArray();
            Arrays.sort(copy);
            String str = String.valueOf(copy);
            if(!map.containsKey(str)){
                List<String> l = new LinkedList<String>();
                l.add(strs[i]);
                map.put(str, l);
            }
            else{
                map.get(str).add(strs[i]);
            }
        }
        Collection<List<String>> c = map.values();
        Iterator<List<String>> iter = c.iterator();
        List<List<String>> ans = new LinkedList<List<String>>();
        while(iter.hasNext()) {
            ans.add(iter.next());
        }
        return ans;
    }
}
