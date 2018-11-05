class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++){
            if(!map.containsKey(T.charAt(i)))
                map.put(T.charAt(i), 1);
            else
                map.put(T.charAt(i), map.get(T.charAt(i))+1);
        }
        
        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < S.length(); i++){
            if(map.containsKey(S.charAt(i))){
                int count = map.get(S.charAt(i));
                for(int j = 0; j < count; j++){
                    ans.append(S.charAt(i));
                }
                map.remove(S.charAt(i));
            }
        }
        for(int i = 0; i < 26; i++){
            if(map.containsKey((char)(i+'a')))
                for(int j = 0; j < map.get((char)(i+'a')); j++)
                    ans.append((char)(i+'a'));
        }
        return ans.toString();
    }
}
