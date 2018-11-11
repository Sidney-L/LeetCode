class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length())>1)
            return false;
        if(s.length()<t.length()){
            String temp = s;
            s = t;
            t= temp;
        }
        if(s.length() == t.length()){
            int count = 0;
            for(int i =0; i < s.length(); i++){
                if(s.charAt(i)!=t.charAt(i)){
                    count++;
                }
            }
            return count == 1;
        }
        else{// s > t
            int ptr = 0;
            for(int i =0; i < s.length()&&ptr<t.length(); i++){
                if(s.charAt(i)==t.charAt(ptr))
                    ptr++;
            }
            return ptr == t.length();
        }
    }
}
