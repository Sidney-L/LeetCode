class Solution {
    /*public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = s.length()-1;
        boolean flag = false;
        while(l < r){
            if(flag && s.charAt(l) != s.charAt(r)){
                return false;
            }
            else if(!flag && s.charAt(l) != s.charAt(r)){
                flag = true;
                if(s.charAt(l+1) == s.charAt(r)&&s.charAt(l) != s.charAt(r-1)){
                    l++;
                    continue;
                }
                else if(s.charAt(l) == s.charAt(r-1)&&s.charAt(l+1) != s.charAt(r))  {
                    r--;
                    continue;
                }
                else if(s.charAt(l) == s.charAt(r-1)&&s.charAt(l+1) == s.charAt(r)){
                    if(l+2 < r-1&&s.charAt(l+2) != s.charAt(r-1) ){
                        r--;
                        continue;
                    }
                    else{
                        l++;
                        continue;
                    }
                }
                else
                    return false;
            }
            else{//s.charAt(l) == s.charAt(r)
                l++;
                r--;
            }
        }
        return true;
    }
     */
    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
}
