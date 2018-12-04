class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        int j = s.length() - 1;
        while(j >= 0 && s.charAt(j) == ' ') j--;
        if(i > j)
            return false;
        s = s.substring(i, j+1);
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);
        if(s.length()==0||s.charAt(0)=='.' && s.length()==1)
            return false;
        int e = 0;
        int dot = 0;
        for(i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) continue;
            if(s.charAt(i) == '.'){
                dot++;
                if(e > 0 || dot > 1)
                    return false;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                e++;
                if(i == 1 && s.charAt(i-1) == '.' || e > 1 || i==0 || i == s.length()-1)
                    return false;
                if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-'){
                    if(i+2==s.length())
                        return false;
                    i++;
                }
            }
            else
                return false;
        }
        return true;
    }
}
