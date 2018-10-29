class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] r = new int[n+1];
        r[0] = 1;
        r[1] = 1;
        boolean valid = true;
        if(s.charAt(0) == '0')
            return 0;
        for(int i = 2; i <= n; i++){
            if(s.charAt(i-2) == '1' && s.charAt(i-1)!='0'){
                r[i] = r[i-2]+r[i-1];
            }
            else if(s.charAt(i-2)== '2' && s.charAt(i-1)!='0' && s.charAt(i-1)!='7' && s.charAt(i-1)!='8' &&s.charAt(i-1)!='9'){
                r[i] = r[i-2]+r[i-1];
            }
            else if((s.charAt(i-2)=='1' || s.charAt(i-2)=='2')&&s.charAt(i-1)=='0')
                r[i] = r[i-2];
            else if(s.charAt(i-2)!='1' && s.charAt(i-2)!='2' && s.charAt(i-1)=='0'){
                valid = false;
                break;
            }
            else
                r[i] = r[i-1];
        }
        if(valid)
            return r[n];
        else
            return 0;
    }
}
