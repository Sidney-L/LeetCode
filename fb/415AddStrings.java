
class Solution {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if(length1 == 0)
            return num2;
        if(length2 == 0)
            return num1;
        String ans = "";
        int carry = 0;
        if(length1 < length2){
            for(int i = 0; i < length1; i++){
                ans = ((num1.charAt(length1-1-i) - '0' + num2.charAt(length2-1-i) - '0' + carry) % 10)+ ans;
                carry = (num1.charAt(length1-1-i) - '0' + num2.charAt(length2-1-i) - '0' + carry) / 10;
            }
            for(int i = length2 - length1 - 1; i>=0; i--){
                ans = ((num2.charAt(i) - '0' + carry) % 10) + ans;
                carry = (num2.charAt(i) - '0' + carry) / 10;
            }
        }
        else{
            for(int i = 0; i < length2; i++){
                ans = ((num1.charAt(length1-1-i) - '0' + num2.charAt(length2-1-i) - '0' + carry) % 10)+ ans;
                carry = (num1.charAt(length1-1-i) - '0' + num2.charAt(length2-1-i) - '0' + carry) / 10;
            }
            for(int i = length1 - length2 - 1; i>=0; i--){
                ans = ((num1.charAt(i) - '0' + carry) % 10) + ans;
                carry = (num1.charAt(i) - '0' + carry) / 10;
            }
        }
        if(carry == 1)
            ans = 1+ans;
        return ans;
    }
}
