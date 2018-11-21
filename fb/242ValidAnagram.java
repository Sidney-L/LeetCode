class Solution {
    public boolean isAnagram(String s, String t) {
        /*
         if(s.length() != t.length())
         return false;
         HashMap<Character, Integer> map = new HashMap();
         for(int i = 0; i < s.length();i++)
         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
         for(int i = 0; i < t.length();i++){
         if(!map.containsKey(t.charAt(i)))
         return false;
         else{
         map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
         if(map.get(t.charAt(i)) == 0)
         map.remove(t.charAt(i));
         }
         }
         return map.size() == 0;
         */
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        if(s1.length != t1.length)
            return false;
        Arrays.sort(s1);
        Arrays.sort(t1);
        for(int i = 0; i<s1.length; i++){
            if(s1[i] != t1[i])
                return false;
        }
        return true;
    }
}
