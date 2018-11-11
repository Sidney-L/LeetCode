class Solution {
    public boolean checkValidString(String s) {
        int openl = 0;
        int openh = 0;
        if(s.length() == 0)
            return true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                openl++;
            else
                openl--;
            if(s.charAt(i) !=  ')')
                openh++;
            else
                openh--;
            openl = Math.max(0, openl);
            if(openh < 0)
                return false;
        }
        return openl == 0;
    }
}
