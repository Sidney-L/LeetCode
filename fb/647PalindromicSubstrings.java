class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; i - j >= 0 && i + j < n && s.charAt(i-j)==s.charAt(i+j);j++)
                count++;
            for(int j = 1; i-j+1 >= 0 && i + j < n && s.charAt(i-j+1)==s.charAt(i+j);j++)
                count++;
        }
        return count;
    }
}
