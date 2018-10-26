class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] m = new boolean[n+1];
        m[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = i-1; j >= 0; j--){
                if(m[j] && wordDict.contains(s.substring(j,i)))
                    m[i] = true;
            }
        }
        return m[s.length()];
    }
}
