class Solution {
    public boolean backspaceCompare(String S, String T) {
        /*
         StringBuffer sb1 = new StringBuffer();
         StringBuffer sb2 = new StringBuffer();
         for(int i = 0; i < S.length(); i++){
         if(S.charAt(i) == '#'){
         if(sb1.length()!=0)
         sb1.deleteCharAt(sb1.length()-1);
         }
         else
         sb1.append(S.charAt(i));
         }
         for(int i = 0; i < T.length(); i++){
         if(T.charAt(i) == '#'){
         if(sb2.length()!=0)
         sb2.deleteCharAt(sb2.length()-1);
         }
         else
         sb2.append(T.charAt(i));
         }
         return sb1.toString().equals(sb2.toString());
         */
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(S.charAt(i) == '#'){
                    skipS++;
                    i--;
                }
                else if(skipS > 0){
                    skipS--;
                    i--;
                }
                else
                    break;
            }
            while(j >= 0){
                if(T.charAt(j) == '#'){
                    skipT++;
                    j--;
                }
                else if(skipT > 0){
                    skipT--;
                    j--;
                }
                else
                    break;
            }
            if(i>=0&&j>=0&&S.charAt(i)!=T.charAt(j))
                return false;
            if((i>=0) != (j>=0))
                return false;
            i--;
            j--;
        }
        return true;
    }
}
