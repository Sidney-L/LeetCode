class Solution {
    public int[] plusOne(int[] digits) {
        int[] sum = new int[digits.length];
        int carry = 0;
        for(int i = digits.length-1; i>=0; i--){
            sum[i] = ((i==digits.length-1?1:0) + carry + digits[i])%10;
            carry = ((i==digits.length-1?1:0) + carry + digits[i])/10;
        }
        if(carry==1){
            int[] newSum = new int[sum.length+1];
            int index = newSum.length - 1;
            for(int e: sum)
                newSum[index--] = e;
            newSum[0] = 1;
            return newSum;
        }
        return sum;
    }
}
