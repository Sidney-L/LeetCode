class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i = 2; i <= n; i++){
            //System.out.println(ans);
            String next = "";
            int count = 0;
            for(int j = 0; j < ans.length(); j++) {
                count++;
                if(j == ans.length()-1 || ans.charAt(j) != ans.charAt(j+1)) {
                    next += count + "" + ans.charAt(j);
                    count = 0;
                }
            }
            
            ans = next;
        }
        return ans;
    }
}
