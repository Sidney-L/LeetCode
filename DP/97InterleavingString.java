class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int s = s3.length();
        if(n+m != s)
            return false;
        boolean[][] table = new boolean[n+1][m+1];
        table[0][0] = true;
        for(int i = 1; i <= n; i++){
            if(s1.substring(0,i).equals(s3.substring(0,i)))
                table[i][0] = true;
            else
                table[i][0] = false;
        }
        for(int j = 1; j <= m; j++){
            if(s2.substring(0,j).equals(s3.substring(0,j)))
                table[0][j] = true;
            else
                table[0][j] = false;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                table[i][j] = (table[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1))||(table[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1))));
            }
        }
        return table[n][m];
    }
}
