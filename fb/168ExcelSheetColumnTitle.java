class Solution {
    /*public String convertToTitle(int n) {
     char[] map = {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',                          'U', 'V', 'W', 'X', 'Y'};
     String ans = "";
     
     while(n != 0){
     if(ans.length() != 0 && ans.charAt(ans.length()-1) == 'Z'){
     //n--;
     ans += map[n % 26];
     }
     else
     ans += map[n % 26];
     if(ans.length() != 0 && ans.charAt(ans.length()-1) == 'Z')
     n = (n - 1) /26;
     else
     n /= 26;
     }
     StringBuffer s = new StringBuffer(ans);
     return s.reverse().toString();
     }
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        
        return result.toString();
    }
}
