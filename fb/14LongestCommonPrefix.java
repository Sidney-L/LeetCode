class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        if(strs.length==0)
            return "";
        for(String s: strs)
            minLength = Math.min(minLength, s.length());
        for(int i = minLength; i>0; i--){
            String st = "";
            boolean flag = true;
            for(int j = 0; j < strs.length;j++){
                if(j == 0){
                    st = strs[j].substring(0,i);
                }
                else{
                    if(!strs[j].substring(0,i).equals(st)){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                return st;
        }
        return "";
    }
}
