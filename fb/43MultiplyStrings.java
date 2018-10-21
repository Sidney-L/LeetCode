class Solution {
    public String multiply(String num1, String num2) {
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        int[] ans = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i >= 0; i--)
            n1[i] = (int)(num1.charAt(num1.length()-i-1) - '0');
        for(int i = num2.length()-1; i >= 0; i--)
            n2[i] = (int)(num2.charAt(num2.length()-i-1) - '0');
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                ans[i+j] += n1[i]*n2[j];
                ans[i+j+1] += ans[i+j]/10;
                ans[i+j] = ans[i+j] % 10;
            }
        }
        
        int index = num1.length() + num2.length() - 1;
        while(index >= 1 && ans[index] == 0)
            index--;
        String res = "";
        for(;index >= 0; index--){
            res += ans[index];
        }
        return res;
    }
}
