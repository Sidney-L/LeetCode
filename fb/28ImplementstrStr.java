class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            else{
                if(haystack.length() - i < needle.length())
                    return -1;
                else if((haystack.substring(i, i+needle.length())).equals(needle)){
                    return i;
                }
                else
                    continue;
            }
        }
        return -1;
    }
}
